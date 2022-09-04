package com.ctd.proyectointegrador.controller;

import com.ctd.proyectointegrador.persistance.dto.RolDTO;
import com.ctd.proyectointegrador.service.impl.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    RolService rolService;

    private Integer codigo;


     @PostMapping()
    public ResponseEntity<Map<String, Object>> guardar(@RequestBody RolDTO rol) {
        Map<String, Object> response = rolService.guardar(rol);
        return ResponseEntity.created(URI.create("/roles")).body(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> buscar(@PathVariable Integer id) {
        Map<String, Object> response = rolService.buscar(id);
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> actualizar(@PathVariable Integer id, @RequestBody RolDTO r) {
        Map<String, Object> response = rolService.actualizar(id, r);
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> eliminar(@PathVariable Integer id) {
        Map<String, Object> response = rolService.eliminar(id);
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
    }


    @GetMapping()
    public ResponseEntity<Map<String, Object>> listarTodos(){
        Map<String, Object> response = rolService.listarTodos();
        codigo = (Integer) response.get("codigo");
        return ResponseEntity.status(codigo).body(response);
}


}
