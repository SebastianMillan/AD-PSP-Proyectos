package com.salesianostriana.dam.U2.E02_Ejercicio1.repositories;

import com.salesianostriana.dam.U2.E02_Ejercicio1.models.CursoOnline;
import com.salesianostriana.dam.U2.E02_Ejercicio1.models.Profesor;
import com.salesianostriana.dam.U2.E02_Ejercicio1.models.Video;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {

    private final CursoOnlineRepository cursoOnlineRepository;
    private final ProfesorRepository profesorRepository;

    @PostConstruct
    public void initData(){
        Profesor p1 = Profesor.builder()
                .nombre("Sebastián")
                .email("sebas@gmail.com")
                .puntuacion(8.5)
                .build();

        Profesor p2 = Profesor.builder()
                .nombre("Fernando")
                .email("fer@gmail.com")
                .puntuacion(9.2)
                .build();

        profesorRepository.saveAll(List.of(p1,p2));

        CursoOnline c1 = CursoOnline.builder()
                .nombre("Spring Boot 3 Básico")
                .puntuacion(7.8)
                .build();

        CursoOnline c2 = CursoOnline.builder()
                .nombre("HTML Básico")
                .puntuacion(9)
                .build();

        c1.addProfesor(p1);
        c2.addProfesor(p2);

        cursoOnlineRepository.saveAll(List.of(c1,c2));

        Video v1 = Video.builder()
                .orden(1)
                .titulo("Crear DTO")
                .descripcion("Aprender en Spring DTO")
                .url("https://start.spring.io/")
                .build();

        Video v2 = Video.builder()
                .orden(2)
                .titulo("Eliminar DTO")
                .descripcion("Aprender en Spring DTO")
                .url("https://start.spring.io/")
                .build();

        Video v3 = Video.builder()
                .orden(1)
                .titulo("Crear HTML")
                .descripcion("Primer Hola Mundo en h1")
                .url("https://start.spring.io/")
                .build();

        Video v4 = Video.builder()
                .orden(2)
                .titulo("Crear un párrafo en HTML")
                .descripcion("Aprender la etiqueta de p")
                .url("https://start.spring.io/")
                .build();

        c1.addVideo(v1);
        c1.addVideo(v2);
        c2.addVideo(v3);
        c2.addVideo(v4);

        cursoOnlineRepository.saveAll(List.of(c1,c2));




    }
}
