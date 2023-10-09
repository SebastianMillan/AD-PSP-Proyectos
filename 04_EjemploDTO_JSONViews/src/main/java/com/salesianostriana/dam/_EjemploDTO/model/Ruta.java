package com.salesianostriana.dam._EjemploDTO.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam._EjemploDTO.views.RutaView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import static com.salesianostriana.dam._EjemploDTO.views.RutaView.*;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ruta {
    @Id
    @GeneratedValue
    @JsonView(RutaView.RutaList.class)
    private Long id;

    @JsonView({RutaList.class, RutaEdit.class})
    private String nombre;

    @Enumerated(EnumType.STRING)
    @JsonView({RutaList.class, RutaEdit.class})
    private Dificultad dificultad;

    @ManyToMany
    @JsonView({RutaList.class, RutaEdit.class})
    private List<Monumento> lista;

    @JsonView({RutaList.class, RutaEdit.class})
    private int tiempo; // En minutos
}
