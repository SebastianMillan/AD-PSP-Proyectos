package com.salesianostriana.dam.RepasoEnt_ModeloDatos.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Administracion {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime fecha;
    private int edadAlAdministrar;
    private String notas;

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Calendario calendario;

    public void addPaciente(Paciente p){
        this.paciente=p;
        p.getAdministraciones().add(this);
    }

    public void removePaciente(Paciente p){
        this.paciente=null;
        p.getAdministraciones().remove(this);
    }

    public void addCalendario(Calendario c){
        this.calendario=c;
        c.getAdministraciones().add(this);
    }

    public void removeCalendario(Calendario c){
        this.calendario=null;
        c.getAdministraciones().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administracion that = (Administracion) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
