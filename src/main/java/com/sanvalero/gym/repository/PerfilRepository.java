package com.sanvalero.gym.repository;

import com.sanvalero.gym.domain.Perfil;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface PerfilRepository extends ReactiveMongoRepository<Perfil, Long> {
    //Clases que acceden Bases de datos
    Flux<Perfil> findAll();
    Flux<Perfil> findByObesidad(boolean obesidad);
}
