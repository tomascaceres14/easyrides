package com.ctd.proyectointegrador.persistance.repository;

import com.ctd.proyectointegrador.persistance.model.Caracteristica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaracteristicasRepository extends JpaRepository<Caracteristica, Integer> {
}
