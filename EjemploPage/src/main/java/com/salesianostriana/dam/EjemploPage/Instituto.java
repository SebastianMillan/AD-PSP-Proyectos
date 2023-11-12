package com.salesianostriana.dam.EjemploPage;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Instituto {

    @Id
    private Long id;

    private String nombre, ciudad;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instituto instituto = (Instituto) o;
        return Objects.equals(id, instituto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
