package com.salesianostriana.dam.BorradoEntidades_CursoOW.cascaderphan;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    //Deberiamos de poner fetchtype lazy pero pondremos eager para no hacer eager join y complicar las consultas
    @OneToMany(mappedBy = "author", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ToString.Exclude
    @Builder.Default
    private Set<Book> books = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void addBook(Book b){
        this.books.add(b);
        b.setAuthor(this);
    }

    public void removeBook(Book b){
        this.books.remove(b);
        b.setAuthor(null);
    }
}
