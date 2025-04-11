package com.miempresa.gestionReservas.controllers;

import com.miempresa.gestionReservas.dtos.ViajeDTO;
import com.miempresa.gestionReservas.services.ServiceViaje;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/viajes")
public class ViajeController {

    private final ServiceViaje serviceViaje;

    public ViajeController(ServiceViaje serviceViaje) {
        this.serviceViaje = serviceViaje;
    }

    @Operation(summary = "Listar todos los viajes")
    @GetMapping
    public ResponseEntity<List<ViajeDTO>> listarViajes() {
        return ResponseEntity.ok(serviceViaje.listarViajes());
    }

    @Operation(summary = "Obtener los detalles de un viaje por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Viaje encontrado"),
            @ApiResponse(responseCode = "404", description = "Viaje no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ViajeDTO> obtenerViajeId(@PathVariable Long id) {
        return ResponseEntity.ok(serviceViaje.obtenerViajeId(id));
    }

    @Operation(summary = "Crear un nuevo viaje")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Viaje creado"),
            @ApiResponse(responseCode = "400", description = "Datos incorrectos")
    })
    @PostMapping
    public ResponseEntity<ViajeDTO> crearViaje(@RequestBody @Valid ViajeDTO viajeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceViaje.crearViaje(viajeDTO));
    }

    @Operation(summary = "Actualizar un viaje existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Viaje actualizado"),
            @ApiResponse(responseCode = "404", description = "Viaje no encontrado"),
            @ApiResponse(responseCode = "400", description = "Datos incorrectos")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ViajeDTO> actualizarViaje(@PathVariable Long id, @RequestBody @Valid ViajeDTO viajeDTO) {
        return ResponseEntity.ok(serviceViaje.actualizarViaje(id, viajeDTO));
    }

    @Operation(summary = "Eliminar un viaje por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Viaje eliminado"),
            @ApiResponse(responseCode = "404", description = "Viaje no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarViaje(@PathVariable Long id) {
        serviceViaje.eliminarViaje(id);
        return ResponseEntity.noContent().build();
    }
}
