package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Usuario;
import com.sanvalero.gym.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Flux<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Flux<Usuario> findByLesionado(boolean lesionado) {
        return usuarioRepository.findByLesionado(lesionado);
    }

    @Override
    public Flux<Usuario> findByDniUsuario(String dniUsuario) {
        return usuarioRepository.findByDniUsuario(dniUsuario);
    }

    @Override
    public Mono<Usuario> findById(long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Mono<Usuario> addUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Mono<Void> deleteUsuario(long id) {
        return usuarioRepository.findById(id)
                .flatMap(usuarioRepository::delete);
    }

    @Override
    public Mono<Usuario> modifyUsuario(long id, Usuario newUsuario) {
        return usuarioRepository.findById(id)
                .flatMap(existingUsuario -> {
                    existingUsuario.setNombreUsuario(newUsuario.getNombreUsuario());
                    existingUsuario.setCorreo(newUsuario.getCorreo());
                    existingUsuario.setPhone(newUsuario.getPhone());
                    existingUsuario.setLesionado(newUsuario.isLesionado());
                    return usuarioRepository.save(existingUsuario);
                });
    }
}
