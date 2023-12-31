package com.salesianostriana.dam.EjemploRestOpenAPI_CursoOW.controller;

import com.salesianostriana.dam.EjemploRestOpenAPI_CursoOW.model.Employee;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
@Tag(name="Employee", description = "Employee API REST with CRUD Operations")
public class EmployeeController {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retrieved employees", content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Employee.class)))})
            }
    )
    @Operation(summary = "findAll employees", description = "It retrieves all employees " +
            "from database without pagination")
    @GetMapping("/")
    public ResponseEntity<List<Employee>> findAll(){
        return null;
    }
}
