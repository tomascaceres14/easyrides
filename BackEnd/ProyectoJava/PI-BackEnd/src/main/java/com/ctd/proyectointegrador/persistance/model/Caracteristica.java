package com.ctd.proyectointegrador.persistance.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter

public class Caracteristica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name = "titulo", nullable = false)
    private String titulo;

    @ManyToMany(mappedBy = "caracteristicas", fetch = FetchType.LAZY)
    private List<Producto> productos;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Caracteristica{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
