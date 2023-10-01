/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.openwebinars.taller.app.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import net.openwebinars.taller.app.modelos.Auto;
import net.openwebinars.taller.app.modelos.Matricula;
import net.openwebinars.taller.app.modelos.MatriculaMapper;
import net.openwebinars.taller.app.modelos.Persona;
import net.openwebinars.taller.app.repositorios.AutoRepositorio;
import net.openwebinars.taller.app.repositorios.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author adelm
 */
@Service
public class MatriculaServicio {
    @Autowired
    private MatriculaMapper mapper;
    
    @Autowired
    private AutoRepositorio repositorioAuto;
    
    @Autowired
    private PersonaRepositorio repositorioPersona;

    public Matricula guardar(Matricula entity) {
        repositorioPersona.save(mapper.toPersona(entity));
        repositorioAuto.save(mapper.toAuto(entity));        
        return entity;
    }

}
