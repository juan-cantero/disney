package io.juanqui.disney.repository;

import io.juanqui.disney.model.Personaje;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface PersonajeRepository
        extends PagingAndSortingRepository<Personaje,Integer>, JpaSpecificationExecutor<Personaje> {


    Optional<Personaje> findPersonajeByNombre(String nombre);


}
