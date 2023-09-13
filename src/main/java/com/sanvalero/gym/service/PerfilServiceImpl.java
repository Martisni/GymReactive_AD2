package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Perfil;
import com.sanvalero.gym.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class PerfilServiceImpl implements PerfilService{

    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public Flux<Perfil> findAll() {
        return perfilRepository.findAll();
    }

    @Override
    public Mono<Perfil> findById(long id) {
        return perfilRepository.findById(id);
    }

    @Override
    public Flux<Perfil> findByObesidad(boolean obesidad) {
        return perfilRepository.findByObesidad(obesidad);
    }

    @Override
    public Mono<Perfil> addPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    @Override
    public Mono<Void> deletePerfil(long id){
        return perfilRepository.findById(id)
                .flatMap(perfilRepository::delete);
    }

    @Override
    public Mono<Perfil> modifyPerfil(long id, Perfil newPerfil) {
        return perfilRepository.findById(id)
                .flatMap(existingPerfil -> {
        existingPerfil.setFechaMedicion(newPerfil.getFechaMedicion());
        existingPerfil.setObesidad(newPerfil.isObesidad());
        existingPerfil.setRitmoCardico(newPerfil.getRitmoCardico());
        existingPerfil.setImc(newPerfil.getImc());
        existingPerfil.setPeso(newPerfil.getPeso());
        existingPerfil.setMedidas(newPerfil.getMedidas());
        return perfilRepository.save(existingPerfil);
        });
    }
}
