package com.pizzeria.api_pizzeria.service;

import com.pizzeria.api_pizzeria.dto.ClienteRequestDTO;
import com.pizzeria.api_pizzeria.dto.ClienteResponseDTO;
import com.pizzeria.api_pizzeria.model.Cliente;
import com.pizzeria.api_pizzeria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public ClienteResponseDTO guardar(ClienteRequestDTO dto) {

        Cliente cliente = new Cliente();

        // 💻 CORREGIDO: Ahora usamos setClienteNombre apuntando al método del DTO
        cliente.setClienteNombre(dto.getNombre());
        cliente.setDni(dto.getDni());
        cliente.setTelefono(dto.getTelefono());
        cliente.setDireccion(dto.getDireccion());

        cliente = repository.save(cliente);

        ClienteResponseDTO response = new ClienteResponseDTO();

        // Asumiendo que tu entidad Cliente ahora usa getIdCliente() o getId() según lo definieras
        response.setId(cliente.getId());

        // 💻 CORREGIDO: Obtenemos el nombre usando getClienteNombre() del modelo
        response.setNombre(cliente.getClienteNombre());
        response.setDni(cliente.getDni());
        response.setTelefono(cliente.getTelefono());
        response.setDireccion(cliente.getDireccion());

        return response;
    }
    public List<ClienteResponseDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(cliente -> {
                    ClienteResponseDTO dto = new ClienteResponseDTO();

                    // Ajusta si tu ID en la clase Cliente se llama idCliente
                    dto.setId(cliente.getId());

                    // 💻 CORREGIDO: Mapeo del modelo al DTO con la nueva variable
                    dto.setNombre(cliente.getClienteNombre());
                    dto.setDni(cliente.getDni());
                    dto.setTelefono(cliente.getTelefono());
                    dto.setDireccion(cliente.getDireccion());

                    return dto;
                })
                .collect(Collectors.toList());
    }
}