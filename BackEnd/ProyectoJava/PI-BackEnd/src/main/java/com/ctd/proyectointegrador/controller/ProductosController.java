package com.ctd.proyectointegrador.controller;

import com.ctd.proyectointegrador.persistance.dto.ProductosDTO;
import com.ctd.proyectointegrador.service.impl.ProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Productos")
public class ProductosController {
    @Autowired
    ProductosService productoService;

    @Autowired
    Map<String, Object> response = new HashMap<>();

    private Integer codigo;

    @PostMapping()
    public ResponseEntity<Map<String, Object>> guardar(@RequestBody ProductosDTO producto){
        response = productoService.guardar(producto);
        return ResponseEntity.created(URI.create("/Producto")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> buscar(@PathVariable Integer id) {
        response = productoService.buscar(id);
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> actualizar(@PathVariable Integer id, @RequestBody ProductosDTO p) {
        response = productoService.actualizar(id, p);
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> eliminar(@PathVariable Integer id) {
        response = productoService.eliminar(id);
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> listarTodos(){
        response = productoService.listarTodos();
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }
}