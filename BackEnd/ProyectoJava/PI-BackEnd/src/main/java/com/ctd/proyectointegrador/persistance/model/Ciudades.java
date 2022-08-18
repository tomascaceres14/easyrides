package com.ctd.proyectointegrador.persistance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table
public class Ciudades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "provincia", nullable = false)
    private String provincia;
    @Column(name = "pais", nullable = false)
    private String pais;

    //@OneToMany(mappedBy = "Ciudades")
    //@JsonIgnore
    //private List<Productos> productos;


    public Ciudades() {
    }

    public Ciudades(String nombre, String provincia, String pais, List<Productos> productos) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.pais = pais;
        //this.productos = productos;
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

   // public List<Productos> getProductos() {
        //return productos;
   // }

    //public void setProductos(List<Productos> productos) {
      //  this.productos = productos;
   // }

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
