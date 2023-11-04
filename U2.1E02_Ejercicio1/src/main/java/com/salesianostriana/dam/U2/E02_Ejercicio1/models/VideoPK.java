package com.salesianostriana.dam.U2.E02_Ejercicio1.models;

import com.salesianostriana.dam.U2.E02_Ejercicio1.models.CursoOnline;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class VideoPK implements Serializable {

    @ManyToOne
    private CursoOnline cursoOnline;
    private Long idCurso;

    public VideoPK getId() {
        return new VideoPK(cursoOnline, idCurso);
    }


    public void setId(VideoPK videoPK) {
        this.idCurso= videoPK.getIdCurso();
        this.cursoOnline=videoPK.getCursoOnline();
    }

}
