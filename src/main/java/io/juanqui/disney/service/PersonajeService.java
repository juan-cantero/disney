package io.juanqui.disney.service;

import io.juanqui.disney.dto.PersonajeDto;
import io.juanqui.disney.dto.request.CreatePersonajeRequest;
import io.juanqui.disney.model.Personaje;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonajeService {
    List<PersonajeDto> getListaDePersonajes();
    Personaje getPersonajeById(int id);
    Personaje crearPersonaje(CreatePersonajeRequest personajeRequest);
    List<Personaje> getPersonajesByCriteria(String name, Integer age, Float weight, Integer idMovie);

}
