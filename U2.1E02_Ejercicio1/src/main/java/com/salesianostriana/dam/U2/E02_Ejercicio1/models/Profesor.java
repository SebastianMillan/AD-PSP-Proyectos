package com.salesianostriana.dam.U2.E02_Ejercicio1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Profesor {

    @Id
    @GeneratedValue
    private long id;

    private String nombre;
    private String email;
    private double puntuacion;

    @ToString.Exclude
    @OneToMany(mappedBy = "profesor")
    private List<CursoOnline> cursos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return id == profesor.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
