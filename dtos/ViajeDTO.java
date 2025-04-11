package com.miempresa.gestionReservas.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViajeDTO {

    private Long id;

    @NotBlank(message = "El destino no puede estar vacío")
    @Size(max = 100, message = "El destino no debe superar los 100 caracteres")
    private String destino;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(max = 255, message = "La descripción no debe superar los 255 caracteres")
    private String descripcion;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor que cero")
    private Double precio;
}