package com.ctd.proyectointegrador.persistance.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Categoria {
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

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    public Categoria() {
    }

    public Categoria(String titulo, String descripcion, String url) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.url = url;
        this.productos = new ArrayList<>();
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

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
