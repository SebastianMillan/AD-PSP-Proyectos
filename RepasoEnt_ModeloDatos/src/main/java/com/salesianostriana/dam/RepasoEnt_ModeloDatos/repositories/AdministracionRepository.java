package com.salesianostriana.dam.RepasoEnt_ModeloDatos.repositories;

import com.salesianostriana.dam.RepasoEnt_ModeloDatos.models.Administracion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministracionRepository extends JpaRepository<Administracion, Long> {
}