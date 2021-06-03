package io.juanqui.disney.controller;

import io.juanqui.disney.dto.request.CreatePersonajeRequest;
import io.juanqui.disney.model.Personaje;
import io.juanqui.disney.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonajeController {
    @Autowired
    private PersonajeService personajeService;

    @GetMapping("/api/characters")
    public ResponseEntity<List<Object>> getListaDePersonajes(
            @RequestParam(value = "name",required = false,defaultValue = "") String name,
            @RequestParam(value="weight",required = false,defaultValue = "") Float weight,
            @RequestParam(value="age",required = false,defaultValue = "") Integer age,
            @RequestParam(value="idMedia",required = false,defaultValue = "") Integer idMedia

    ) {
        var personajes = personajeService.getPersonajesByCriteria(name,age,weight,idMedia);
        return new ResponseEntity(personajes, HttpStatus.OK);
    }

    @GetMapping("api/characters/{id}")
    public ResponseEntity<Personaje> getPersonajeById(@PathVariable("id") int id) {

        var personaje = personajeService.getPersonajeById(id);

        return new ResponseEntity(personaje, HttpStatus.OK);
    }

    @PostMapping("api/characters")
    public ResponseEntity<Personaje> createPersonaje(@RequestBody CreatePersonajeRequest personajeRequest) {
        var personajeCreado = personajeService.crearPersonaje(personajeRequest);
        return new ResponseEntity<>(personajeCreado,HttpStatus.OK);
    }





}
