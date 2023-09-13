package com.sanvalero.gym.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import reactor.core.publisher.Flux;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "rutina")
public class Rutina {

    @Id
    private long id;

    @Field
    private String modalidad;

    @Field
    private boolean material;

    @Field
    private int numeroSeries;

    @Field
    private int numeroRepeticiones;

    @Field
    private int diasEntrenados;

    @Field
    private int duracion;

}
