package com.ctd.ProyectoIntegrador.model;

import javax.persistence.*;

@Entity
@Table(name= "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "url_img")
    private String url_img;



    public Categoria() {
    }

    public Categoria(String titulo, String descripcion, String url_img) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url_img = url_img;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getUrl() {
        return url_img;
    }

    public void setUrl(String url) {
        this.url_img = url;
    }
}
