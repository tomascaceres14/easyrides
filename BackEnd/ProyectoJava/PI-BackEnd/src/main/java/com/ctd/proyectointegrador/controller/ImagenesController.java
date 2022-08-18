package com.ctd.proyectointegrador.controller;

import com.ctd.proyectointegrador.persistance.dto.CaracteristicasDTO;
import com.ctd.proyectointegrador.persistance.dto.ImagenesDTO;
import com.ctd.proyectointegrador.service.impl.CaracteristicasService;
import com.ctd.proyectointegrador.service.impl.ImagenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Imagenes")
public class ImagenesController {
    @Autowired
    ImagenesService imagenesService;

    @Autowired
    Map<String, Object> response = new HashMap<>();
    private Integer codigo;

    @PostMapping()
    public ResponseEntity<Map<String, Object>> guardar(@RequestBody ImagenesDTO imagenes){
        response = imagenesService.guardar(imagenes);
        return ResponseEntity.created(URI.create("/Imagenes")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> buscar(@PathVariable Integer id) {
        response = imagenesService.buscar(id);
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> actualizar(@PathVariable Integer id, @RequestBody ImagenesDTO i) {
        response = imagenesService.actualizar(id, i);
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> eliminar(@PathVariable Integer id) {
        response = imagenesService.eliminar(id);
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }
    @GetMapping()
    public ResponseEntity<Map<String, Object>> listarTodos(){
        response = imagenesService.listarTodos();
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }

}
