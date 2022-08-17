package com.ctd.proyectointegrador.service.impl;


import com.ctd.proyectointegrador.persistance.dto.CiudadDTO;
import com.ctd.proyectointegrador.persistance.model.Ciudad;
import com.ctd.proyectointegrador.persistance.repository.CiudadRepository;
import com.ctd.proyectointegrador.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CiudadService implements IService<CiudadDTO> {
    @Autowired
    CiudadRepository ciudadRespository;

    @Autowired
    ObjectMapper mapper;

    Map<String, Object> respuesta = new HashMap<>();



    public Map<String, Object> guardar(CiudadDTO object) {
        respuesta.clear();
        Ciudad ciudad = mapper.convertValue(object, Ciudad.class);
        Ciudad nuevaCiudad= ciudadRespository.save(ciudad);
        respuesta.put("codigo",200);
        respuesta.put("ciudad", mapper.convertValue(nuevaCiudad, CiudadDTO.class));
        return respuesta;
    }


    public Map<String, Object> buscar(Integer id) {
        respuesta.clear();
        if(ciudadRespository.findById(id).isPresent()){
            Ciudad ciudad = ciudadRespository.findById(id).get();
            respuesta.put("codigo", 200);
            respuesta.put("ciudad", mapper.convertValue(ciudad, CiudadDTO.class));
        }else{
            respuesta.remove("ciudad");
            respuesta.put("codigo",404);
            respuesta.put("mensaje", "Ciudad id: "+ id +" no existe");
        }
        return respuesta;
    }


    public Map<String, Object> actualizar(Integer id, CiudadDTO object) {
        respuesta.clear();
        if(ciudadRespository.findById(id).isPresent()){
            Ciudad c = mapper.convertValue(respuesta.get("ciudad"), Ciudad.class);
            c.setNombre(object.getNombre() != null ? object.getNombre() : c.getNombre());
            c.setProvincia(object.getProvincia() != null ? object.getProvincia() : c.getProvincia());
            c.setPais(object.getPais() != null ? object.getPais() : c.getPais());
            ciudadRespository.save(c);
            respuesta.replace("ciudad", mapper.convertValue(c, CiudadDTO.class));
        }
        return respuesta;
    }


    public Map<String, Object> eliminar(Integer id) {
        respuesta.clear();
        if(ciudadRespository.findById(id).isPresent()) {
            ciudadRespository.deleteById(id);
            respuesta.put("codigo", 200);
            respuesta.put("mensaje", "Ciudad id: "+id + " eliminada");
        }else {
            respuesta.put("codigo", 404);
            respuesta.put("mensaje","Ciudad id: " + id + " no existe");
        }
        return respuesta;

    }


    public Map<String, Object> listarTodos() {
        respuesta.clear();
        List<Ciudad> listaCiudades = ciudadRespository.findAll();
        List<CiudadDTO> listaCiudadesDTO = new ArrayList<>();
        for(Ciudad c : listaCiudades){
            CiudadDTO CiuDTO= mapper.convertValue(c, CiudadDTO.class);
            listaCiudadesDTO.add(CiuDTO);
        }
        respuesta.put("codigo", 200);
        respuesta.put("ciudades", listaCiudadesDTO);
        return respuesta;
    }
}
