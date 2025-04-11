package com.miempresa.gestionReservas.services;

import com.miempresa.gestionReservas.dtos.ViajeDTO;
import java.util.List;

public interface ServiceViaje {
    List<ViajeDTO> listarViajes();
    ViajeDTO obtenerViajeId(Long id);
    ViajeDTO crearViaje(ViajeDTO viajeDTO);
    ViajeDTO actualizarViaje(Long id, ViajeDTO viajeDTO);
    void eliminarViaje(Long id);
}
