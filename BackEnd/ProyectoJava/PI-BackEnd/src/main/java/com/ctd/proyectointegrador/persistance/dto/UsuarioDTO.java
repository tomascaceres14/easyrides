package com.ctd.proyectointegrador.persistance.dto;

import com.ctd.proyectointegrador.persistance.model.Reserva;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Column;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO {
    private Integer id;

    private String nombre;

    private String apellido;

    private String email;

    private String password;

    private String ciudad;

    // private Set<ReservaDTO> reservas;
}
