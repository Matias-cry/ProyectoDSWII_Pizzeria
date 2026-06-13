package com.pizzeria.api_pizzeria.service;

import com.pizzeria.api_pizzeria.dto.*;
import com.pizzeria.api_pizzeria.model.DetallePedido;
import com.pizzeria.api_pizzeria.model.Pedido;
import com.pizzeria.api_pizzeria.model.Producto;
import com.pizzeria.api_pizzeria.model.Cliente;
import com.pizzeria.api_pizzeria.model.CuponDescuento;
import com.pizzeria.api_pizzeria.repository.ClienteRepository;
import com.pizzeria.api_pizzeria.repository.PedidoRepository;
import com.pizzeria.api_pizzeria.repository.ProductoRepository;
import com.pizzeria.api_pizzeria.repository.CuponDescuentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;
    private final ClienteRepository clienteRepository;
    private final CuponDescuentoRepository cuponRepository;

    private DetallePedidoResponseDTO detalleToDTO(DetallePedido d) {
        DetallePedidoResponseDTO dto = new DetallePedidoResponseDTO();
        dto.setId(d.getId());
        dto.setProductoId(d.getProducto().getId());
        dto.setProductoNombre(d.getProducto().getNombre());
        dto.setCantidad(d.getCantidad());
        dto.setPrecioUnitario(d.getPrecioUnitario());
        dto.setSubtotal(d.getSubtotal());
        return dto;
    }

    private PedidoResponseDTO pedidoToDTO(Pedido pedido) {
        PedidoResponseDTO dto = new PedidoResponseDTO();
        dto.setId(pedido.getId());
        // Modificado para usar el método getClienteNombre() mapeado desde el objeto Cliente
        dto.setClienteNombre(pedido.getClienteNombre());
        dto.setFechaPedido(pedido.getFechaPedido());
        dto.setEstado(pedido.getEstado());
        dto.setTotal(pedido.getTotal());
        dto.setDetalles(
                pedido.getDetalles().stream()
                        .map(this::detalleToDTO)
                        .collect(Collectors.toList())
        );
        return dto;
    }

    @Transactional
    public PedidoResponseDTO crear(PedidoRequestDTO requestDTO) {
        Pedido pedido = new Pedido();

        Cliente cliente = clienteRepository.findByClienteNombre(requestDTO.getClienteNombre())
                .orElseGet(() -> {
                    Cliente nuevoCliente = new Cliente();
                    nuevoCliente.setClienteNombre(requestDTO.getClienteNombre());
                    return clienteRepository.save(nuevoCliente);
                });

        pedido.setCliente(cliente);

        BigDecimal total = BigDecimal.ZERO;

        for (DetallePedidoRequestDTO detalleDTO : requestDTO.getDetalles()) {
            Producto producto = productoRepository.findById(detalleDTO.getProductoId())
                    .filter(Producto::getActivo)
                    .orElseThrow(() -> new RuntimeException(
                            "Producto no encontrado o inactivo: ID " + detalleDTO.getProductoId()
                    ));

            DetallePedido detalle = new DetallePedido();
            detalle.setPedido(pedido);
            detalle.setProducto(producto);
            detalle.setCantidad(detalleDTO.getCantidad());
            detalle.setPrecioUnitario(producto.getPrecio());

            BigDecimal subtotal = producto.getPrecio()
                    .multiply(BigDecimal.valueOf(detalleDTO.getCantidad()));
            detalle.setSubtotal(subtotal);

            pedido.getDetalles().add(detalle);
            total = total.add(subtotal);
        }

        // MODIFICACIÓN PARA CUPONES:
        if (requestDTO.getCodigoCupon() != null && !requestDTO.getCodigoCupon().isBlank()) {
            String codigoBuscado = requestDTO.getCodigoCupon().toUpperCase().trim();

            CuponDescuento cupon = cuponRepository.findByCodigo(codigoBuscado)
                    .orElseThrow(() -> new RuntimeException("El cupón '" + codigoBuscado + "' no existe."));

            if (!cupon.esValido()) {
                throw new RuntimeException("El cupón '" + codigoBuscado + "' ya no es válido o ha expirado.");
            }

            BigDecimal porcentaje = cupon.getPorcentajeDescuento().divide(new BigDecimal("100"));
            BigDecimal descuento = total.multiply(porcentaje);

            total = total.subtract(descuento);

            pedido.setCupon(cupon);

            cupon.setUsoActual(cupon.getUsoActual() + 1);
            cuponRepository.save(cupon);
        }

        pedido.setTotal(total);
        return pedidoToDTO(pedidoRepository.save(pedido));
    }

    @Transactional(readOnly = true)
    public List<PedidoResponseDTO> listarTodos() {
        return pedidoRepository.findAll()
                .stream().map(this::pedidoToDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<PedidoResponseDTO> buscarPorId(Long id) {
        return pedidoRepository.findById(id).map(this::pedidoToDTO);
    }

    @Transactional
    public Optional<PedidoResponseDTO> actualizarEstado(Long id, String nuevoEstado) {
        return pedidoRepository.findById(id).map(p -> {
            p.setEstado(nuevoEstado);
            return pedidoToDTO(pedidoRepository.save(p));
        });
    }
}
