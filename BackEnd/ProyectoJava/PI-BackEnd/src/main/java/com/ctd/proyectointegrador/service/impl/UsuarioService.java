package com.ctd.proyectointegrador.service.impl;

import com.ctd.proyectointegrador.persistance.dto.UsuarioDTO;
import com.ctd.proyectointegrador.persistance.model.Usuario;
import com.ctd.proyectointegrador.persistance.repository.UsuarioRepository;
import com.ctd.proyectointegrador.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioService implements IService<UsuarioDTO> {
    @Autowired
    UsuarioRepository usuarioRepository;


    @Autowired
    ObjectMapper mapper;

    private Map<String, Object> buildResponse(Object dto, String message, Integer code) {
        Map<String, Object> response = new HashMap<>();
        response.put("usuario", dto);
        response.put("message", message);
        response.put("codigo", code);
        return response;
    }

    @Override
    public Map<String, Object> guardar(UsuarioDTO object) {
        Usuario usuarios = mapper.convertValue(object, Usuario.class);
        Usuario nuevoUsuario= usuarioRepository.save(usuarios);
        return buildResponse(mapper.convertValue(nuevoUsuario, UsuarioDTO.class),"Usuario guardado",201);
    }
    @Override
    public Map<String, Object> buscar(Integer id) {
        Usuario usuarios = usuarioRepository.findById(id).get();
        return buildResponse(mapper.convertValue(usuarios, UsuarioDTO.class), "Usuario encontrado",201);
    }
    @Override
    public Map<String, Object> actualizar(Integer id, UsuarioDTO object) {
        Usuario usuarior= mapper.convertValue(object, Usuario.class);
        Usuario usuarioBD= usuarioRepository.findById(id).orElse(null);
        if(usuarioBD == null){
            return buildResponse(new UsuarioDTO(), "no existe usuario con id "+id, 404);
        }
        usuarioBD.setNombre(usuarior.getNombre());
        usuarioBD.setApellido(usuarior.getApellido());
        usuarioBD.setCiudad(usuarior.getCiudad());
        usuarioBD.setEmail(usuarior.getEmail());
        //falta password
        Usuario usuarioact= usuarioRepository.save(usuarioBD);
        return buildResponse(mapper.convertValue(usuarioact, UsuarioDTO.class), " Actualizacion exitosa",201);
    }
    @Override
    public Map<String, Object> eliminar(Integer id) {
        if (usuarioRepository.findById(id).isPresent()) {
            usuarioRepository.deleteById(id);
            return buildResponse(new UsuarioDTO(), "Usuario eliminado", 201);
        }else {
            return buildResponse(new UsuarioDTO(), "No existe el usuario", 404);
        }
    }
    @Override
    public Map<String, Object> listarTodos() {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        List<UsuarioDTO> listaDTO = new ArrayList<>();
        for(Usuario u : listaUsuarios){
            UsuarioDTO usuarioDTO= mapper.convertValue(u, UsuarioDTO.class);
            listaDTO.add(usuarioDTO);
        }
        return buildResponse(listaDTO, "Lista creada", 201);
    }







}
