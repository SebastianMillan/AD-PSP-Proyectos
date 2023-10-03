package com.salesianostriana.dam.EjemploJSONViews_CursoOW.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.NoArgsConstructor;
import static com.salesianostriana.dam.EjemploJSONViews_CursoOW.model.CustomerView.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Customer {

    //El id se va a ver en la vista lista y a su vez por herencia en la de detalle
    @JsonView({CustomerList.class, CustomerFull.class})
    private Long id;

    @JsonView({CustomerDetail.class, CustomerFull.class})
    private String name;

    @JsonView({CustomerList.class, CustomerEdit.class, CustomerFull.class})
    private String email;

    //Ignoramos la contraseña para que no se muestre en ninguna vista
    @JsonIgnore
    private String password;

    @JsonView({CustomerEdit.class, CustomerFull.class})
    private String creditCard;

    @JsonView({CustomerDetail.class, CustomerEdit.class, CustomerFull.class})
    private Double salary;

    @JsonView({CustomerDetail.class, CustomerFull.class})
    private LocalDateTime createdAt;

    @JsonView({CustomerDetail.class, CustomerFull.class})
    private LocalDateTime lastLogin;

    @JsonView({CustomerDetail.class, CustomerEdit.class, CustomerFull.class})
    private Integer year;

    @JsonView({CustomerDetail.class, CustomerEdit.class, CustomerFull.class})
    private Boolean married;


    public Customer(Long id, String name, String email, Double salary, String password, String creditCard,
                    Integer year, Boolean married) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.password = password;
        this.creditCard = creditCard;
        this.createdAt = LocalDateTime.now();
        this.lastLogin = LocalDateTime.now();
        this.year = year;
        this.married = married;
    }

}
