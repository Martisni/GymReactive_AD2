package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Usuario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UsuarioService {
    //Listar distintos tipos de campos en usuario
    Flux<Usuario> findAll();
    Flux<Usuario> findByLesionado(boolean lesionado);
    Flux<Usuario> findByDniUsuario(String dniUsuario);
    Mono<Usuario> findById(long id);

    //Crear usuario
    Mono<Usuario> addUsuario(Usuario usuario);

    //Borrar usuario
    Mono<Void> deleteUsuario(long id);

    //Modificar usuario
    Mono<Usuario> modifyUsuario(long id, Usuario newUsuario);
}
