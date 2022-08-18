package com.ctd.proyectointegrador.persistance.repository;

import com.ctd.proyectointegrador.persistance.model.Ciudades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadesRepository extends JpaRepository<Ciudades, Integer> {
}
