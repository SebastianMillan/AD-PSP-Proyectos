package com.salesianostriana.dam._EjemploApiRest;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ControladorAlumno {

    private final AlumnoRepositorio alumnoRepositorio;

    @GetMapping("/alumno/")
    public ResponseEntity<List<Alumno>> getAll() {
        List<Alumno> result = alumnoRepositorio.findAll();
        if(result.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(result);
    }

    @GetMapping("/alumno/{id}")
    public ResponseEntity<Alumno> findById(@PathVariable long id){
        //El método of recibe un optional y en funcion de si esta vacio o no devuelve un responseEntitity u otro
        return ResponseEntity.of(alumnoRepositorio.findById(id));
    }

    @PostMapping("/alumno/")
    public ResponseEntity<Alumno> create(@RequestBody Alumno alumno){
        Alumno nuevo = alumnoRepositorio.save(alumno);
        //return ResponseEntity.created(null).body(nuevo);
        return ResponseEntity.status(201).body(nuevo);
    }

    @PutMapping("/alumno/{id}")
    public ResponseEntity<Alumno> edit(@RequestBody Alumno alumno, @PathVariable long id){

        return ResponseEntity.of(alumnoRepositorio.findById(id)
                .map(antiguo -> {
                    antiguo.setNombre(alumno.getNombre());
                    antiguo.setApellidos(alumno.getApellidos());
                    antiguo.setEmail(alumno.getEmail());
                    antiguo.setEdad(alumno.getEdad());
                    return alumnoRepositorio.save(antiguo);
                }));

    }

    @DeleteMapping("/alumno/{id}")
    public ResponseEntity<?> delete(@RequestBody Alumno alumno, @PathVariable long id){

        if(alumnoRepositorio.existsById(id))
            alumnoRepositorio.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
