package com.salesianostriana.dam.RepasoEnt_ModeloDatos.repositories;

import com.salesianostriana.dam.RepasoEnt_ModeloDatos.models.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {

    private final VacunaRepository vacunaRepository;
    private final CalendarioRepository calendarioRepository;
    private final PacienteRepository pacienteRepository;
    private final AdministracionRepository administracionRepository;

    @PostConstruct
    public void initData(){

        Vacuna v1 = Vacuna.builder()
                .nombre("Nombre1")
                .descripcionEnfermedad("Para SIDA")
                .build();

        Vacuna v2 = Vacuna.builder()
                .nombre("Nombre2")
                .descripcionEnfermedad("Para COVID-19")
                .build();

        vacunaRepository.saveAll(List.of(v1,v2));

        Calendario c1 = new Calendario();
        c1.setEdad(24);
        c1.setTipoDosis("Monodosis");
        c1.setRecomendaciones("Con cuidado");
        c1.setDiscriminante(Discriminante.TODOS);
        c1.setVacuna(v1);

        Calendario c2 = new Calendario();
        c2.setEdad(12);
        c2.setTipoDosis("Tres dosis");
        c2.setRecomendaciones("En el brazo derecho");
        c2.setDiscriminante(Discriminante.H);
        c2.setVacuna(v2);

        calendarioRepository.saveAll(List.of(c2,c1));

        Paciente p1 = Paciente.builder()
                .nombre("Sebastián")
                .apellidos("Millán")
                .telefonoContacto("11233231")
                .fechaNacimiento(LocalDate.of(2000,7,26))
                .notas("Ninguna")
                .build();

        Paciente p2 = Paciente.builder()
                .nombre("Fernando")
                .apellidos("Claro")
                .telefonoContacto("332332332")
                .fechaNacimiento(LocalDate.of(2002,2,22))
                .notas("Ninguna")
                .build();

        pacienteRepository.saveAll(List.of(p1,p2));

        Administracion a1 = Administracion.builder()
                .fecha(LocalDateTime.of(2023,1,5,14,54))
                .edadAlAdministrar(25)
                .notas("Enrojecimiento")
                .build();

        Administracion a2 = Administracion.builder()
                .fecha(LocalDateTime.of(2023,5,3,10,32))
                .edadAlAdministrar(12)
                .notas("Dolor")
                .build();

        Administracion a3 = Administracion.builder()
                .fecha(LocalDateTime.of(2023,6,13,11,11))
                .edadAlAdministrar(33)
                .notas("Nada")
                .build();

        Administracion a4 = Administracion.builder()
                .fecha(LocalDateTime.of(2023,7,1,4,32))
                .edadAlAdministrar(21)
                .notas("Nada")
                .build();

        a1.addPaciente(p1);
        a1.addCalendario(c1);
        a2.addPaciente(p1);
        a2.addCalendario(c2);
        a3.addPaciente(p2);
        a3.addCalendario(c1);
        a4.addPaciente(p2);
        a4.addCalendario(c2);

        administracionRepository.saveAll(List.of(a1,a2,a3,a4));








    }
}
