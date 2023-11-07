package com.salesianostriana.dam.BorradoEntidades_CursoOW.sqldelete;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;
import org.hibernate.type.NumericBooleanConverter;

@SQLDelete(sql = "UPDATE Employee SET deleted = 1 WHERE id = ?")@Where(clause = "deleted = 0")
@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    //@Type(type = "org.hibernate.type.NumericBooleanType") -> No funciona
    @Convert(converter = NumericBooleanConverter.class)
    private Boolean deleted;

    public Employee(String name){
        this.name=name;
        this.deleted=false;
    }

}
