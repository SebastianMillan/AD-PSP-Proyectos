package com.salesianostriana.dam._EjemploDTO.error;

import com.salesianostriana.dam._EjemploDTO.exception.MonumentoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    //Cuando ocurra la excepcion MonumentoNotFoundException le modificaremos la respuesta de la excepcion aqui
    //Se le podrán añadir al problemDetail los campos que queramos que se muestren en la respuesta
    /*
    @ExceptionHandler(MonumentoNotFoundException.class)
    ProblemDetail handleMonumentoNotFoundException(MonumentoNotFoundException e){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Monumento no encontrado");
        //Si no tenemos documentación a la que agarrarnos al saltar el error no hace falta
        //problemDetail.setType(URI.create("localhost:8080/monumento"));
        problemDetail.setProperty("errorCategory","Generic");
        problemDetail.setProperty("timestamp",
                LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
                );
        return problemDetail;
    }
     */

    @ExceptionHandler(MonumentoNotFoundException.class)
    ErrorResponse handleMonumentoNotFoundException(MonumentoNotFoundException e){
        return ErrorResponse.builder(e, HttpStatus.NOT_FOUND, e.getMessage())
                .title("Monumento no encontrado")
                .property("errorCategory","Generic")
                .property("timestamp",LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")))
                .build();

    }
}
