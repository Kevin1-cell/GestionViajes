package com.miempresa.gestionReservas.repositories;

import com.miempresa.gestionReservas.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoCliente extends JpaRepository<Cliente, Long> {

}
