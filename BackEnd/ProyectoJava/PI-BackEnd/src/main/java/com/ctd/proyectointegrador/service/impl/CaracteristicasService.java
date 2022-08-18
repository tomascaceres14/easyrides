package com.ctd.proyectointegrador.service.impl;

import com.ctd.proyectointegrador.persistance.dto.CaracteristicasDTO;
import com.ctd.proyectointegrador.persistance.model.Caracteristicas;
import com.ctd.proyectointegrador.persistance.repository.CaracteristicasRepository;
import com.ctd.proyectointegrador.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CaracteristicasService implements IService<CaracteristicasDTO> {
    @Autowired
    CaracteristicasRepository caracteristicaRepository;

    @Autowired
    ObjectMapper mapper;

    Map<String, Object> respuesta = new HashMap<>();


    @Override
    public Map<String, Object> guardar(CaracteristicasDTO object) {
        respuesta.clear();
        Caracteristicas caracteristica = mapper.convertValue(object, Caracteristicas.class);
        Caracteristicas nuevaCaracteristica= caracteristicaRepository.save(caracteristica);
        respuesta.put("codigo",200);
        respuesta.put("caracteristica", mapper.convertValue(nuevaCaracteristica, CaracteristicasDTO.class));
        return respuesta;
    }

    @Override
    public Map<String, Object> buscar(Integer id) {
        respuesta.clear();
        if(caracteristicaRepository.findById(id).isPresent()){
            Caracteristicas caracteristica = caracteristicaRepository.findById(id).get();
            respuesta.put("codigo", 200);
            respuesta.put("caracteristica", mapper.convertValue(caracteristica, CaracteristicasDTO.class));
        }else{
            respuesta.remove("caracteristica");
            respuesta.put("codigo",404);
            respuesta.put("mensaje", "Caracteristica id: "+ id +" no existe");
        }
        return respuesta;
    }

    @Override
    public Map<String, Object> actualizar(Integer id, CaracteristicasDTO object) {
        respuesta.clear();
        if(caracteristicaRepository.findById(id).isPresent()){
            Caracteristicas c = mapper.convertValue(respuesta.get("caracteristica"), Caracteristicas.class);
            c.setTitulo(object.getTitulo() != null ? object.getTitulo() : c.getTitulo());
            c.setDescripcion(object.getDescripcion() != null ? object.getDescripcion() : c.getDescripcion());
            caracteristicaRepository.save(c);
            respuesta.replace("caracteristica", mapper.convertValue(c, CaracteristicasDTO.class));
        }
        return respuesta;

    }


    @Override
    public Map<String, Object> eliminar(Integer id) {
        respuesta.clear();
        if(caracteristicaRepository.findById(id).isPresent()){
            caracteristicaRepository.deleteById(id);
            respuesta.put("codigo", 200);
            respuesta.put("mensaje", "Caracteristica id: "+id + " eliminada");
        }else {
            respuesta.put("codigo", 404);
            respuesta.put("mensaje", "Caracteristica id: "+id + " no existe");
        }
        return respuesta;
    }



    @Override
    public Map<String, Object> listarTodos() {
        respuesta.clear();
        List<Caracteristicas> listaCaracteristicas = caracteristicaRepository.findAll();
        List<CaracteristicasDTO> listaCaractDTO = new ArrayList<>();
        for(Caracteristicas c : listaCaracteristicas){
            CaracteristicasDTO CaractDTO =mapper.convertValue(c, CaracteristicasDTO.class);
            listaCaractDTO.add(CaractDTO);
        }
        respuesta.put("codigo", 200);
        respuesta.put("caracteristicas",listaCaractDTO);
        return respuesta;
    }

}
