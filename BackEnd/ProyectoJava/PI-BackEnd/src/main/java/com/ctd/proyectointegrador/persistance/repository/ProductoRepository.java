package com.ctd.proyectointegrador.persistance.repository;
import com.ctd.proyectointegrador.persistance.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query(
            value = "SELECT * FROM Productos p WHERE p.ciudad_id = ?1",
            nativeQuery = true)
    List<Producto> listarPorCiudad(Long id);

    @Query(value = "SELECT p.* FROM Productos p INNER JOIN Reservas r ON p.id = r.producto_id WHERE p.ciudad = ?1 AND r.check_in = ?2 AND check_out = ?3 ", nativeQuery = true)
    List<Producto> listarPorFechaYCiudad(Long ciudad_id, String checkInD, String checkOut);

}
