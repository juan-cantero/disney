package io.juanqui.disney.helpers.mapper;

import io.juanqui.disney.dto.PersonajeDto;
import io.juanqui.disney.model.Personaje;

import java.util.List;
import java.util.stream.Collectors;


public class PersonajeMapper {
    public static List<PersonajeDto> personajesToPersonajesDto(List<Personaje> personajes) {
        return personajes.stream()
                .map(p-> new PersonajeDto(p.getNombre(),p.getImagenUrl()))
                .collect(Collectors.toList());
    }
}
