package com.salesianostriana.dam.EjemploPage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.*;
import java.util.List;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

    @Query("""
            select new com.salesianostriana.dam.EjemploPage.AlumnoDTO(
                a.id, a.nombre || ' ' || a.apellidos, a.instituto.nombre
                where a.instituto MEMBER OF ?1
            from Alumno a
            """)
    List<AlumnoDTO> getAlumnoDTOByInstituo(Instituto instituto);

    @Query("""
            select a from Alumno
            
            """)
    Page<Alumno> findAlumnoWithPages(Pageable pageable);
}