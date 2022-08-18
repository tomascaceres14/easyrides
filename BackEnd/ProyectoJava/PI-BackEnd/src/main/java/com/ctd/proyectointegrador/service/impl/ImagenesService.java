package com.ctd.proyectointegrador.service.impl;

import com.ctd.proyectointegrador.persistance.dto.CaracteristicasDTO;
import com.ctd.proyectointegrador.persistance.dto.ImagenesDTO;
import com.ctd.proyectointegrador.persistance.model.Caracteristicas;
import com.ctd.proyectointegrador.persistance.model.Imagenes;
import com.ctd.proyectointegrador.persistance.repository.CaracteristicasRepository;
import com.ctd.proyectointegrador.persistance.repository.ImagenesRepository;
import com.ctd.proyectointegrador.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImagenesService implements IService<ImagenesDTO> {

    @Autowired
    ImagenesRepository imagenesRepository;

    @Autowired
    ObjectMapper mapper;

    Map<String, Object> respuesta = new HashMap<>();


    @Override
    public Map<String, Object> guardar(ImagenesDTO object) {
        respuesta.clear();
        Imagenes imagenes = mapper.convertValue(object, Imagenes.class);
        Imagenes nuevaImagenes= imagenesRepository.save(imagenes);
        respuesta.put("codigo",200);
        respuesta.put("imagenes", mapper.convertValue(nuevaImagenes, ImagenesDTO.class));
        return respuesta;
    }

    @Override
    public Map<String, Object> buscar(Integer id) {
        respuesta.clear();
        if(imagenesRepository.findById(id).isPresent()){
            Imagenes imagenes = imagenesRepository.findById(id).get();
            respuesta.put("codigo", 200);
            respuesta.put("imagen", mapper.convertValue(imagenes, ImagenesDTO.class));
        }else{
            respuesta.remove("imagen");
            respuesta.put("codigo",404);
            respuesta.put("mensaje", "Imagen id: "+ id +" no existe");
        }
        return respuesta;
    }

    @Override
    public Map<String, Object> actualizar(Integer id, ImagenesDTO object) {
        respuesta.clear();
        if(imagenesRepository.findById(id).isPresent()){
            Imagenes i = mapper.convertValue(respuesta.get("imagen"), Imagenes.class);
            i.setTitulo(object.getTitulo() != null ? object.getTitulo() : i.getTitulo());
            i.setDescripcion(object.getDescripcion() != null ? object.getDescripcion() : i.getDescripcion());
            imagenesRepository.save(i);
            respuesta.replace("imagen", mapper.convertValue(i, ImagenesDTO.class));
        }
        return respuesta;

    }


    @Override
    public Map<String, Object> eliminar(Integer id) {
        respuesta.clear();
        if(imagenesRepository.findById(id).isPresent()){
            imagenesRepository.deleteById(id);
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
        List<Imagenes> listaImagenes = imagenesRepository.findAll();
        List<ImagenesDTO> listaImageDTO = new ArrayList<>();
        for(Imagenes i : listaImagenes){
            ImagenesDTO imageDTO =mapper.convertValue(i, ImagenesDTO.class);
            listaImageDTO.add(imageDTO);
        }
        respuesta.put("codigo", 200);
        respuesta.put("Imagenes",listaImageDTO);
        return respuesta;
    }

}
