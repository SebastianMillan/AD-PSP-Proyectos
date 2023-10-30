package com.salesianostriana.dam.ConfigJPA_CursoOW;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {

    private final EmployeeRepository employeeRepository;
    @PostConstruct
    public void initData(){
        Employee e1 = Employee.builder()
                .name("Sebastián")
                .lastName("Millán")
                .build();

        Employee e2 = Employee.builder()
                .name("Fernando")
                .lastName("Claro")
                .build();


        employeeRepository.saveAll(List.of(e1,e2));
    }
}
