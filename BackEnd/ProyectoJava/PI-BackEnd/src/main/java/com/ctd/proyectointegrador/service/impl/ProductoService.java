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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public Map<String, Object> buscar(Long id) {
        Producto prodRespuesta = productoRepository.findById(id).get();
        return buildResponse(mapper.convertValue(prodRespuesta, ProductoDTO.class), "producto encontrado", 201);
    }

    public Map<String,Object> listarPorCiudad(Long id) {
        List<Producto> productos = productoRepository.listarPorCiudad(id);
        System.out.println(productos);
        List<ProductoDTO> productosPorCiudad = new ArrayList<>();
        for (Producto producto : productos) {
            productosPorCiudad.add(mapper.convertValue(producto, ProductoDTO.class));
        }
        return buildResponse(productosPorCiudad, "Lista por ciudad", 200);
    }

    public Map<String, Object> actualizar(Long id, ProductoDTO object) {
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

    public Map<String, Object> eliminar(Long id) {
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
        Collections.shuffle(listaDTO);
        return buildResponse(listaDTO, "lista creada", 200);
    }

    public Map<String, Object> filtroCiudadYFechas(Long ciudad_id, String checkIn, String checkOut) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date checkInD = formatter.parse(checkIn);
        Date checkOutD = formatter.parse(checkOut);

        List<Producto> listaProd = productoRepository.listarPorFechaYCiudad(ciudad_id, checkInD, checkOutD);

        List<ProductoDTO> listaDTO = new ArrayList<>();

        for (Producto p : listaProd) {
            ProductoDTO prodDTO = mapper.convertValue(p, ProductoDTO.class);
            listaDTO.add(prodDTO);
        }
        return buildResponse(listaDTO, "lista creada", 200);
    }
}
