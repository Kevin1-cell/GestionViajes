package com.miempresa.gestionReservas.mappers;

import com.miempresa.gestionReservas.dtos.ViajeDTO;
import com.miempresa.gestionReservas.entidades.Viaje;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ViajeMapper {
    ViajeDTO toDTO(Viaje viaje);
    Viaje toEntity(ViajeDTO viajeDTO);
}
