package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Rutina;
import com.sanvalero.gym.repository.RutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class RutinaServiceImpl implements RutinaService {

    @Autowired
    private RutinaRepository rutinaRepository;

    @Override
    public Flux<Rutina> findAll() {
        return rutinaRepository.findAll();
    }

    @Override
    public Flux<Rutina> findByMaterial(boolean material) {
        return rutinaRepository.findByMaterial(material);
    }

    @Override
    public Flux<Rutina> findByModalidad(String modalidad) {
        return rutinaRepository.findByModalidad(modalidad);
    }

    @Override
    public Mono<Rutina> findById(long id) {
        return rutinaRepository.findById(id);
    }

    @Override
    public Mono<Rutina> addRutina(Rutina rutina) {
        return rutinaRepository.save(rutina);
    }

    @Override
    public Mono<Void> deleteRutina(long id) {
        return rutinaRepository.findById(id)
                .flatMap(rutinaRepository::delete);
    }

    @Override
    public Mono<Rutina> modifyRutina(long id, Rutina newRutina) {
        return rutinaRepository.findById(id)
                .flatMap(existingRutina -> {
                    existingRutina.setDiasEntrenados(newRutina.getDiasEntrenados());
                    existingRutina.setDuracion(newRutina.getDuracion());
                    existingRutina.setModalidad(newRutina.getModalidad());
                    existingRutina.setNumeroRepeticiones(newRutina.getNumeroRepeticiones());
                    existingRutina.setNumeroSeries(newRutina.getNumeroSeries());
                    existingRutina.setMaterial(newRutina.isMaterial());
                    return rutinaRepository.save(existingRutina);
                });
    }
}