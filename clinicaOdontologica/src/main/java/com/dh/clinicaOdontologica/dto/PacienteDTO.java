package com.dh.clinicaOdontologica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter @Getter
public class PacienteDTO {

    private Long id;
    private String nombre;
    private String apellido;

    public PacienteDTO(Long id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public PacienteDTO() {
    }
}
