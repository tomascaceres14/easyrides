package com.ctd.proyectointegrador.controller;

import com.ctd.proyectointegrador.persistance.dto.UsuarioDTO;
import com.ctd.proyectointegrador.service.impl.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    private Integer codigo;


        @PostMapping()
    public ResponseEntity<Map<String, Object>> guardar(@RequestBody UsuarioDTO usuario) {
        Map<String, Object> response = usuarioService.guardar(usuario);
        return ResponseEntity.created(URI.create("/usuarios")).body(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> buscar(@PathVariable Integer id) {
        Map<String, Object> response = usuarioService.buscar(id);
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> actualizar(@PathVariable Integer id, @RequestBody UsuarioDTO u) {
        Map<String, Object> response = usuarioService.actualizar(id, u);
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> eliminar(@PathVariable Integer id) {
        Map<String, Object> response = usuarioService.eliminar(id);
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }


    @GetMapping()
    public ResponseEntity<Map<String, Object>> listarTodos(){
        Map<String, Object> response = usuarioService.listarTodos();
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
}



}
