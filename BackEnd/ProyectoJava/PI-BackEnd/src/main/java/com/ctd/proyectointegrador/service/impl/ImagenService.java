package com.ctd.proyectointegrador.service.impl;

import com.ctd.proyectointegrador.persistance.dto.ImagenDTO;
import com.ctd.proyectointegrador.persistance.model.Imagen;
import com.ctd.proyectointegrador.persistance.repository.ImagenRepository;
import com.ctd.proyectointegrador.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImagenService implements IService<ImagenDTO> {

    @Autowired
    ImagenRepository imagenRepository;

    @Autowired
    ObjectMapper mapper;

    Map<String, Object> respuesta = new HashMap<>();


    @Override
    public Map<String, Object> guardar(ImagenDTO object) {
        respuesta.clear();
        Imagen imagenes = mapper.convertValue(object, Imagen.class);
        Imagen nuevaImagenes= imagenRepository.save(imagenes);
        respuesta.put("codigo",200);
        respuesta.put("imagenes", mapper.convertValue(nuevaImagenes, ImagenDTO.class));
        return respuesta;
    }

    @Override
    public Map<String, Object> buscar(Integer id) {
        respuesta.clear();
        if(imagenRepository.findById(id).isPresent()){
            Imagen imagenes = imagenRepository.findById(id).get();
            respuesta.put("codigo", 200);
            respuesta.put("imagen", mapper.convertValue(imagenes, ImagenDTO.class));
        }else{
            respuesta.remove("imagen");
            respuesta.put("codigo",404);
            respuesta.put("mensaje", "Imagen id: "+ id +" no existe");
        }
        return respuesta;
    }

    @Override
    public Map<String, Object> actualizar(Integer id, ImagenDTO object) {
        respuesta.clear();
        if(imagenRepository.findById(id).isPresent()){
            Imagen i = mapper.convertValue(respuesta.get("imagen"), Imagen.class);
            i.setTitulo(object.getTitulo() != null ? object.getTitulo() : i.getTitulo());
            i.setDescripcion(object.getDescripcion() != null ? object.getDescripcion() : i.getDescripcion());
            imagenRepository.save(i);
            respuesta.replace("imagen", mapper.convertValue(i, ImagenDTO.class));
        }
        return respuesta;

    }


    @Override
    public Map<String, Object> eliminar(Integer id) {
        respuesta.clear();
        if(imagenRepository.findById(id).isPresent()){
            imagenRepository.deleteById(id);
            respuesta.put("codigo", 200);
            respuesta.put("mensaje", "Imagen id: "+id + " eliminada");
        }else {
            respuesta.put("codigo", 404);
            respuesta.put("mensaje", "Imagen id: "+id + " no existe");
        }
        return respuesta;
    }



    @Override
    public Map<String, Object> listarTodos() {
        respuesta.clear();
        List<Imagen> listaImagenes = imagenRepository.findAll();
        List<ImagenDTO> listaImageDTO = new ArrayList<>();
        for(Imagen i : listaImagenes){
            ImagenDTO imageDTO =mapper.convertValue(i, ImagenDTO.class);
            listaImageDTO.add(imageDTO);
        }
        respuesta.put("codigo", 200);
        respuesta.put("Imagenes",listaImageDTO);
        return respuesta;
    }

}
