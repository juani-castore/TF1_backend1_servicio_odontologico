package com.dh.clinicaOdontologica.services;

import com.dh.clinicaOdontologica.dto.PacienteDTO;
import com.dh.clinicaOdontologica.exceptions.NotFoundException;
import com.dh.clinicaOdontologica.models.Paciente;
import com.dh.clinicaOdontologica.repositories.PacienteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    ObjectMapper mapper;

    private Paciente guardarPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }
    public Paciente crearPaciente(Paciente paciente){
        paciente.setFechaIngreso(new Date());
        return guardarPaciente(paciente);
    }
    public Paciente actualizarPaciente(Paciente paciente){
        paciente.setFechaIngreso(pacienteRepository.findById(paciente.getId()).orElseThrow().getFechaIngreso());
        return guardarPaciente(paciente);
    }
    public void eliminarPaciente(Long id) throws NotFoundException {
        if (pacienteRepository.findById(id).isEmpty())
            throw new NotFoundException("el paciente con id: " + id.toString() + " no esta registrado");
        pacienteRepository.deleteById(id);

    }

    public PacienteDTO buscarPaciente(Long id) throws NotFoundException {
        if (pacienteRepository.findById(id).isEmpty())
            throw new NotFoundException("el paciente con id: " + id.toString() + " no esta registrado");
        return mapper.convertValue(pacienteRepository.findById(id), PacienteDTO.class);
    }
    public List<PacienteDTO> listarPacientes(){
        // aca traigo la lista de pacientes y la convierto a una lista de pacientesDTO
        return pacienteRepository.findAll().stream()
                .map(p -> new PacienteDTO(p.getId(),p.getNombre(),p.getApellido()))
                .collect(Collectors.toList());
    }

}
