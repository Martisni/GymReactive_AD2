package com.sanvalero.gym.controller;

import com.sanvalero.gym.domain.Perfil;
import com.sanvalero.gym.repository.PerfilRepository;
import com.sanvalero.gym.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PerfilController {

    //Conexion con el Service
    @Autowired
    private PerfilService perfilService;
    //Conexion del logg para las trazas de control
    private static final Logger logger = LoggerFactory.getLogger(PerfilController.class);
    @Autowired
    private PerfilRepository perfilRepository;

    //Controladores de peticiones HTTP del CRUD

    @GetMapping(value = "/gym/perfils")
    public Flux<ResponseEntity<Perfil>> getPerfil() {
        Flux<Perfil> perfiles = perfilRepository.findAll().delayElements(Duration.ofSeconds(3));
        logger.debug("PerfilController: Iniciado get perfil");
        return perfiles.map(perfil -> ResponseEntity.ok(perfil));

    }

    @PostMapping(value = "/gym/perfiles")
    public Mono<ResponseEntity<Perfil>> addPerfil(@RequestBody Perfil perfil) {
        logger.debug("HorarioController: Iniciado post perfil");
        return perfilService.addPerfil(perfil).delayElement(Duration.ofSeconds(3))
                .map(newPerfil -> ResponseEntity.status(HttpStatus.CREATED).body(newPerfil));
    }

    @DeleteMapping(value = "/gym/perfil/{id}")
    public Mono<ResponseEntity<Void>> deletePerfil(@PathVariable long id) {
        logger.debug("HorarioController: Iniciado delete perfil");
        return perfilService.deletePerfil(id).delayElement(Duration.ofSeconds(3))
                .then(Mono.just(ResponseEntity.noContent().<Void>build()));
    }

    @PutMapping(value ="/gym/perfil/{id}")
    public  Mono<ResponseEntity<Perfil>> modifyPerfil(@PathVariable long id, @RequestBody Perfil perfil) {
        logger.debug("HorarioController: Iniciado put perfil");
        return perfilService.modifyPerfil(id, perfil).delayElement(Duration.ofSeconds(3))
                .map(modifiedPerfil -> ResponseEntity.status(HttpStatus.OK).body(modifiedPerfil));
    }

}
