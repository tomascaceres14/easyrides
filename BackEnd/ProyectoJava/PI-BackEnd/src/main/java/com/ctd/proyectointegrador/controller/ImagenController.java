package com.ctd.proyectointegrador.controller;

import com.ctd.proyectointegrador.persistance.dto.ImagenDTO;
import com.ctd.proyectointegrador.service.impl.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/imagenes")
public class ImagenController {
    @Autowired
    ImagenService imagenService;

    @Autowired
    Map<String, Object> response = new HashMap<>();
    private Integer codigo;

    @PostMapping()
    public ResponseEntity<Map<String, Object>> guardar(@RequestBody ImagenDTO imagenes){
        response = imagenService.guardar(imagenes);
        return ResponseEntity.created(URI.create("/Imagenes")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> buscar(@PathVariable Integer id) {
        response = imagenService.buscar(id);
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> actualizar(@PathVariable Integer id, @RequestBody ImagenDTO i) {
        response = imagenService.actualizar(id, i);
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> eliminar(@PathVariable Integer id) {
        response = imagenService.eliminar(id);
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }
    @GetMapping()
    public ResponseEntity<Map<String, Object>> listarTodos(){
        response = imagenService.listarTodos();
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }

}
