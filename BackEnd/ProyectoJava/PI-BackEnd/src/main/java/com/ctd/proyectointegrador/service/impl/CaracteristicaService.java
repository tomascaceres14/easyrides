package com.ctd.proyectointegrador.service.impl;

import com.ctd.proyectointegrador.persistance.dto.CaracteristicaDTO;
import com.ctd.proyectointegrador.persistance.model.Caracteristica;
import com.ctd.proyectointegrador.persistance.repository.CaracteristicaRepository;
import com.ctd.proyectointegrador.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CaracteristicaService implements IService<CaracteristicaDTO> {

    @Autowired
    CaracteristicaRepository caracteristicaRepository;

    @Autowired
    ObjectMapper mapper;

    Map<String, Object> respuesta = new HashMap<>();


    @Override
    public Map<String, Object> guardar(CaracteristicaDTO object) {
        respuesta.clear();
        Caracteristica caracteristica = mapper.convertValue(object, Caracteristica.class);
        Caracteristica nuevaCaracteristica= caracteristicaRepository.save(caracteristica);
        respuesta.put("codigo",200);
        respuesta.put("caracteristica", mapper.convertValue(nuevaCaracteristica, CaracteristicaDTO.class));
        return respuesta;
    }

    @Override
    public Map<String, Object> buscar(Integer id) {
        respuesta.clear();
        if(caracteristicaRepository.findById(id).isPresent()){
            Caracteristica caracteristica = caracteristicaRepository.findById(id).get();
            respuesta.put("codigo", 200);
            respuesta.put("caracteristica", mapper.convertValue(caracteristica, CaracteristicaDTO.class));
        }else{
            respuesta.remove("caracteristica");
            respuesta.put("codigo",404);
            respuesta.put("mensaje", "Caracteristica id: "+ id +" no existe");
        }
        return respuesta;
    }

    @Override
    public Map<String, Object> actualizar(Integer id, CaracteristicaDTO object) {
        respuesta.clear();
        if(caracteristicaRepository.findById(id).isPresent()){
            Caracteristica c = mapper.convertValue(respuesta.get("caracteristica"), Caracteristica.class);
            c.setTitulo(object.getTitulo() != null ? object.getTitulo() : c.getTitulo());
            caracteristicaRepository.save(c);
            respuesta.replace("caracteristica", mapper.convertValue(c, CaracteristicaDTO.class));
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
        List<Caracteristica> listaCaracteristicas = caracteristicaRepository.findAll();
        List<CaracteristicaDTO> listaCaractDTO = new ArrayList<>();
        for(Caracteristica c : listaCaracteristicas){
            CaracteristicaDTO CaractDTO =mapper.convertValue(c, CaracteristicaDTO.class);
            listaCaractDTO.add(CaractDTO);
        }
        respuesta.put("codigo", 200);
        respuesta.put("caracteristicas",listaCaractDTO);
        return respuesta;
    }

}
