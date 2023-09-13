package com.sanvalero.gym.controller;

import com.sanvalero.gym.domain.Rutina;
import com.sanvalero.gym.service.RutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class RutinaController {


    //Conexion con el Service
    @Autowired
    private RutinaService rutinaService;
    //Conexion del logg para las trazas de control
    private final Logger logger = LoggerFactory.getLogger(RutinaController.class);
    //Metodos de listar, borrar, modificar y añadir

    @GetMapping(value = "/gym/rutins")
    public Flux<ResponseEntity<Rutina>> getRutina() {
        Flux<Rutina> rutinas = rutinaService.findAll().delayElements(Duration.ofSeconds(3));
        logger.debug("RutinaController: Iniciado get rutinas");
        return rutinas.map(rutina -> ResponseEntity.ok(rutina));
    }

    @PostMapping(value = "/gym/rutinas")
    public Mono<ResponseEntity<Rutina>> addRutina(@RequestBody Rutina rutina) {
        logger.debug("RutinaController: Iniciado post rutinas");
        return rutinaService.addRutina(rutina).delayElement(Duration.ofSeconds(3))
                .map(newRutina -> ResponseEntity.status(HttpStatus.CREATED).body(newRutina));
    }

    @DeleteMapping(value = "/gym/rutina/{id}")
    public Mono<ResponseEntity<Void>> deleteRutina(@PathVariable long id) {
        logger.debug("RutinaController: Iniciado delete rutinas");
        return rutinaService.deleteRutina(id).delayElement(Duration.ofSeconds(3))
                .then(Mono.just(ResponseEntity.noContent().<Void>build()));
    }

    @PutMapping(value = "/gym/rutina/{id}")
    public Mono<ResponseEntity<Rutina>> modifyRutina(@PathVariable long id, @RequestBody Rutina rutina) {
        logger.debug("RutinaController: Iniciado put rutinas");
        return rutinaService.modifyRutina(id, rutina).delayElement(Duration.ofSeconds(3))
                .map(modifiedRutina -> ResponseEntity.status(HttpStatus.OK).body(modifiedRutina));
    }

}
