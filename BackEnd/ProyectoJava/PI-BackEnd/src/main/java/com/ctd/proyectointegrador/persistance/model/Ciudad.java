package com.ctd.proyectointegrador.persistance.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ciudades")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "provincia")
    private String provincia;
    @Column(name = "pais")
    private String pais;

    @OneToMany(mappedBy = "ciudad")
    private List<Producto> productos;

    public Ciudad() {
    }

    public Ciudad(String nombre, String provincia, String pais ) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.pais = pais;
        this.productos = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
/*
    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
       this.productos = productos;
    }
*/
    @Override
    public String toString() {
        return "Ciudad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", provincia='" + provincia + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
