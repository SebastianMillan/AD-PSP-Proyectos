package com.salesianostriana.dam.EjemploLibreriaJackson_CursoOW.controller;

import com.salesianostriana.dam.EjemploLibreriaJackson_CursoOW.model.Vehicle;
import com.salesianostriana.dam.EjemploLibreriaJackson_CursoOW.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    @GetMapping("/")
    public ResponseEntity<List<Vehicle>> getAll(){
        List<Vehicle> lista = vehicleRepository.findAll();

        if(lista.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> findById(@PathVariable Long id){
        return ResponseEntity.of(vehicleRepository.findById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Vehicle> create(@RequestBody Vehicle vehicle){
        Vehicle nuevo = vehicleRepository.save(vehicle);
        return ResponseEntity.status(201).body(nuevo);
    }

}
