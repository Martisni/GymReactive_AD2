package com.sanvalero.gym.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import reactor.core.publisher.Flux;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "perfil")
public class Perfil {

    @Id
    private long id;

    @Field
    private int ritmoCardico;

    @Field
    private int peso;

    @Field
    private int imc;

    @Field
    private boolean obesidad;

    @Field
    private Date fechaMedicion;

    @Field
    private String medidas;

}
