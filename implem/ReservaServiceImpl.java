package com.miempresa.gestionReservas.implem;

import com.miempresa.gestionReservas.dtos.ReservaDTO;
import com.miempresa.gestionReservas.entidades.Reserva;
import com.miempresa.gestionReservas.mappers.ReservaMapper;
import com.miempresa.gestionReservas.repositories.RepoReserva;
import com.miempresa.gestionReservas.services.ServiceReserva;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
//FALTA LO RELACIONADO CON USUARIOS Y PAGOS
@Service
public class ReservaServiceImpl implements ServiceReserva {

    private final RepoReserva repoReserva;
    private final ReservaMapper reservaMapper;

    public ReservaServiceImpl(RepoReserva repoReserva, ReservaMapper reservaMapper) {
        this.repoReserva = repoReserva;
        this.reservaMapper = reservaMapper;
    }

    @Override
    public List<ReservaDTO> listarReservas() {
        return repoReserva.findAll()
                .stream()
                .map(reservaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservaDTO crearReserva(ReservaDTO reservaDTO) {
        Reserva reserva = reservaMapper.toEntity(reservaDTO);
        reserva = repoReserva.save(reserva);
        return reservaMapper.toDTO(reserva);
    }
}
