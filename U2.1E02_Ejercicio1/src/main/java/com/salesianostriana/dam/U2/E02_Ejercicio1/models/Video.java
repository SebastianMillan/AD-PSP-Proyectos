package com.salesianostriana.dam.U2.E02_Ejercicio1.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@AllArgsConstructor
@Getter
@Builder
@Setter
@RequiredArgsConstructor
@ToString
//@EqualsAndHashCode
public class Video implements Serializable {

    @EmbeddedId
    private VideoPK videoPK;

    private int orden;
    private String titulo;
    private String descripcion;
    private String url;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return Objects.equals(videoPK, video.videoPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(videoPK);
    }
}
