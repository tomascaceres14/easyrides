package com.ctd.proyectointegrador.persistance.dto;

public class ImagenesDTO {
    private Integer id;

    private String titulo;

    private String descripcion;

    public ImagenesDTO() {
    }

    public ImagenesDTO(String titulo, String descripcion) {
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
