package com.salesianostriana.dam.RepasoEnt_ModeloDatos.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
//@EqualsAndHashCode
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String apellidos;
    private String telefonoContacto;
    private LocalDate fechaNacimiento;
    private String notas;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(mappedBy = "paciente")
    private Set<Administracion> administraciones = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
