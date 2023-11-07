package com.salesianostriana.dam.BorradoEntidades_CursoOW.cascaderphan;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class InitData {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    @PostConstruct
    public void initData(){
        Author a1 = Author.builder()
                .nombre("Sebastian")
                .build();

        authorRepository.save(a1);

        Book b1 = Book.builder()
                .title("asd")
                .editorial("asdada")
                .build();

        Book b2 = Book.builder()
                .title("zzzzz")
                .editorial("ssssssssssss")
                .build();

        a1.addBook(b1);
        a1.addBook(b2);


        bookRepository.save(b1);
        bookRepository.save(b2);
        authorRepository.save(a1);

        a1.removeBook(b1);
        a1.removeBook(b2);

        bookRepository.save(b1);
        bookRepository.save(b2);
        authorRepository.delete(a1);
    }
}
