package io.juanqui.disney.service.impl;

import io.juanqui.disney.model.Animacion;
import io.juanqui.disney.repository.AnimacionRepository;
import io.juanqui.disney.service.AnimacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AnimacionImpl implements AnimacionService {
    @Autowired
    private AnimacionRepository animacionRepository;

    @Override
    public Iterable<Animacion> getAnimaciones() {
        var animaciones = animacionRepository.findAll();
        return animaciones;
    }

    @Override
    public Set<Animacion> getAnimacionesByIds(List<Integer> animacionesIds) {
        return  animacionesIds
                .stream()
                .map(id -> animacionRepository.findById(id))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());

    }



}
