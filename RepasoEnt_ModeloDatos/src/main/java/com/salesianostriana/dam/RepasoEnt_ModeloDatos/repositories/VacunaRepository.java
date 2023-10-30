package com.salesianostriana.dam.RepasoEnt_ModeloDatos.repositories;

import com.salesianostriana.dam.RepasoEnt_ModeloDatos.models.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacunaRepository extends JpaRepository<Vacuna, Long> {
}