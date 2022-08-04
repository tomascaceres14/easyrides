package com.dh.G11.controller;

import com.dh.G11.model.Categoria;
import com.dh.G11.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/Categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Categoria>> listarTodos(){
        return ResponseEntity.ok(categoriaService.listarTodos());
    }


@PostMapping("/agregar")
    public ResponseEntity<Categoria>  registrarCategoria (@RequestBody Categoria categoria){
    return ResponseEntity.ok(categoriaService.guardar(categoria));
}
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscar(@PathVariable Integer id) {
        Categoria categoria = categoriaService.buscar(id).orElse(null);

        return ResponseEntity.ok(categoria);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Categoria> actualizar(@RequestBody Categoria categoria) {
        ResponseEntity<Categoria> response = null;

        if (categoria.getId() != null && categoriaService.buscar(categoria.getId()).isPresent())
            response = ResponseEntity.ok(categoriaService.actualizar(categoria));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if (categoriaService.buscar(id).isPresent()) {
            categoriaService.eliminar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }
}






