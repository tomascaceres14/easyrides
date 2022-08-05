package com.ctd.ProyectoIntegrador.controller;

import com.ctd.ProyectoIntegrador.model.Categoria;
import com.ctd.ProyectoIntegrador.service.impl.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping()
    public ResponseEntity<Categoria> guardar(@RequestBody Categoria categoria){
        return ResponseEntity.ok(categoriaService.guardar(categoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(categoriaService.buscar(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Integer id, @RequestBody Categoria c) {
        return ResponseEntity.ok(categoriaService.actualizar(id, c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        return ResponseEntity.ok(categoriaService.eliminar(id));
    }


    @GetMapping()
    public ResponseEntity<List<Categoria>> listarTodos(){
        return ResponseEntity.ok(categoriaService.listarTodos());
    }
}

