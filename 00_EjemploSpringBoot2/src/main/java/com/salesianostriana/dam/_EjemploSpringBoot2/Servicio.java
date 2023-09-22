package com.salesianostriana.dam._EjemploSpringBoot2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Servicio {

    private final Componente componente;
    private final Componente2 componente2;

    public void run(){
        componente.print();
        componente2.print();
    }

}
