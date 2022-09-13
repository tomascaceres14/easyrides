package com.ctd.proyectointegrador.persistance.model;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descripcion", nullable = false, length = 1020)
    private String descripcion;

    @OneToMany(mappedBy = "producto")
    private List<Imagen> imagenes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ciudad_id")
    private Ciudad ciudad;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "producto_caracteristica",
            joinColumns = { @JoinColumn(name = "producto_id") },
            inverseJoinColumns = { @JoinColumn(name = "caracteristica_id") })
    private List<Caracteristica> caracteristicas = new ArrayList<>();



    @OneToMany(mappedBy = "producto")
    private List<Reserva> reservas = new ArrayList<>();
}
