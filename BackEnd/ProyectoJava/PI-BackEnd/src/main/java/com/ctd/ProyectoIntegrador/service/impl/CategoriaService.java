package com.ctd.ProyectoIntegrador.service.impl;

import com.ctd.ProyectoIntegrador.model.Categoria;
import com.ctd.ProyectoIntegrador.repository.CategoriaRepository;
import com.ctd.ProyectoIntegrador.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoriaService implements IService<Categoria> {
    @Autowired
    CategoriaRepository categoriaRepository;

    public Categoria guardar(Categoria c){
        return categoriaRepository.save(c);
    }

    public Categoria buscar(Integer id){

        Categoria categoria = null;
        if(categoriaRepository.findById(id).isPresent()){
            categoria = categoriaRepository.findById(id).get();
        }
        return categoria;
    }

    public Categoria actualizar(Integer id, Categoria object){

        Categoria response = null;

        if(categoriaRepository.findById(id).isPresent()) {
            Categoria categoriaAct = categoriaRepository.findById(id).get();
            categoriaAct.setTitulo(object.getTitulo() != null ?  object.getTitulo() : categoriaAct.getTitulo());
            categoriaAct.setDescripcion(object.getDescripcion() != null ?  object.getDescripcion() : categoriaAct.getDescripcion());
            categoriaAct.setUrl(object.getUrl() != null ?  object.getUrl() : categoriaAct.getUrl());
            categoriaRepository.save(categoriaAct);
            response = categoriaAct;
        }
        return response;
    }

    public String eliminar(Integer id){

        if(categoriaRepository.findById(id).isPresent()){
            categoriaRepository.deleteById(id);
            return "Categoria id: " + id + " fué eliminada.";
        } else return "No existe categoria con id: " + id;
    }


    public List<Categoria> listarTodos(){
        return categoriaRepository.findAll();
    }
}
