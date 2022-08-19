package com.ctd.proyectointegrador.persistance.repository;

import com.ctd.proyectointegrador.persistance.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadesRepository extends JpaRepository<Ciudad, Integer> {
}
