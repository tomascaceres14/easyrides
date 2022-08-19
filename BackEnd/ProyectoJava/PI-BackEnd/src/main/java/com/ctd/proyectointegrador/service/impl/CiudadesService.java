package com.ctd.proyectointegrador.service.impl;


import com.ctd.proyectointegrador.persistance.dto.CiudadesDTO;
import com.ctd.proyectointegrador.persistance.model.Ciudad;
import com.ctd.proyectointegrador.persistance.repository.CiudadesRepository;
import com.ctd.proyectointegrador.service.IService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CiudadesService implements IService<CiudadesDTO> {
    @Autowired
    CiudadesRepository ciudadRespository;

    @Autowired
    ObjectMapper mapper;

    Map<String, Object> respuesta = new HashMap<>();



    public Map<String, Object> guardar(CiudadesDTO object) {
        respuesta.clear();
        Ciudad ciudad = mapper.convertValue(object, Ciudad.class);
        Ciudad nuevaCiudad= ciudadRespository.save(ciudad);
        respuesta.put("codigo",200);
        respuesta.put("ciudad", mapper.convertValue(nuevaCiudad, CiudadesDTO.class));
        return respuesta;
    }

    @OneToMany(mappedBy = "Ciudades", fetch = FetchType.LAZY)
    @JsonIgnore
    public Map<String, Object> buscar(Integer id) {
        respuesta.clear();
        if(ciudadRespository.findById(id).isPresent()){
            Ciudad ciudad = ciudadRespository.findById(id).get();
            respuesta.put("codigo", 200);
            respuesta.put("ciudad", mapper.convertValue(ciudad, CiudadesDTO.class));
        }else{
            respuesta.remove("ciudad");
            respuesta.put("codigo",404);
            respuesta.put("mensaje", "Ciudad id: "+ id +" no existe");
        }
        return respuesta;
    }


    public Map<String, Object> actualizar(Integer id, CiudadesDTO object) {
        respuesta.clear();
        if(ciudadRespository.findById(id).isPresent()){
            Ciudad c = mapper.convertValue(respuesta.get("ciudad"), Ciudad.class);
            c.setNombre(object.getNombre() != null ? object.getNombre() : c.getNombre());
            c.setProvincia(object.getProvincia() != null ? object.getProvincia() : c.getProvincia());
            c.setPais(object.getPais() != null ? object.getPais() : c.getPais());
            ciudadRespository.save(c);
            respuesta.replace("ciudad", mapper.convertValue(c, CiudadesDTO.class));
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
        List<CiudadesDTO> listaCiudadesDTO = new ArrayList<>();
        for(Ciudad c : listaCiudades){
            CiudadesDTO CiuDTO= mapper.convertValue(c, CiudadesDTO.class);
            listaCiudadesDTO.add(CiuDTO);
        }
        respuesta.put("codigo", 200);
        respuesta.put("ciudades", listaCiudadesDTO);
        return respuesta;
    }
}
