package com.ctd.proyectointegrador.service;
import java.util.Map;

public interface IService<T> {

    public Map<String, Object> guardar(T object);

    public Map<String, Object> buscar(Integer id);

    public Map<String, Object> actualizar(Integer id, T object);

    public Map<String, Object> eliminar(Integer id);

    public Map<String, Object> listarTodos();
}
