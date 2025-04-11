package com.miempresa.gestionReservas.controllers;

import com.miempresa.gestionReservas.dtos.PagoDTO;
import com.miempresa.gestionReservas.services.ServicePago;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final ServicePago servicePago;

    public PagoController(ServicePago servicePago) {
        this.servicePago = servicePago;
    }

    @Operation(summary = "Listar todos los pagos")
    @GetMapping
    public List<PagoDTO> listarPagos() {
        return servicePago.listarPagos();
    }

    @Operation(summary = "Realizar un pago")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Pago realizado"),
            @ApiResponse(responseCode = "400", description = "Datos incorrectos")
    })
    @PostMapping
    public PagoDTO realizarPago(@RequestBody @Valid PagoDTO pagoDTO) {
        return servicePago.realizarPago(pagoDTO);
    }
}