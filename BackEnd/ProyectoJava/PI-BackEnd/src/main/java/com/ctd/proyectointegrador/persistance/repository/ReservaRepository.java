package com.ctd.proyectointegrador.persistance.repository;


import com.ctd.proyectointegrador.persistance.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}
