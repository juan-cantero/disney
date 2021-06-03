package io.juanqui.disney.service.impl;

import io.juanqui.disney.dto.PersonajeDto;
import io.juanqui.disney.dto.request.CreatePersonajeRequest;
import io.juanqui.disney.exceptions.ResourceNotFoundException;
import io.juanqui.disney.helpers.filter.PersonajeFilter;
import io.juanqui.disney.helpers.mapper.PersonajeMapper;
import io.juanqui.disney.model.Animacion;
import io.juanqui.disney.model.Personaje;
import io.juanqui.disney.repository.PersonajeRepository;
import io.juanqui.disney.repository.specs.PersonajeSpecifications;
import io.juanqui.disney.service.AnimacionService;
import io.juanqui.disney.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;
    @Autowired
    private AnimacionService animacionService;

    @Override
    public List<PersonajeDto> getListaDePersonajes() {
        return PersonajeMapper
                .personajesToPersonajesDto((List<Personaje>) personajeRepository.findAll());
    }

    @Override
    public Personaje getPersonajeById(int id) {
        var personajeOptional = personajeRepository.findById(id);
        if (!personajeOptional.isPresent()) {
            throw new ResourceNotFoundException();
        }
        return personajeOptional.get();

        //throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "no existe ese personaje");
    }

    @Override
    public Personaje crearPersonaje(CreatePersonajeRequest personajeRequest) {
        var personaje = new Personaje();
        personaje.setNombre(personajeRequest.getNombre());
        personaje.setEdad(personajeRequest.getEdad());
        personaje.setHistoria(personajeRequest.getHistoria());
        personaje.setPeso(personajeRequest.getPeso());
        personaje.setImagenUrl(personajeRequest.getImagenUrl());

        Set<Animacion> animaciones =
                animacionService.getAnimacionesByIds(personajeRequest.getAnimaciones());
        personaje.setAnimaciones(animaciones);
        return personajeRepository.save(personaje);


    }



    @Override
    public List<Personaje> getPersonajesByCriteria(String name, Integer age, Float weight, Integer idMedia) {
        Specification<Personaje> specs =
                PersonajeSpecifications.likeFirstName(name)
                        .and(PersonajeSpecifications.equalAge(age))
                        .and(PersonajeSpecifications.equalWeight(weight));

        List<Personaje> personajes = personajeRepository.findAll(specs);

        if (idMedia != null) {
            return PersonajeFilter.filterByPersonajesQueAparecenEnAnimacion(personajes, idMedia);
        }


        return personajes;

    }



}
