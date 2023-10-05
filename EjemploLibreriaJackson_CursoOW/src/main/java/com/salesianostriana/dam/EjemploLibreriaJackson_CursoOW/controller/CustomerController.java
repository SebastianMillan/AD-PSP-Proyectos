package com.salesianostriana.dam.EjemploLibreriaJackson_CursoOW.controller;

import com.salesianostriana.dam.EjemploLibreriaJackson_CursoOW.model.Customer;
import com.salesianostriana.dam.EjemploLibreriaJackson_CursoOW.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping("/")
    public ResponseEntity<List<Customer>> findAll(){
        List<Customer> lista = customerRepository.findWithVehicles();
        if(lista.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        return ResponseEntity.of(customerRepository.findById(id));
    }
}
