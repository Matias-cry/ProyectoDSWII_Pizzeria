package com.pizzeria.api_pizzeria.service;

import com.pizzeria.api_pizzeria.dto.ProductoRequestDTO;
import com.pizzeria.api_pizzeria.dto.ProductoResponseDTO;
import com.pizzeria.api_pizzeria.model.Producto;
import com.pizzeria.api_pizzeria.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    private ProductoResponseDTO toDTO(Producto p) {
        ProductoResponseDTO dto = new ProductoResponseDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setDescripcion(p.getDescripcion());
        dto.setPrecio(p.getPrecio());
        dto.setActivo(p.getActivo());
        return dto;
    }

    private Producto toEntity(ProductoRequestDTO dto) {
        Producto p = new Producto();
        p.setNombre(dto.getNombre());
        p.setDescripcion(dto.getDescripcion());
        p.setPrecio(dto.getPrecio());
        return p;
    }

    @Transactional(readOnly = true)
    public List<ProductoResponseDTO> listarActivos() {
        return productoRepository.findByActivoTrue()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<ProductoResponseDTO> buscarPorId(Long id) {
        return productoRepository.findById(id)
                .filter(Producto::getActivo)
                .map(this::toDTO);
    }

    @Transactional
    public ProductoResponseDTO crear(ProductoRequestDTO dto) {
        Producto producto = toEntity(dto);
        return toDTO(productoRepository.save(producto));
    }

    @Transactional
    public Optional<ProductoResponseDTO> actualizar(Long id, ProductoRequestDTO dto) {
        return productoRepository.findById(id)
                .filter(Producto::getActivo)
                .map(p -> {
                    p.setNombre(dto.getNombre());
                    p.setDescripcion(dto.getDescripcion());
                    p.setPrecio(dto.getPrecio());
                    return toDTO(productoRepository.save(p));
                });
    }

    @Transactional
    public boolean eliminar(Long id) {
        return productoRepository.findById(id)
                .filter(Producto::getActivo)
                .map(p -> {
                    p.setActivo(false);
                    productoRepository.save(p);
                    return true;
                }).orElse(false);
    }
}
