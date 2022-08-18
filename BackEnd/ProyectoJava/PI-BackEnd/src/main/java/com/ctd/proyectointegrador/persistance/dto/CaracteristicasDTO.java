package com.ctd.proyectointegrador.persistance.dto;

public class CaracteristicasDTO {
    private Integer id;

    private String titulo;

    private String descripcion;

    public CaracteristicasDTO() {
    }

    public CaracteristicasDTO(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
