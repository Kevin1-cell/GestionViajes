package com.miempresa.gestionReservas.services;

import com.miempresa.gestionReservas.dtos.ReservaDTO;

import java.util.List;

public interface ServiceReserva {
    List<ReservaDTO> listarReservas();
    ReservaDTO crearReserva(ReservaDTO reservaDTO);
}
