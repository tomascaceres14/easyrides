package com.ctd.proyectointegrador.persistance.dto;

import com.ctd.proyectointegrador.persistance.model.Imagen;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductoDTO {

    @NotEmpty(message = "no debe estar vacio")
    @NotNull(message = "no debe ser nulo")
    private Integer id;

    @NotEmpty(message = "no debe estar vacio")
    @NotNull(message = "no debe ser nulo")
    private String titulo;

    @NotEmpty(message = "no debe estar vacio")
    @NotNull(message = "no debe ser nulo")
    private String descripcion;

    @NotEmpty(message = "no debe estar vacio")
    @NotNull(message = "no debe ser nulo")
    private List<Imagen> imagenes;

    @NotEmpty(message = "no debe estar vacio")
    @NotNull(message = "no debe ser nulo")
    private CiudadDTO ciudad;

    @NotEmpty(message = "no debe estar vacio")
    @NotNull(message = "no debe ser nulo")
    private CategoriaDTO categoria;

    @NotEmpty(message = "no debe estar vacio")
    @NotNull(message = "no debe ser nulo")
    private Set<CaracteristicaDTO> caracteristicas;
}
