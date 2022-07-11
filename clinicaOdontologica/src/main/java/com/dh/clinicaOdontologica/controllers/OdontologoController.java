package com.dh.clinicaOdontologica.controllers;

import com.dh.clinicaOdontologica.dto.OdontologoDTO;
import com.dh.clinicaOdontologica.models.Odontologo;
import com.dh.clinicaOdontologica.services.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.crearOdontologo(odontologo));
    }

    // no funciona
    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> buscarOdontologo(@PathVariable Long id){
        return ResponseEntity.ok(odontologoService.buscarOdontologo(id));
    }

    // funciona, pero acordate de pasarle el id
    @PutMapping
    public ResponseEntity<Odontologo> actualizarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.actualizarOdontologo(odontologo));
    }

    // no funcionaaaaaaaaaa
    @DeleteMapping("/{id}")
    public void eliminarOdontologo(@PathVariable Long id){
        odontologoService.eliminarOdontologo(id);
    }

    @GetMapping
    public ResponseEntity<List<OdontologoDTO>> listarOdontologos(){
        return ResponseEntity.ok(odontologoService.listarOdontologos());
    }
}
