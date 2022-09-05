package com.ctd.proyectointegrador.service.impl;

import com.ctd.proyectointegrador.enums.Role;
import com.ctd.proyectointegrador.persistance.dto.UsuarioDTO;
import com.ctd.proyectointegrador.persistance.model.jwt.Usuario;
import com.ctd.proyectointegrador.persistance.repository.UsuarioRepository;
import com.ctd.proyectointegrador.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UsuarioService implements IService<UsuarioDTO> {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


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
        Usuario user = mapper.convertValue(object, Usuario.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        Usuario nuevoUsuario= usuarioRepository.save(user);
        return buildResponse(mapper.convertValue(nuevoUsuario, UsuarioDTO.class),"Usuario guardado",201);
    }

    @Override
    public Map<String, Object> buscar(Long id) {
        Usuario usuarios = usuarioRepository.findById(id).get();
        return buildResponse(mapper.convertValue(usuarios, UsuarioDTO.class), "Usuario encontrado",201);
    }

    @Override
    public Map<String, Object> actualizar(Long id, UsuarioDTO object) {
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
    public Map<String, Object> eliminar(Long id) {
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

    public Optional<Usuario> findByUserEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

}
