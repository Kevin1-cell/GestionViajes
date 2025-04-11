package com.miempresa.gestionReservas.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagoDTO {

    private Long id;

    @NotBlank(message = "El espacio no puede estar vacio")
    @Size(max = 50, message = "El método de pago no debe superar los 50 caracteres")
    private String metodoPago;

    @NotNull(message = "El monto es obligatorio")
    @Positive(message = "El monto debe ser mayor a 0")
    private Double monto;

    @NotBlank(message = "El espacio no puede estar vacio")
    private String fechaPago;

    @NotBlank(message = "El estado no puede estar vacío")
    @Pattern(regexp = "PENDIENTE|PAGADO|RECHAZADO", message = "El estado debe ser PENDIENTE, PAGADO o RECHAZADO")
    private String estado;

    @NotNull(message = "El ID de la reserva es obligatorio")
    private Long idReserva;
}
