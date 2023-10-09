package com.salesianostriana.dam._EjemploDTO.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import static com.salesianostriana.dam._EjemploDTO.views.MonumentoView.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Monumento {

    @Id
    @GeneratedValue
    @JsonView({MonumentoList.class, MonumentoEnRuta.class, MonumentoDetails.class})
    private Long id;

    @JsonView({MonumentoList.class, MonumentoEnRuta.class, MonumentoDetails.class})
    private String nombre;

    @JsonView(MonumentoDetails.class)
    private String codPais;

    @JsonView(MonumentoDetails.class)
    private String pais;

    @JsonView({MonumentoList.class, MonumentoEnRuta.class, MonumentoDetails.class})
    private String ciudad;

    @JsonView({MonumentoList.class, MonumentoEnRuta.class, MonumentoDetails.class})
    private String localizacion;

    @JsonView(MonumentoDetails.class)
    private String descripcion;

    //@ElementCollection -> Obligaroio en Spring Boot 2
    @JsonView({MonumentoList.class, MonumentoEnRuta.class, MonumentoDetails.class})
    private List<String> imagenes;

    @ManyToOne
    @JsonView({MonumentoList.class, MonumentoEnRuta.class, MonumentoDetails.class})
    private Categoria categoria;

}
