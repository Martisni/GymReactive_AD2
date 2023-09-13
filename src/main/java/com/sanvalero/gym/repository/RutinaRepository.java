package com.sanvalero.gym.repository;

import com.sanvalero.gym.domain.Rutina;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface RutinaRepository extends ReactiveMongoRepository<Rutina, Long> {

    //Clases que acceden Bases de datos
    Flux<Rutina> findAll();
    Flux<Rutina> findByMaterial(boolean material);
    Flux<Rutina> findByModalidad(String modalidad);

}
