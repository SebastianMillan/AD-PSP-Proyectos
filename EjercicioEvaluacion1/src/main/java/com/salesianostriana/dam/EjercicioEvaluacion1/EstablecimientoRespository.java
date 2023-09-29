package com.salesianostriana.dam.EjercicioEvaluacion1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface EstablecimientoRespository extends JpaRepository<Establecimiento, Long> {

    public default void init(){

        save(new Establecimiento(1L,"McDonald","San Luís","Sevilla","-100,-30","-30,56","Lugar para comer","https://img.jpg", new ArrayList<String>()));
        save(new Establecimiento(2L,"PizzaSevilla","Macarena","Sevilla","-120,-40","-120,96","Lugar para comer pizza","https://img2.jpg", new ArrayList<String>()));
        save(new Establecimiento(3L,"Bar Manolo","Atocha","Madrid","-20,-100","-70,-56","Lugar para beber cerveza","https://img3.jpg", new ArrayList<String>()));

    }
}
