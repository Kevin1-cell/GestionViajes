package com.miempresa.gestionReservas.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String metodoPago;
    private Double monto;
    private String fechaPago;
    private String estado;

    @ManyToOne
    private Reserva reserva;
}
