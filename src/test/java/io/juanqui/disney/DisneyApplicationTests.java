package io.juanqui.disney;

import io.juanqui.disney.model.Animacion;
import io.juanqui.disney.model.GeneroAnimacion;
import io.juanqui.disney.model.Personaje;
import io.juanqui.disney.repository.AnimacionRepository;
import io.juanqui.disney.repository.GeneroAnimacionRepository;
import io.juanqui.disney.repository.PersonajeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.HashSet;

@SpringBootTest
class DisneyApplicationTests {

	@Autowired
	PersonajeRepository personajeRepository;
	@Autowired
	GeneroAnimacionRepository generoRepository;
	@Autowired
    AnimacionRepository animacionRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void cargarPersonajeAnimacionGenero() {

			var mickey = new Personaje();
			mickey.setNombre("minnie");
			mickey.setPeso(20F);
			mickey.setHistoria("ratona");
			mickey.setEdad(12);
			mickey.setImagenUrl("url-minnie");
			var animaciones = new HashSet<Animacion>();

			var animacion = new Animacion();
			var genero = new GeneroAnimacion();
			genero.setNombre("terror");
			genero.setImagenUrl("http://terror");
			generoRepository.save(genero);
			animacion.setTitulo("minnie rosa");
			animacion.setGenero(genero);
			animacion.setCalificacion(5);
			animacion.setFechaCreacion(LocalDate.of(2000, 02, 23));
			animacionRepository.save(animacion);
			mickey.addAnimacion(animacion);
		personajeRepository.save(mickey);

	}


	@Test
	void cargarPersonaje() {
		var pluto = new Personaje();
		pluto.setNombre("pluto");
		pluto.setHistoria("perro");
		pluto.setEdad(37);
		pluto.setPeso(23.0F);
		pluto.setImagenUrl("http:imagen-pluto");
		personajeRepository.save(pluto);
	}

	@Test
	void updateNombreDelPersonaje() {
		var personajeOptional = personajeRepository.findById(1);
		if (personajeOptional.isPresent()) {
			var personaje = personajeOptional.get();
			personaje.setNombre("minnie");
		personajeRepository.save(personaje);
		}

	}

	@Test
	void addPersonajeEnPelicula() {
		var animacionOptional = animacionRepository.findById(2);
		var personajeOptional = personajeRepository.findById(2);
		if (animacionOptional.isPresent() && personajeOptional.isPresent()) {
			var personaje = personajeOptional.get();
			var animacion = animacionOptional.get();
			var animaciones = new HashSet<Animacion>();
			personaje.addAnimacion(animacion);
			System.out.println(personaje.getAnimaciones());
			personajeRepository.save(personaje);
		}
	}

	@Test
	void borrarPersonaje() {
		personajeRepository.deleteById(8);
	}

	@Test
	void getAnimacionByid() {
		System.out.println(animacionRepository.findById(4).get());
	}

}
