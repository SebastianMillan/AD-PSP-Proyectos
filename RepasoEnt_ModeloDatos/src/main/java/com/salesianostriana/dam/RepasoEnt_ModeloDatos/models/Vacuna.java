package com.salesianostriana.dam.RepasoEnt_ModeloDatos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Vacuna {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String descripcionEnfermedad;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacuna vacuna = (Vacuna) o;
        return Objects.equals(id, vacuna.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
