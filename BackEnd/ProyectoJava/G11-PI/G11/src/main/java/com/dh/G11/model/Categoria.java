package com.dh.G11.model;

import javax.persistence.*;

@Entity
@Table(name = "Categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "url")
    private String url_img;

    public Categoria() {
    }

    public Categoria(String titulo, String descripcion, String url_img) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url_img = url_img;
    }

    public Categoria(Integer id, String titulo, String descripcion, String url_img) {
        this.id = id;
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

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", url_img='" + url_img + '\'' +
                '}';
    }
}
