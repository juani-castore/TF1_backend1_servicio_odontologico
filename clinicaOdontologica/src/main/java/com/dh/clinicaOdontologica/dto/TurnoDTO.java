package com.dh.clinicaOdontologica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class TurnoDTO {

    private String nombrePaciente;
    private String nombreOdontologo;
    private LocalDateTime fecha;

    public TurnoDTO() {
    }

    public TurnoDTO(String nombrePaciente, String nombreOdontologo, LocalDateTime fecha) {
        this.nombrePaciente = nombrePaciente;
        this.nombreOdontologo = nombreOdontologo;
        this.fecha = fecha;
    }
}
