package com.sanvalero.gym.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import reactor.core.publisher.Flux;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "usuario")
public class Usuario {

    @Id
    private long id;

    @Field
    private String nombreUsuario;

    @Field
    private String dniUsuario;

    @Field
    private String correo;

    @Field
    private LocalDate fechaNacimiento;

    @Field
    private String phone;

    @Field
    private boolean lesionado;

}
