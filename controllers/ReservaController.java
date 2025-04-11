package com.miempresa.gestionReservas.controllers;

import com.miempresa.gestionReservas.dtos.ReservaDTO;
import com.miempresa.gestionReservas.services.ServiceReserva;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ServiceReserva serviceReserva;

    public ReservaController(ServiceReserva serviceReserva) {
        this.serviceReserva = serviceReserva;
    }

    @Operation(summary = "Listar todas las reservas")
    @GetMapping
    public List<ReservaDTO> listarReservas() {
        return serviceReserva.listarReservas();
    }

    @Operation(summary = "Crear una nueva reserva")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Reserva creada"),
            @ApiResponse(responseCode = "400", description = "Datos incorrectos")
    })
    @PostMapping
    public ReservaDTO crearReserva(@RequestBody @Valid ReservaDTO reservaDTO) {
        return serviceReserva.crearReserva(reservaDTO);
    }
}