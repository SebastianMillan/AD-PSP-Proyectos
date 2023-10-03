package com.salesianostriana.dam.EjemploJSONViews_CursoOW.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.salesianostriana.dam.EjemploJSONViews_CursoOW.model.Customer;
import com.salesianostriana.dam.EjemploJSONViews_CursoOW.model.CustomerView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.salesianostriana.dam.EjemploJSONViews_CursoOW.model.CustomerView.*;


import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private List<Customer> customers;

    public CustomerController(){
        this.customers=List.of(
                new Customer(1L, "cust1", "cust1gmail.com", 3000.0, "admin","1234", 2021, true),
                new Customer(2L, "cust2", "cust1gmail.com", 5000.0, "admin","1234", 2021, true),
                new Customer(3L, "cust3", "cust3gmail.com", 1000.0, "admin","1234", 2021, true)
        );
    }

    @GetMapping("/")
    @JsonView(CustomerList.class)
    public List<Customer> findAll(){
        return customers;
    }

    @GetMapping("/{id}")
    @JsonView(CustomerDetail.class)
    public Customer findById(@PathVariable Long id){
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }

    @GetMapping("/edit/{id}")
    @JsonView(CustomerEdit.class)
    public Customer findByIdForEdit(@PathVariable Long id){
        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow();
    }
}
