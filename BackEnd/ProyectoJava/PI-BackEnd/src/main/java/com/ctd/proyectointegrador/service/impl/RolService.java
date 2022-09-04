package com.ctd.proyectointegrador.service.impl;

import com.ctd.proyectointegrador.persistance.dto.RolDTO;
import com.ctd.proyectointegrador.persistance.model.Rol;
import com.ctd.proyectointegrador.persistance.repository.RolRepository;
import com.ctd.proyectointegrador.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RolService implements IService<RolDTO> {
    @Autowired
    RolRepository rolRepository;

    @Autowired
    ObjectMapper mapper;

    private Map<String, Object> buildResponse(Object dto, String message, Integer code) {
        Map<String, Object> response = new HashMap<>();
        response.put("rol", dto);
        response.put("message", message);
        response.put("codigo", code);
        return response;
    }

    @Override
    public Map<String, Object> guardar(RolDTO object) {
        Rol roles = mapper.convertValue(object, Rol.class);
        Rol nuevoRol = rolRepository.save(roles);
        return buildResponse(mapper.convertValue(nuevoRol, RolDTO.class),"Rol guardado",201);
    }

    @Override
    public Map<String, Object> buscar(Integer id) {
        Rol rolbuscar = rolRepository.findById(id).get();
        return buildResponse(mapper.convertValue(rolbuscar, RolDTO.class), "Rol encontrado",201);
    }


    @Override
    public Map<String, Object> actualizar(Integer id, RolDTO object) {
     Rol rolact = mapper.convertValue(object, Rol.class);
     Rol rolBD = rolRepository.findById(id).orElse(null);
     if(rolBD == null){
         return buildResponse(new RolDTO(), "No existe el rol",404);
     }
     rolBD.setNombre(rolact.getNombre());
     Rol roles = rolRepository.save(rolBD);
     return buildResponse(mapper.convertValue(roles, RolDTO.class),"Actualizacion exitosa",201);
    }


    @Override
    public Map<String, Object> eliminar(Integer id) {
        if(rolRepository.findById(id).isPresent()){
            rolRepository.deleteById(id);
            return buildResponse(new RolDTO(), "Rol id "+ id +" eliminado",201);
        }else{
            return buildResponse(new RolDTO(), "Rol id "+ id +" no existe",404);
        }

    }

    @Override
    public Map<String, Object> listarTodos() {
        List<Rol> listaRoles = rolRepository.findAll();
        List<RolDTO> listaDTO = new ArrayList<>();
        for(Rol r : listaRoles){
            RolDTO rolDTO = mapper.convertValue(r, RolDTO.class);
            listaDTO.add(rolDTO);
        }
        return buildResponse(listaDTO, "Lista creada", 200);
    }
}
