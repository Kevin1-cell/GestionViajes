package com.miempresa.gestionReservas.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fechaReserva;
    private String estado;

    @ManyToOne
    private Viaje viaje;

    @ManyToOne
    private Cliente cliente;
}
