package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Rutina;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface RutinaService {

    //Listar distintos tipos de campos en rutina
    Flux<Rutina> findAll();
    Flux<Rutina> findByMaterial(boolean material);
    Flux<Rutina> findByModalidad(String modalidad);
    Mono<Rutina> findById(long id);
    //Crear rutina
    Mono<Rutina> addRutina(Rutina rutina);
    //Borrar rutina
    Mono<Void> deleteRutina (long id);
    //Modificar rutina
    Mono<Rutina> modifyRutina(long id, Rutina newRutina);

}
