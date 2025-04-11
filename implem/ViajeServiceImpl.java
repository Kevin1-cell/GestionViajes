package com.miempresa.gestionReservas.implem;

import com.miempresa.gestionReservas.dtos.ViajeDTO;
import com.miempresa.gestionReservas.entidades.Viaje;
import com.miempresa.gestionReservas.exceptions.RecursoNoEncontradoException;
import com.miempresa.gestionReservas.mappers.ViajeMapper;
import com.miempresa.gestionReservas.repositories.RepoViaje;
import com.miempresa.gestionReservas.services.ServiceViaje;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ViajeServiceImpl implements ServiceViaje {

    private final RepoViaje repoViaje;
    private final ViajeMapper viajeMapper;

    public ViajeServiceImpl(RepoViaje repoViaje, ViajeMapper viajeMapper) {
        this.repoViaje = repoViaje;
        this.viajeMapper = viajeMapper;
    }

    @Override
    public List<ViajeDTO> listarViajes() {
        return repoViaje.findAll()
                .stream()
                .map(viajeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ViajeDTO obtenerViajeId(Long id) {
        Viaje viaje = repoViaje.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Viaje con ID " + id + " no encontrado"));
        return viajeMapper.toDTO(viaje);
    }

    @Override
    public ViajeDTO crearViaje(ViajeDTO viajeDTO) {
        if (viajeDTO.getPrecio() < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        Viaje viaje = viajeMapper.toEntity(viajeDTO);
        viaje = repoViaje.save(viaje);
        return viajeMapper.toDTO(viaje);
    }

    @Override
    public ViajeDTO actualizarViaje(Long id, ViajeDTO viajeDTO) {
        if (viajeDTO.getPrecio() < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        Viaje viaje = repoViaje.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Viaje con ID " + id + " no encontrado"));
        viaje.setDestino(viajeDTO.getDestino());
        viaje.setDescripcion(viajeDTO.getDescripcion());
        viaje.setPrecio(viajeDTO.getPrecio());
        viaje = repoViaje.save(viaje);
        return viajeMapper.toDTO(viaje);
    }

    @Override
    public void eliminarViaje(Long id) {
        if (!repoViaje.existsById(id)) {
            throw new RecursoNoEncontradoException("Viaje con ID " + id + " no encontrado");
        }
        repoViaje.deleteById(id);
    }
}
