package com.salesianostriana.dam.RepasoEntidades;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.NaturalId;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Author {

    @GeneratedValue @Id
    private Long id;

    @NaturalId
    private String dni;
    private String name, lastName, country;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(dni, author.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }
}
