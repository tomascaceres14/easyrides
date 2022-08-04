package com.ctd.ProyectoIntegrador.controller;

import com.ctd.ProyectoIntegrador.model.Categoria;
import com.ctd.ProyectoIntegrador.service.CategoriaService;
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

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Categoria>> listarTodos(){
        return ResponseEntity.ok(categoriaService.listarTodos());
    }


    @PostMapping("/agregar")
    public ResponseEntity<Categoria> registrarCategoria(@RequestBody Categoria categoria){
        return ResponseEntity.ok(categoriaService.guardar(categoria));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscar(@PathVariable Integer id) {
        Categoria categoria = categoriaService.buscar(id).orElse(null);

        return ResponseEntity.ok(categoria);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Categoria> actualizar(@RequestBody Categoria categoria) {
        categoriaService.actualizar(categoria);
        return ResponseEntity.ok(categoria);
    }
       /* ResponseEntity<Categoria> response = null;

        if (categoria.getId() != null && categoriaService.buscar(categoria.getId()).isPresent())
            response = ResponseEntity.ok(categoriaService.actualizar(categoria));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
        */



    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        categoriaService.eliminar(id);
        return ResponseEntity.status(201).body(HttpStatus.OK);
    }
       /* ResponseEntity<String> response = null;

        if (categoriaService.buscar(id).isPresent()) {
            categoriaService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;

        */
    }

