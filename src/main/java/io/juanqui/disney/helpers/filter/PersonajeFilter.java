package io.juanqui.disney.helpers.filter;

import io.juanqui.disney.model.Personaje;

import java.util.ArrayList;
import java.util.List;

public class PersonajeFilter {
    public static List<Personaje> filterByPersonajesQueAparecenEnAnimacion(List<Personaje> personajes, int idAnimacion) {

        List<Personaje> personajesQueEstuvieronEnAnimacion = new ArrayList<>();

        for (Personaje p : personajes) {
            if (p.getAnimaciones().stream().anyMatch(a -> a.getId() == idAnimacion)) {
                personajesQueEstuvieronEnAnimacion.add(p);
            }
        }
        return personajesQueEstuvieronEnAnimacion;
    }
}
