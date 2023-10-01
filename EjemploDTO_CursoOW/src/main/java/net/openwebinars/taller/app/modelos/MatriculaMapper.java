/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.openwebinars.taller.app.modelos;

import org.springframework.stereotype.Component;

/**
 *
 * @author adelm
 */
@Component
public class MatriculaMapper {
    
    public Auto toAuto(Matricula matricula){
        return Auto.builder()
                .marca(matricula.getMarca())
                .modelo(matricula.getModelo())
                .placa(matricula.getPlaca())
                .propietario(matricula.getId())
                .build();
    }
    public Persona toPersona(Matricula matricula){
        return Persona.builder()
                    .id(matricula.getId())
                    .nombre(matricula.getNombrePropietario())
                    .build();
    }
}
