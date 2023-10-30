package com.salesianostriana.dam.RepasoEnt_ModeloDatos.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@ToString
public class Calendario {

    @Id
    @GeneratedValue
    private Long id;

    private int edad;
    private String tipoDosis;
    private String recomendaciones;
    private Discriminante discriminante;

    @ManyToOne
    private Vacuna vacuna;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "calendario")
    private Set<Administracion> administraciones= new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calendario that = (Calendario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
