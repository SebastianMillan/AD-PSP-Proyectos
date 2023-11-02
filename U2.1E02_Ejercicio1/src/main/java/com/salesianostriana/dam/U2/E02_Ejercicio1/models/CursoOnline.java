package com.salesianostriana.dam.U2.E02_Ejercicio1.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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
public class CursoOnline {

    @Id
    @GeneratedValue
    private long id;

    private String nombre;
    private double puntuacion;

    @ManyToOne
    private Profesor profesor;

    @OneToMany(mappedBy = "curso")
    @ToString.Exclude
    @Builder.Default
    private List<Video> videos = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoOnline that = (CursoOnline) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void addProfesor(Profesor p){
        this.profesor=p;
        p.getCursos().add(this);
    }
    public void removeProfesor(Profesor p){
        this.profesor=null;
        p.getCursos().remove(this);
    }
}
