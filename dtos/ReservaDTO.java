package com.miempresa.gestionReservas.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaDTO {

    private Long id;

    @NotBlank(message = "El espacio no puede estar vacio")
    private String fechaReserva;

    @NotBlank(message = "El estado de la reserva no puede estar vacío")
    @Pattern(
            regexp = "CONFIRMADA|CANCELADA|PENDIENTE",
            message = "El estado debe ser CONFIRMADA, CANCELADA o PENDIENTE"
    )
    private String estado;

    @NotNull(message = "El ID del viaje es obligatorio")
    private Long idViaje;

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long idCliente;
}