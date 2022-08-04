package com.dh.G11.service;

import com.dh.G11.model.Categoria;
import com.dh.G11.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

@Autowired
    public CategoriaService(CategoriaRepository categoriaRepository){
    this.categoriaRepository = categoriaRepository;
}


public Categoria guardar(Categoria c){
    return categoriaRepository.save(c);
    }

//esta no la pide.. pero seguro que sirve a futuro//
public Optional<Categoria>buscar(Integer id){
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
