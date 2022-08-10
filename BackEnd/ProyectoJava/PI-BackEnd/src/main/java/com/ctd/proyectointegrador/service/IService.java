package com.ctd.proyectointegrador.service;

import java.util.List;

public interface IService<T> {

    public T guardar(T object);

    public T buscar(Integer id);

    public T actualizar(Integer id, T object);

    public boolean eliminar(Integer id);

    public List<T> listarTodos();
}
