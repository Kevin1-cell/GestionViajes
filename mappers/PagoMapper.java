package com.miempresa.gestionReservas.mappers;

import com.miempresa.gestionReservas.dtos.PagoDTO;
import com.miempresa.gestionReservas.entidades.Pago;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PagoMapper {
    @Mapping(source = "reserva.id", target = "idReserva")
    PagoDTO toDTO(Pago pago);
    @Mapping(source = "idReserva", target = "reserva.id")
    Pago toEntity(PagoDTO pagoDTO);
}
