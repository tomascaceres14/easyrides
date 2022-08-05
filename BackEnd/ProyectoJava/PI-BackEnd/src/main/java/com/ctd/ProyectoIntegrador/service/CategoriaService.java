package com.ctd.ProyectoIntegrador.service;

import com.ctd.ProyectoIntegrador.model.Categoria;
import com.ctd.ProyectoIntegrador.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoriaService {
    @Autowired
    private final CategoriaRepository categoriaRepository;


    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }


    public Categoria guardar(Categoria c){
        return categoriaRepository.save(c);
    }

    public Optional<Categoria> buscar(Integer id){
        return categoriaRepository.findById(id);
    }

    public List<Categoria> listarTodos(){
        return categoriaRepository.findAll();
    }

    public void eliminar(Integer id){
        categoriaRepository.deleteById(id);
    }

    public Categoria actualizar(Categoria c){
        return categoriaRepository.save(c);
    }

}
