package com.dh.clinicaOdontologica.services;

import com.dh.clinicaOdontologica.dto.TurnoDTO;
import com.dh.clinicaOdontologica.exceptions.NotFoundException;
import com.dh.clinicaOdontologica.models.Turno;
import com.dh.clinicaOdontologica.repositories.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TurnoService {

    @Autowired
    TurnoRepository turnoRepository;
    @Autowired
    ObjectMapper mapper;


    public Turno guardarTurno(Turno turno){
        return turnoRepository.save(turno);
    }
    public Turno crearTurno(Turno turno){
        return guardarTurno(turno);
    }
    public Turno actualizarTurno(Turno turno){
        return guardarTurno(turno);
    }
    public void eliminarTurno(Long id) throws NotFoundException{
        if (turnoRepository.findById(id).isEmpty())
            throw new NotFoundException("este turno nunca fue asignado previamente, id: "+ id.toString());
        turnoRepository.deleteById(id);
    }
    public TurnoDTO buscarTurno(Long id) throws NotFoundException {
        Turno turno = turnoRepository.findById(id).orElse(null);
        if (turno == null)
            throw new NotFoundException("este turno no ha sido asignado todavia, id: " + id.toString());
        return new TurnoDTO(turno.getPaciente().getNombre() +" "+ turno.getPaciente().getApellido(),
                turno.getOdontologo().getNombre() +" "+ turno.getOdontologo().getApellido(),turno.getFecha());
    }
    public List<TurnoDTO> listarTurnos(){
        return turnoRepository.findAll().stream()
                // aca quedo largo pero lo que hace es convertir la lista de turnos a una lista de turnosDTO,
                // los cuales son mucho mejores para mostrar en las vistas
                .map(t -> new TurnoDTO(t.getPaciente().getNombre() + " " + t.getPaciente().getApellido(),
                        t.getOdontologo().getNombre() + " " + t.getOdontologo().getApellido(), t.getFecha()))
                .collect(Collectors.toList());
    }

}
