package com.miempresa.gestionReservas.repositories;

import com.miempresa.gestionReservas.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoReserva extends JpaRepository<Reserva, Long>{

}
