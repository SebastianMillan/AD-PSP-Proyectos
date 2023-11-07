package com.salesianostriana.dam.BorradoEntidades_CursoOW.sqldelete;

import com.salesianostriana.dam.BorradoEntidades_CursoOW.sqldelete.Employee;
import com.salesianostriana.dam.BorradoEntidades_CursoOW.sqldelete.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Component;

import java.nio.Buffer;
import java.util.List;
/*
@RequiredArgsConstructor
@Component
public class InitData {

    private final EmployeeRepository employeeRepository;

    @PostConstruct
    public void initData(){

        Employee e1 = new Employee("Sebastián");
        Employee e2 = new Employee("Fernando");
        Employee e3 = new Employee("Pepe");

        employeeRepository.saveAll(List.of(e1,e2,e3));
        System.out.println("Num Empleado : "+employeeRepository.count());
        employeeRepository.deleteById(1L);
        System.out.println("Num Empleado : "+employeeRepository.count());

    }
}


 */