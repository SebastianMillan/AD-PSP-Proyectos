package com.salesianostriana.dam.EjemploRestOpenAPI_CursoOW.controller;

import com.salesianostriana.dam.EjemploRestOpenAPI_CursoOW.model.Employee;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Tag(name="Employee")
public class EmployeeController {

    @GetMapping("/")
    public ResponseEntity<List<Employee>> findAll(){
        return null;
    }
}
