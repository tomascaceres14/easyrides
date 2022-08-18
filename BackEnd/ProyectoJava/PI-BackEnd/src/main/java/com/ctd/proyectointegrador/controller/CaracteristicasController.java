package com.ctd.proyectointegrador.controller;

import com.ctd.proyectointegrador.persistance.dto.CaracteristicasDTO;
import com.ctd.proyectointegrador.service.impl.CaracteristicasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Caracteristicas")
public class CaracteristicasController {
    @Autowired
    CaracteristicasService caracteristicaService;

    @Autowired
    Map<String, Object> response = new HashMap<>();

    private Integer codigo;

    @PostMapping()
    public ResponseEntity<Map<String, Object>> guardar(@RequestBody CaracteristicasDTO caracteristica){
        response = caracteristicaService.guardar(caracteristica);
        return ResponseEntity.created(URI.create("/Caracteristicas")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> buscar(@PathVariable Integer id) {
        response = caracteristicaService.buscar(id);
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> actualizar(@PathVariable Integer id, @RequestBody CaracteristicasDTO c) {
        response = caracteristicaService.actualizar(id, c);
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> eliminar(@PathVariable Integer id) {
        response = caracteristicaService.eliminar(id);
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }
    @GetMapping()
    public ResponseEntity<Map<String, Object>> listarTodos(){
        response = caracteristicaService.listarTodos();
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }

}
