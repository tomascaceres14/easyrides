package com.ctd.ProyectoIntegrador.repository;

import com.ctd.ProyectoIntegrador.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository  extends JpaRepository<Categoria, Integer> {
}
