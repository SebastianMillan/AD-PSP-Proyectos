package com.salesianostriana.dam.RepasoEnt_ModeloDatos.repositories;

import com.salesianostriana.dam.RepasoEnt_ModeloDatos.models.Calendario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarioRepository extends JpaRepository<Calendario, Long> {
}