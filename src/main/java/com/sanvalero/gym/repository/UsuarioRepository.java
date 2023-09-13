package com.sanvalero.gym.repository;

import com.sanvalero.gym.domain.Usuario;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface UsuarioRepository extends ReactiveMongoRepository<Usuario, Long> {

    //Clases que acceden Bases de datos
    Flux<Usuario> findAll();
    Flux<Usuario> findByLesionado(boolean lesionado);
    Flux<Usuario> findByDniUsuario(String dniUsuario);

}
