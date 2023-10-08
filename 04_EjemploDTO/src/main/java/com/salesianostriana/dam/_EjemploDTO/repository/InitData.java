package com.salesianostriana.dam._EjemploDTO.repository;

import com.salesianostriana.dam._EjemploDTO.model.Categoria;
import com.salesianostriana.dam._EjemploDTO.model.Dificultad;
import com.salesianostriana.dam._EjemploDTO.model.Monumento;
import com.salesianostriana.dam._EjemploDTO.model.Ruta;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {

    private final CategoriaRepository categoriaRepository;
    private final MonumentoRepository monumentoRepository;
    private final RutaRepository rutaRepository;

    @PostConstruct
    public void initData(){

        Categoria c =new Categoria(1L, "Religiosos");
        categoriaRepository.save(c);

        Monumento m1 = Monumento.builder()
                .nombre("Catedral de Sevilla")
                .localizacion("123,123")
                .localidad("Sevilla")
                .imagenes(List.of("http://imagen1.jpg", "http://imagen2.jpg"))
                .categoria(c)
                .codPais("es")
                .build();

        Monumento m2 = Monumento.builder()
                .nombre("San Luis de los Franceses")
                .localizacion("123,123")
                .localidad("Sevilla")
                .imagenes(List.of("http://imagen3.jpg", "http://imagen4.jpg"))
                .categoria(c)
                .codPais("es")
                .build();
        monumentoRepository.saveAll(List.of(m1, m2));

        Ruta r = Ruta.builder()
                .nombre("Iglesias wenas de verdá")
                .dificultad(Dificultad.BAJA)
                .tiempo(20)
                .lista(List.of(m1, m2))
                .build();
        rutaRepository.save(r);
    }
}
