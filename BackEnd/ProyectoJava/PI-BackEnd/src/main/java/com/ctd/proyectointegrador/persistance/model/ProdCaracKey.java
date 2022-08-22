package com.ctd.proyectointegrador.persistance.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProdCaracKey implements Serializable {

    @Column(name = "producto_id")
    private Integer productoId;

    @Column(name = "caracteristica_id")
    private Integer caracteristicaId;
}
