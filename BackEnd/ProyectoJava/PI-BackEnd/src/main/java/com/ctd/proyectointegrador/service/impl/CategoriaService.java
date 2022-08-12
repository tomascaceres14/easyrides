package com.ctd.proyectointegrador.service.impl;

import com.ctd.proyectointegrador.persistance.dto.CategoriaDTO;
import com.ctd.proyectointegrador.persistance.model.Categoria;
import com.ctd.proyectointegrador.repository.CategoriaRepository;
import com.ctd.proyectointegrador.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoriaService implements IService<CategoriaDTO> {
    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ObjectMapper mapper;

    public CategoriaDTO guardar(CategoriaDTO c){
        Categoria categoria = mapper.convertValue(c, Categoria.class);
        Categoria nuevaCat = categoriaRepository.save(categoria);
        return mapper.convertValue(nuevaCat, CategoriaDTO.class);
    }

    public CategoriaDTO buscar(Integer id){

        Categoria categoria = null;
        if(categoriaRepository.findById(id).isPresent()){
            categoria = categoriaRepository.findById(id).get();
        }
        return mapper.convertValue(categoria, CategoriaDTO.class);
    }

    public CategoriaDTO actualizar(Integer id, CategoriaDTO object){

        CategoriaDTO c = null;

        if(categoriaRepository.findById(id).isPresent()) {

            c = buscar(id);
            c.setTitulo(object.getTitulo() != null ?  object.getTitulo() : c.getTitulo());
            c.setDescripcion(object.getDescripcion() != null ?  object.getDescripcion() : c.getDescripcion());
            c.setUrl(object.getUrl() != null ?  object.getUrl() : c.getUrl());

        }

        return guardar(c);
    }

    public Map<String, Object> eliminar(Integer id) {
        Map<String, Object> respuesta = new HashMap<>();

        if (categoriaRepository.findById(id).isPresent()) {
            categoriaRepository.deleteById(id);
            respuesta.put("codigo", 200);
            respuesta.put("mensaje","Categoria id: " + id + " eliminada");
        } else {
            respuesta.put("codigo", 404);
            respuesta.put("mensaje","Categoria id: " + id + " no existe");
        }
        return respuesta;
    }

    public List<CategoriaDTO> listarTodos(){

        List<Categoria> listaCat = categoriaRepository.findAll();

        List<CategoriaDTO> listaDTO = new ArrayList<>();

        for (Categoria c: listaCat){
            CategoriaDTO catDTO = mapper.convertValue(c, CategoriaDTO.class);
            listaDTO.add(catDTO);
        }

        return listaDTO;

    }
}
