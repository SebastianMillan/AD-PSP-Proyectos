package com.salesianostriana.dam.RepasoEnt_ModeloDatos.repositories;

import com.salesianostriana.dam.RepasoEnt_ModeloDatos.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}