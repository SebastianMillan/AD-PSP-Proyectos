package com.salesianostriana.dam.U2.E02_Ejercicio1.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Builder
@Entity
@AllArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@IdClass(VideoPK.class)
//@EqualsAndHashCode
public class Video {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Id
    private CursoOnline curso;

    private int orden;
    private String titulo;
    private String descripcion;
    private String url;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return id == video.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public VideoPK getId() {
        return new VideoPK(curso, id);
    }

    public void setId(VideoPK videoPK) {
        this.curso= videoPK.getCursoOnline();
        this.id= videoPK.getId();
    }
}
