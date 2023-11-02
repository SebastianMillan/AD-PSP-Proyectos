package com.salesianostriana.dam.U2.E02_Ejercicio1.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
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
    @Builder.Default
    @OneToMany(mappedBy = "profesor", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CursoOnline> cursos = new ArrayList<>();

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
