package com.ctd.proyectointegrador.controller;

import com.ctd.proyectointegrador.persistance.dto.CategoriaDTO;
import com.ctd.proyectointegrador.persistance.model.Categoria;
import com.ctd.proyectointegrador.service.impl.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping()
    public ResponseEntity<CategoriaDTO> guardar(@RequestBody CategoriaDTO categoria){
        CategoriaDTO response = categoriaService.guardar (categoria);
        return ResponseEntity.created(URI.create("/categorias")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(categoriaService.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> actualizar(@PathVariable Integer id, @RequestBody CategoriaDTO c) {
        return ResponseEntity.ok(categoriaService.actualizar(id, c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> eliminar(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        if (categoriaService.eliminar(id)){
            response.put("mensaje", "Categoria id: " + id + " eliminada");
            return ResponseEntity.ok(response);
        } else {
            response.put("mensaje", "Categoria id: " + id + " no existe");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping()
    public ResponseEntity<List<CategoriaDTO>> listarTodos(){
        return ResponseEntity.ok(categoriaService.listarTodos());
    }
}