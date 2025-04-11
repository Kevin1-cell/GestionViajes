package com.miempresa.gestionReservas.controllers;

import com.miempresa.gestionReservas.dtos.ClienteDTO;
import com.miempresa.gestionReservas.services.ServiceCliente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ServiceCliente serviceCliente;

    public ClienteController(ServiceCliente serviceCliente) {
        this.serviceCliente = serviceCliente;
    }

    @Operation(summary = "Listar todos los clientes")
    @GetMapping
    public List<ClienteDTO> listarClientes() {
        return serviceCliente.listarClientes();
    }

    @Operation(summary = "Crear un nuevo cliente")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cliente creado"),
            @ApiResponse(responseCode = "400", description = "Datos incorrectos")
    })
    @PostMapping
    public ClienteDTO crearCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        return serviceCliente.crearCliente(clienteDTO);
    }
}