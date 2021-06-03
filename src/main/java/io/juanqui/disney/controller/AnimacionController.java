package io.juanqui.disney.controller;

import io.juanqui.disney.model.Animacion;
import io.juanqui.disney.service.AnimacionService;
import io.juanqui.disney.service.impl.AnimacionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimacionController {
    @Autowired
    private AnimacionService animacionService;

    @GetMapping("/api/animaciones")
    public ResponseEntity<Iterable<Animacion>> getAnimaciones() {
        var animaciones = animacionService.getAnimaciones();
        return new ResponseEntity<>(animaciones, HttpStatus.OK);
    }

}
