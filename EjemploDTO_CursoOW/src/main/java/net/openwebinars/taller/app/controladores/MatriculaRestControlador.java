/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.openwebinars.taller.app.controladores;

import java.util.List;
import net.openwebinars.taller.app.modelos.Matricula;
import net.openwebinars.taller.app.servicios.AutoServicio;
import net.openwebinars.taller.app.servicios.MatriculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author adelm
 */
@RestController
@RequestMapping(value = "ws/matricula/")
@CrossOrigin("*")
public class MatriculaRestControlador {
    
    @Autowired
    private MatriculaServicio servicio;

    @PostMapping(value = "/guardar")
    public Matricula guardar(@RequestBody Matricula auto) {
        return servicio.guardar(auto);
    }
}
