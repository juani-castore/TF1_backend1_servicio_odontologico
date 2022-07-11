package com.dh.clinicaOdontologica.services;

import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.exceptions.NotFoundException;
import com.dh.clinicaOdontologica.models.Odontologo;
import com.dh.clinicaOdontologica.repositories.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OdontologoService {

    @Autowired
    OdontologoRepository odontologoRepository;
    @Autowired
    ObjectMapper mapper;


    private Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }
    public Odontologo crearOdontologo(Odontologo odontologo){
        return guardarOdontologo(odontologo);
    }
    public Odontologo actualizarOdontologo(Odontologo odontologo){
        return guardarOdontologo(odontologo);
    }
    public void eliminarOdontologo(Long id) throws NotFoundException {
        if (odontologoRepository.findById(id).isEmpty())
            throw new NotFoundException("el odontologo con id: " + id.toString() + " no existe");
        odontologoRepository.deleteById(id);
    }

    public OdontologoDTO buscarOdontologo(Long id) throws NotFoundException {
        if (odontologoRepository.findById(id).isEmpty())
            throw new NotFoundException("el odontologo con id: " + id.toString() + " no existe");
        return mapper.convertValue(odontologoRepository.findById(id),OdontologoDTO.class);

    }

    public List<OdontologoDTO> listarOdontologos(){
        // aca traigo la lista de odontologos y la convierto a una lista de odontologosDTO
        return odontologoRepository.findAll().stream()
                .map(o -> new OdontologoDTO(o.getId(),o.getNombre(),o.getApellido()))
                .collect(Collectors.toList());
    }
}
