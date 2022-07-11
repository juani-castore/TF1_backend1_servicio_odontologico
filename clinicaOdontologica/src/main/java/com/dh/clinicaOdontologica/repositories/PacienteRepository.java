package com.dh.clinicaOdontologica.repositories;

import com.dh.clinicaOdontologica.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
