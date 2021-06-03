package io.juanqui.disney.dto;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

@Value
@AllArgsConstructor
public class PersonajeDto {
    @NonNull
    private final String imageUrl;
    @NonNull
    private final String name;
}
