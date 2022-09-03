package com.ctd.proyectointegrador.persistance.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservaDTO {
    @NotEmpty(message = "no debe estar vacio")
    @NotNull(message = "no debe ser nulo")
    private Integer id;

    @NotEmpty(message = "no debe estar vacio")
    @NotNull(message = "no debe ser nulo")
    private String horaInicio;

    @NotEmpty(message = "no debe estar vacio")
    @NotNull(message = "no debe ser nulo")
    private String fechaInicial;

    @NotEmpty(message = "no debe estar vacio")
    @NotNull(message = "no debe ser nulo")
    private String fechaFinal;

    @NotEmpty(message = "no debe estar vacio")
    @NotNull(message = "no debe ser nulo")
    private ProductoDTO productoDTO;
}
