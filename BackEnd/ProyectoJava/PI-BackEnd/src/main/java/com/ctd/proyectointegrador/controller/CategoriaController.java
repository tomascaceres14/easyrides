package com.ctd.proyectointegrador.controller;

import com.ctd.proyectointegrador.persistance.dto.CategoriaDTO;
import com.ctd.proyectointegrador.service.impl.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Categorias")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @Autowired
    Map<String, Object> response = new HashMap<>();

    private Integer codigo;


    @PostMapping()
    public ResponseEntity<Map<String, Object>> guardar(@RequestBody CategoriaDTO categoria){
        // LLamo al metodo del service
        response = categoriaService.guardar(categoria);
        // Retorno ResponseEntity, codigo 201 (created).
        // El metodo guardar(categoria) retorna un HashMap con el codigo de respuesta y la categoria creada.
        // Eso se almacena en la variable 'response' y se retorna en el body del ResponseEntity.
        return ResponseEntity.created(URI.create("/Categorias")).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> buscar(@PathVariable Integer id) {
        // LLamo al metodo del service
        response = categoriaService.buscar(id);
        // Extraigo el codigo de respuesta
        codigo = (Integer) response.get("codigo");
        // Retorno el ResponseEntity con codigo de respuesta y body correspondiente
        return ResponseEntity.status(codigo).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> actualizar(@PathVariable Integer id, @RequestBody CategoriaDTO c) {
        // LLamo al metodo del service
        response = categoriaService.actualizar(id, c);
        // Extraigo el codigo de respuesta
        codigo = (Integer) response.get("codigo");
        // Retorno el ResponseEntity con codigo de respuesta y body correspondiente
        return ResponseEntity.status(codigo).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> eliminar(@PathVariable Integer id) {
        // LLamo al metodo del service
        response = categoriaService.eliminar(id);
        // Extraigo el codigo de respuesta
        codigo = (Integer) response.get("codigo");
        // Retorno el ResponseEntity con codigo de respuesta y body correspondiente
        return ResponseEntity.status(codigo).body(response);
    }

    @GetMapping()
    public ResponseEntity<Map<String, Object>> listarTodos(){
        response = categoriaService.listarTodos();
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }
}