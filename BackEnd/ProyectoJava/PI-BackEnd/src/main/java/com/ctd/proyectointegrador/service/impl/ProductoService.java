package com.ctd.proyectointegrador.service.impl;

import com.ctd.proyectointegrador.persistance.dto.ProductoDTO;
import com.ctd.proyectointegrador.persistance.model.Categoria;
import com.ctd.proyectointegrador.persistance.model.Ciudad;
import com.ctd.proyectointegrador.persistance.model.Producto;
import com.ctd.proyectointegrador.persistance.repository.CategoriaRepository;
import com.ctd.proyectointegrador.persistance.repository.CiudadRepository;
import com.ctd.proyectointegrador.persistance.repository.ProductoRepository;
import com.ctd.proyectointegrador.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class ProductoService implements IService<ProductoDTO> {
    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    CiudadRepository ciudadRepository;

    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ObjectMapper mapper;

    private Map<String, Object> buildResponse(Object dto, String message, Integer code) {
        Map<String, Object> response = new HashMap<>();
        response.put("productos", dto);
        response.put("message", message);
        response.put("codigo", code);
        return response;
    }

    public Map<String, Object> guardar(ProductoDTO p) {
        Producto producto = mapper.convertValue(p, Producto.class);
        Ciudad ciudadBD = ciudadRepository.findById(producto.getCiudad().getId()).get();
        producto.setCiudad(ciudadBD);
        Categoria categoriaDB = categoriaRepository.findById(producto.getCategoria().getId()).get();
        producto.setCategoria(categoriaDB);
        Producto prodRespuesta = productoRepository.save(producto);
        return buildResponse(mapper.convertValue(prodRespuesta, ProductoDTO.class), "producto creado", 201);
    }

    public Map<String, Object> buscar(Integer id) {
        Producto prodRespuesta = productoRepository.findById(id).get();
        return buildResponse(mapper.convertValue(prodRespuesta, ProductoDTO.class), "producto encontrado", 201);
    }

    public Map<String, Object> actualizar(Integer id, ProductoDTO object) {
        Producto actualizar = mapper.convertValue(object, Producto.class);
        Producto productoEnBD = productoRepository.findById(id).orElse(null);
        if (productoEnBD == null) {
            // error
            return buildResponse(new ProductoDTO(), "No existe id " + id, 404);
        }
        productoEnBD.setTitulo(actualizar.getTitulo());
        productoEnBD.setDescripcion(actualizar.getDescripcion());
        productoEnBD.setImagenes(actualizar.getImagenes());
        /* productoEnBD.setCaracteristicas(actualizar.getCaracteristicas()); */
        productoEnBD.setCiudad(ciudadRepository.findById(actualizar.getCiudad().getId()).get());
        Producto prodRespuesta = productoRepository.save(productoEnBD);

        return buildResponse(mapper.convertValue(prodRespuesta, ProductoDTO.class), "cambio Exitoso", 201);
    }

    public Map<String, Object> eliminar(Integer id) {
        if (productoRepository.findById(id).isPresent()) {
            productoRepository.deleteById(id);
            return buildResponse(new ProductoDTO(), "Producto id " + id + " eliminado", 200);
        } else {
            return buildResponse(new ProductoDTO(), "Producto id " + id + " no existe", 404);
        }
    }

    public Map<String, Object> listarTodos() {

        List<Producto> listaProd = productoRepository.findAll();
        List<ProductoDTO> listaDTO = new ArrayList<>();

        for (Producto p : listaProd) {
            ProductoDTO prodDTO = mapper.convertValue(p, ProductoDTO.class);
            listaDTO.add(prodDTO);
        }
        return buildResponse(listaDTO, "lista creada", 200);

    }

    public Map<String, Object> listarProductosAleatorios() {
        Random r = new Random();
        r.setSeed(System.currentTimeMillis());
        List<Producto> listaProd = productoRepository.findAll();
        Collections.shuffle(listaProd, r);
        List<ProductoDTO> listaDTO = new ArrayList<>();

        for (Producto p : listaProd) {
            ProductoDTO prodDTO = mapper.convertValue(p, ProductoDTO.class);
            listaDTO.add(prodDTO);
        }
        return buildResponse(listaDTO, "lista creada", 200);

    }
}
