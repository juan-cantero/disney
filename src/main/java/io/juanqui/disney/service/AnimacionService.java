package io.juanqui.disney.service;

import io.juanqui.disney.model.Animacion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface AnimacionService {
    Set<Animacion> getAnimacionesByIds(List<Integer> animacionesIds);
    Iterable<Animacion> getAnimaciones();
}
