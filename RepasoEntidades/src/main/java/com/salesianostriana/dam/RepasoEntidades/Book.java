package com.salesianostriana.dam.RepasoEntidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Author author;

    //helper
    /*
    public void addAuthor(Author a){
        this.author=a;
        a.getLibros().add(this);
    }

    public void removeAuthor(Author a){
        a.getLibros().remove(this);
        this.author=null;
    }
     */
}
