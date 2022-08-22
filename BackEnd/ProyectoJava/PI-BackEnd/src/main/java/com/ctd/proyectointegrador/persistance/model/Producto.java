package com.ctd.proyectointegrador.persistance.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "url", nullable = false)
    private String url;

    @OneToMany(mappedBy = "producto")
    private List<Imagen> imagenes;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Caracteristica> caracteristicas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Producto() {
    }

    public Producto(String titulo, String descripcion, String url,Integer ciudad, List<Caracteristica> caracteristicas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
        this.caracteristicas = caracteristicas;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public List<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracteristica> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", url='" + url + '\'' +
                ", imagenes=" + imagenes +
                ", caracteristicas=" + caracteristicas +
                ", ciudad=" + ciudad +
                '}';
    }
}
