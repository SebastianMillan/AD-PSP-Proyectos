package com.salesianostriana.dam.EjemploLibreriaJackson_CursoOW.repository;

import com.salesianostriana.dam.EjemploLibreriaJackson_CursoOW.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select disctinct c from Customer c join fetch c.vehicles")
    List<Customer> findWithVehicles();
}
