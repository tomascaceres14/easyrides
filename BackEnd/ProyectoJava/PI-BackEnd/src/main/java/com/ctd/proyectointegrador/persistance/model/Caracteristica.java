package com.ctd.proyectointegrador.persistance.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @ManyToMany(mappedBy = "caracteristicas")
    private List<Producto> productos;

    public Caracteristica() {
    }

    public Caracteristica(String titulo, String descripcion, List<Producto> productos) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.productos = productos;
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

    @Override
    public String toString() {
        return "Caracteristica{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
