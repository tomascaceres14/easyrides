package com.ctd.proyectointegrador.service.impl;

import com.ctd.proyectointegrador.persistance.dto.ProductosDTO;
import com.ctd.proyectointegrador.persistance.model.Producto;
import com.ctd.proyectointegrador.persistance.repository.ProductosRepository;
import com.ctd.proyectointegrador.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductosService implements IService<ProductosDTO> {
    @Autowired
    ProductosRepository productosRepository;

    @Autowired
    ObjectMapper mapper;

    Map<String, Object> respuesta = new HashMap<>();

    public Map<String, Object> guardar(ProductosDTO p){
        respuesta.clear();
        Producto producto = mapper.convertValue(p, Producto.class);
        Producto nuevoProd = productosRepository.save(producto);
        respuesta.put("codigo", 200);
        respuesta.put("producto", mapper.convertValue(nuevoProd, ProductosDTO.class));
        return respuesta;
    }

    public Map<String, Object> buscar(Integer id){

        respuesta.clear();
        if(productosRepository.findById(id).isPresent()){
            Producto producto = productosRepository.findById(id).get();
            respuesta.put("codigo", 200);
            respuesta.put("producto", mapper.convertValue(producto, ProductosDTO.class));
        } else {
            respuesta.remove("producto");
            respuesta.put("codigo", 404);
            respuesta.put("mensaje", "Producto id: " + id + " no existe");
        }

        return respuesta;
    }

    public Map<String, Object> actualizar(Integer id, ProductosDTO object){

        respuesta.clear();
        respuesta = buscar(id);
        if(productosRepository.findById(id).isPresent()) {
            Producto p = mapper.convertValue(respuesta.get("producto"), Producto.class);
            p.setTitulo(object.getTitulo() != null ?  object.getTitulo() : p.getTitulo());
            p.setDescripcion(object.getDescripcion() != null ?  object.getDescripcion() : p.getDescripcion());
            p.setUrl(object.getUrl() != null ?  object.getUrl() : p.getUrl());
            productosRepository.save(p);
            respuesta.replace("producto", mapper.convertValue(p, ProductosDTO.class));
        }
        // Retorno HashMap de respuesta
        return respuesta;
    }

    public Map<String, Object> eliminar(Integer id) {

        respuesta.clear();
        if (productosRepository.findById(id).isPresent()) {
            productosRepository.deleteById(id);
            respuesta.put("codigo", 200);
            respuesta.put("mensaje","Producto id: " + id + " eliminada");
        } else {
            respuesta.put("codigo", 404);
            respuesta.put("mensaje","Producto id: " + id + " no existe");
        }
        return respuesta;
    }

    public Map<String, Object> listarTodos(){

        respuesta.clear();
        List<Producto> listaProd = productosRepository.findAll();
        List<ProductosDTO> listaDTO = new ArrayList<>();

        for (Producto p: listaProd){
            ProductosDTO prodDTO = mapper.convertValue(p, ProductosDTO.class);
            listaDTO.add(prodDTO);
        }
        respuesta.put("codigo", 200);
        respuesta.put("productos", listaDTO);
        return respuesta;

    }
}
