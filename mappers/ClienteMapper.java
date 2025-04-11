package com.miempresa.gestionReservas.mappers;

import com.miempresa.gestionReservas.dtos.ClienteDTO;
import com.miempresa.gestionReservas.entidades.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteDTO toDTO(Cliente cliente);
    Cliente toEntity(ClienteDTO clienteDTO);
}
