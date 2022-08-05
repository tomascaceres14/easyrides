package com.ctd.ProyectoIntegrador.service;

import java.util.List;

public interface IService<T> {

    public T guardar(T object);

    public T buscar(Integer id);

    public T actualizar(Integer id, T object);

    public String eliminar(Integer id);

    public List<T> listarTodos();
}
