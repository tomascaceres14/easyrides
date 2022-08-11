package com.ctd.proyectointegrador.repository;

import com.ctd.proyectointegrador.persistance.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository  extends JpaRepository<Categoria, Integer> {
}
