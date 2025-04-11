package com.miempresa.gestionReservas.services;

import com.miempresa.gestionReservas.dtos.ClienteDTO;
import java.util.List;

public interface ServiceCliente {
    List<ClienteDTO> listarClientes();
    ClienteDTO crearCliente(ClienteDTO clienteDTO);
}
