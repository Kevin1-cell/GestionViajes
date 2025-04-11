package com.miempresa.gestionReservas.services;

import com.miempresa.gestionReservas.dtos.PagoDTO;
import java.util.List;

public interface ServicePago {
    List<PagoDTO> listarPagos();
    PagoDTO realizarPago(PagoDTO pagoDTO);
}
