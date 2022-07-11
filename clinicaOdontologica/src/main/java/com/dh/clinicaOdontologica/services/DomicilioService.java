package com.dh.clinicaOdontologica.services;

import com.dh.clinicaOdontologica.models.Domicilio;
import com.dh.clinicaOdontologica.models.Paciente;
import com.dh.clinicaOdontologica.repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// la vercad es que esta clase no se usa por ahora, pero me parecio util a un futuro dejar estos 2 metodos
@Service
public class DomicilioService {

    @Autowired
    DomicilioRepository domicilioRepository;

    public Optional<Domicilio> buscarDomicilio(Long id){
        return domicilioRepository.findById(id);
    }

    public Optional<Domicilio> buscarDomicilioPorPaciente(Paciente paciente){
        Long idPaciente = paciente.getId();
        return buscarDomicilio(idPaciente);
    }
}