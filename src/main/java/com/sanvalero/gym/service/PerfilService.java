package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Perfil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PerfilService {
    //Listar distintos tipos de campos en perfil
    Flux<Perfil> findAll();
    Mono<Perfil> findById(long id);
    Flux<Perfil> findByObesidad(boolean obesidad);
    //Crear perfil
    Mono<Perfil> addPerfil(Perfil perfil);
    //Borrar perfil
    Mono<Void> deletePerfil(long id);
    //Modificar perfil
    Mono<Perfil> modifyPerfil(long id, Perfil newPerfil);
}
