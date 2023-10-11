package com.salesianostriana.dam.EjemploRestOpenAPI_CursoOW.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Employee {

    @Schema(example = "4", description = "Identificador clave primaria empleado numérico autoincrementado")
    private Long id;

    @Schema(example = "Sebastián", description = "Nombre completo empleado")
    private String name;

    @Schema(example = "2022-01-01", description = "Fecha de nacimiento yyyy-MM-dd")
    private LocalDate birthDate;

    @Schema(example = "2340,43", description = "Sueldo mensual bruto del trabajador")
    private Double salary;

    @Schema(example = "false", description = "Situación matrimonial")
    private Boolean married;

}
