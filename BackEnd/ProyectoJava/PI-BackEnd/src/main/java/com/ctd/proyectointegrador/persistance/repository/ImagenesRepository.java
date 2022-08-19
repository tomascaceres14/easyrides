package com.ctd.proyectointegrador.persistance.repository;

import com.ctd.proyectointegrador.persistance.model.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenesRepository extends JpaRepository<Imagen, Integer> {
}
