package com.dh.clinicaOdontologica.controllers;


import com.dh.clinicaOdontologica.dto.TurnoDTO;
import com.dh.clinicaOdontologica.models.Turno;
import com.dh.clinicaOdontologica.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    TurnoService turnoService;

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        return ResponseEntity.ok(turnoService.crearTurno(turno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscarTurno(@PathVariable Long id){
        return ResponseEntity.ok(turnoService.buscarTurno(id));
    }

    @PutMapping
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno){
        return ResponseEntity.ok(turnoService.actualizarTurno(turno));
    }

    @DeleteMapping("/{id}")
    public void eliminarTurno(@PathVariable Long id){
        turnoService.eliminarTurno(id);
    }

    @GetMapping
    public ResponseEntity<List<TurnoDTO>> listarTurnos(){
        return ResponseEntity.ok(turnoService.listarTurnos());
    }
}
