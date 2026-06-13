package com.pizzeria.api_pizzeria.service;

import com.pizzeria.api_pizzeria.dto.CuponRequestDTO;
import com.pizzeria.api_pizzeria.dto.CuponResponseDTO;
import com.pizzeria.api_pizzeria.model.CuponDescuento;
import com.pizzeria.api_pizzeria.repository.CuponDescuentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CuponDescuentoService {

    private final CuponDescuentoRepository cuponRepository;

    private CuponResponseDTO toDTO(CuponDescuento cupon) {
        CuponResponseDTO dto = new CuponResponseDTO();
        dto.setId(cupon.getId());
        dto.setCodigo(cupon.getCodigo());
        dto.setPorcentajeDescuento(cupon.getPorcentajeDescuento());
        dto.setFechaExpiracion(cupon.getFechaExpiracion());
        dto.setUsoMaximo(cupon.getUsoMaximo());
        dto.setUsoActual(cupon.getUsoActual());
        dto.setActivo(cupon.getActivo());
        return dto;
    }

    @Transactional
    public CuponResponseDTO guardar(CuponRequestDTO dto) {
        CuponDescuento cupon = new CuponDescuento();
        cupon.setCodigo(dto.getCodigo().toUpperCase().trim()); // Lo guardamos siempre en mayúsculas
        cupon.setPorcentajeDescuento(dto.getPorcentajeDescuento());
        cupon.setFechaExpiracion(dto.getFechaExpiracion());
        cupon.setUsoMaximo(dto.getUsoMaximo());

        return toDTO(cuponRepository.save(cupon));
    }

    @Transactional(readOnly = true)
    public List<CuponResponseDTO> listarTodos() {
        return cuponRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
