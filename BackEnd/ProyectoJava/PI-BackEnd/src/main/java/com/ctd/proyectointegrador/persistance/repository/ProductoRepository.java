package com.ctd.proyectointegrador.persistance.repository;
import com.ctd.proyectointegrador.persistance.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(
            value = "SELECT * FROM Producto p WHERE p.ciudad_id = ?1",
            nativeQuery = true)
    List<Producto> listarPorCiudad(Integer id);
}
