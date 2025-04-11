package com.miempresa.gestionReservas.implem;

import com.miempresa.gestionReservas.dtos.ClienteDTO;
import com.miempresa.gestionReservas.entidades.Cliente;
import com.miempresa.gestionReservas.mappers.ClienteMapper;
import com.miempresa.gestionReservas.repositories.RepoCliente;
import com.miempresa.gestionReservas.services.ServiceCliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl  implements ServiceCliente{

    private final RepoCliente repoCliente;
    private final ClienteMapper clienteMapper;

    public ClienteServiceImpl(RepoCliente repoCliente, ClienteMapper clienteMapper) {
        this.repoCliente = repoCliente;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public List<ClienteDTO> listarClientes() {
        return repoCliente.findAll()
                .stream()
                .map(clienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        cliente = repoCliente.save(cliente);
        return clienteMapper.toDTO(cliente);
    }
}
