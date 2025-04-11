package com.miempresa.gestionReservas.mappers;

import com.miempresa.gestionReservas.dtos.ReservaDTO;
import com.miempresa.gestionReservas.entidades.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservaMapper {
    @Mapping(source = "viaje.id", target = "idViaje")
    @Mapping(source = "cliente.id", target = "idCliente")
    ReservaDTO toDTO(Reserva reserva);

    @Mapping(source = "idViaje", target = "viaje.id")
    @Mapping(source = "idCliente", target = "cliente.id")
    Reserva toEntity(ReservaDTO reservaDTO);
}
