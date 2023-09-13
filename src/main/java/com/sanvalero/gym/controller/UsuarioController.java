package com.sanvalero.gym.controller;

import com.sanvalero.gym.domain.Usuario;
import com.sanvalero.gym.service.UsuarioService;
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
public class UsuarioController {

    //Conexion con el Service
    @Autowired
    private UsuarioService usuarioService;
    //Conexion del logg para las trazas de control
    private final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    //Metodos de listar, borrar, modificar y añadir
    @GetMapping(value ="/gym/users")
    public Flux<ResponseEntity<Usuario>> getUsuario() {
        Flux<Usuario> usuarios = usuarioService.findAll().delayElements(Duration.ofSeconds(3));
        logger.debug("UsuarioController: Iniciado get usuario");
        return usuarios.map(usuario -> ResponseEntity.ok(usuario));
    }

    @PostMapping(value ="/gym/usuario")
    public Mono<ResponseEntity<Usuario>> addUsuario(@RequestBody Usuario usuario) {
        logger.debug("UsuarioController: Iniciado post usuario");
        return usuarioService.addUsuario(usuario).delayElement(Duration.ofSeconds(3))
                .map(newUsuario -> ResponseEntity.status(HttpStatus.CREATED).body(newUsuario));
    }

    @DeleteMapping(value ="/gym/usuario/{id}")
    public Mono<ResponseEntity<Void>> deleteUsuario(@PathVariable long id) {
        logger.debug("UsuarioController: Iniciado delete usuario");
        return usuarioService.deleteUsuario(id).delayElement(Duration.ofSeconds(3))
                        .then(Mono.just(ResponseEntity.noContent().<Void>build()));
    }

    @PutMapping(value ="/gym/usuario/{id}")
    public Mono<ResponseEntity<Usuario>> modifyUsuario(@PathVariable long id, @RequestBody Usuario usuario) {
        logger.debug("UsuarioController: Iniciado put usuario");
        return usuarioService.modifyUsuario(id, usuario).delayElement(Duration.ofSeconds(3))
                .map(modifiedUsuario -> ResponseEntity.status(HttpStatus.OK).body(modifiedUsuario));
    }

}
