package io.juanqui.disney.dto.request;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

// value is used to get inmutable objects
@Value
@AllArgsConstructor
public class CreatePersonajeRequest {
    private String nombre;
    private int edad;
    private Float peso;
    private String historia;
    private String imagenUrl;
    private List<Integer> animaciones;
}
