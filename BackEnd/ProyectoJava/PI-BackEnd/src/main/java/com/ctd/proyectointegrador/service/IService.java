package com.ctd.proyectointegrador.service;

import org.apache.logging.log4j.spi.ObjectThreadContextMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IService<T> {

    public T guardar(T object);

    public T buscar(Integer id);

    public T actualizar(Integer id, T object);

    public Map<String, Object> eliminar(Integer id);

    public List<T> listarTodos();
}
