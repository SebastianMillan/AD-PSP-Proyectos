package com.salesianostriana.dam.EjemploLibreriaJackson_CursoOW.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

//JsonPropertyOrder -> Cambiar orden de como se va a comportar en nuestra API Rest
//JsonInclude -> Incluir en los JSON solo los que no son nulos
@JsonPropertyOrder({"id","cc","releasedYer","model"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;

    private String model;
    @JsonProperty("cc") //Modifico el nombre del atributo que le llega al JSON
    private Double cubicCentimeters;
    private Integer releasedYear;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public Vehicle(){

    }

    public Vehicle(String model, Double cubicCentimeters, Integer releasedYear, Customer customer) {
        this.model = model;
        this.cubicCentimeters = cubicCentimeters;
        this.releasedYear = releasedYear;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getCubicCentimeters() {
        return cubicCentimeters;
    }

    public void setCubicCentimeters(Double cubicCentimeters) {
        this.cubicCentimeters = cubicCentimeters;
    }

    public Integer getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(Integer releasedYear) {
        this.releasedYear = releasedYear;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", cubicCentimeters=" + cubicCentimeters +
                ", releasedYear=" + releasedYear +
                '}';
    }
}


