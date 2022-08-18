package com.ctd.proyectointegrador.persistance.repository;

import com.ctd.proyectointegrador.persistance.model.Caracteristicas;
import com.ctd.proyectointegrador.persistance.model.Imagenes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenesRepository extends JpaRepository<Imagenes, Integer> {
}
