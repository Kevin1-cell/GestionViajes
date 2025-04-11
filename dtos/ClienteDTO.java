package com.miempresa.gestionReservas.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id;

    @NotBlank(message = "El espacio no puede estar vacio")
    @Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
    private String nombre;

    @NotBlank(message = "El email no puede estar vacío")
    @Email(message = "El email debe tener un formato válido")
    private String email;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Pattern(regexp = "\\d{10}", message = "El teléfono debe tener entre 10 dígitos numéricos")
    private String telefono;

    @NotBlank(message = "La dirección no puede estar vacía")
    @Size(max = 200, message = "La dirección no debe superar los 200 caracteres")
    private String direccion;
}
