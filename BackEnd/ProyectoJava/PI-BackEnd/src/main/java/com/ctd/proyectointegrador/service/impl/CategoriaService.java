package com.ctd.proyectointegrador.service.impl;

import com.ctd.proyectointegrador.persistance.dto.CategoriaDTO;
import com.ctd.proyectointegrador.persistance.model.Categoria;
import com.ctd.proyectointegrador.persistance.repository.CategoriaRepository;
import com.ctd.proyectointegrador.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoriaService implements IService<CategoriaDTO> {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ObjectMapper mapper;

    Map<String, Object> respuesta = new HashMap<>();

    public Map<String, Object> guardar(CategoriaDTO c){
        // Uno de los problemas que surgieron fue que cuando se realizaban varias consultas,
        // quedaban cargados en el HashMap los pares de clave:valor de cada una. response.clear() es citado
        // al comienzo de cada metodo para eliminar lo que se encuentre previamente y asi tener el HashMap limpio.
        respuesta.clear();
        // Convierto CategoriaDTO a Categoria
        Categoria categoria = mapper.convertValue(c, Categoria.class);
        // Guardo Categoria en la base de datos
        Categoria nuevaCat = categoriaRepository.save(categoria);
        // Preparo respuesta y transformo a DTO
        respuesta.put("codigo", 200);
        respuesta.put("categoria", mapper.convertValue(nuevaCat, CategoriaDTO.class));
        return respuesta;
    }

    public Map<String, Object> buscar(Integer id){

        respuesta.clear();
        // Verifico que exista el id demandado
        if(categoriaRepository.findById(id).isPresent()){
            // Obtengo Categoria
            Categoria categoria = categoriaRepository.findById(id).get();
            // Preparo HashMap de respuesta de consulta satisfactoria.
            respuesta.put("codigo", 200);
            respuesta.put("categoria", mapper.convertValue(categoria, CategoriaDTO.class));
        } else {
            // Si el objeto respuesta tiene una categoria cargada por consulta realizada previamente, la elimino
            // del objeto de respuesta
            respuesta.remove("categoria");
            // Preparo HashMap de respuesta de consulta erronea.
            respuesta.put("codigo", 404);
            respuesta.put("mensaje", "Categoria id: " + id + " no existe");
        }
        // Retorno HashMap de respuesta
        return respuesta;
    }

    public Map<String, Object> actualizar(Integer id, CategoriaDTO object){

        respuesta.clear();
        // Reutilizo el metodo buscar para obtener la categoria (La obtengo como DTO)
        respuesta = buscar(id);
        // Verifico que exista el id demandado
        if(categoriaRepository.findById(id).isPresent()) {
            // Transformo la categoria obtenida anteriormente de DTO a Categoria
            // .get("clave") me retorna el valor que almacena dicha clave
            Categoria c = mapper.convertValue(respuesta.get("categoria"), Categoria.class);
            // Actualizacion de la categoria. Si uno de los atributos del objeto entrante es nulo, queda con su valor
            // actual. Si no es nulo, es porque el cliente me envia el nuevo valor de dicho atributo,
            // entonces se lo asigno
            c.setTitulo(object.getTitulo() != null ?  object.getTitulo() : c.getTitulo());
            c.setDescripcion(object.getDescripcion() != null ?  object.getDescripcion() : c.getDescripcion());
            c.setUrl(object.getUrl() != null ?  object.getUrl() : c.getUrl());
            // Envio los cambios
            categoriaRepository.save(c);
            // En la respuesta, reemplazo la categoria con valores viejos por la nueva categoria (Transformado
            // a DTO)
            respuesta.replace("categoria", mapper.convertValue(c, CategoriaDTO.class));
        }
        // Retorno HashMap de respuesta
        return respuesta;
    }

    public Map<String, Object> eliminar(Integer id) {

        respuesta.clear();
        // Verifico que exista el id demandado
        if (categoriaRepository.findById(id).isPresent()) {
            // Elimino la categoria indicada de la base de datos
            categoriaRepository.deleteById(id);
            // Preparo HashMap de respuesta de consulta satisfactoria.
            respuesta.put("codigo", 200);
            respuesta.put("mensaje","Categoria id: " + id + " eliminada");
        } else {
            // Preparo HashMap de respuesta de consulta erronea.
            respuesta.put("codigo", 404);
            respuesta.put("mensaje","Categoria id: " + id + " no existe");
        }
        return respuesta;
    }

    public Map<String, Object> listarTodos(){

        respuesta.clear();
        // Obtengo todos los registros de la tabla Categorias.
        List<Categoria> listaCat = categoriaRepository.findAll();
        // Creo un Array donde se almacenaran las categorias transformadas a DTO
        List<CategoriaDTO> listaDTO = new ArrayList<>();

        // Bucle for que recorre la lista de Categorias
        for (Categoria c: listaCat){
            // A cada categoria de listaCat la transformo a DTO
            CategoriaDTO catDTO = mapper.convertValue(c, CategoriaDTO.class);
            // Almaceno la categoria transformada a DTO en Array creado previamente
            listaDTO.add(catDTO);
        }
        respuesta.put("codigo", 200);
        respuesta.put("categorias", listaDTO);
        //Retorno Array con categorias en DTO
        return respuesta;

    }
}
