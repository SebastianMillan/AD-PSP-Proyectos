package com.salesianostriana.dam.RepasoEntidades;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {

    private final BookRepository bookRepository;
    @PostConstruct
    public void initData(){

        Book b1 = Book.builder().id(1L).name("España").author(null).build();
        Book b2 = Book.builder().id(2L).name("aaaa").author(null).build();
        Book b3 = Book.builder().id(3L).name("ssss").author(null).build();
        Book b4 = Book.builder().id(4L).name("ffff").author(null).build();
        Book b5 = Book.builder().id(4L).name("adasdasdad").author(null).build();

        b1.addAuthor(Author.builder().id(1L).name("Sebastián").country("Spain").build());
        b2.addAuthor(Author.builder().id(1L).name("Sebastián").country("Spain").build());
        b3.addAuthor(Author.builder().id(1L).name("Sebastián").country("Spain").build());
        b4.addAuthor(Author.builder().id(2L).name("Fernando").country("Spain").build());
        b5.addAuthor(Author.builder().id(2L).name("Fernando").country("Spain").build());

        bookRepository.saveAll(List.of(b1,b2,b3,b4,b5));





    }
}
