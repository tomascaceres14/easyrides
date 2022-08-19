package com.ctd.proyectointegrador.persistance.repository;

import com.ctd.proyectointegrador.persistance.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<Producto, Integer> {
}
