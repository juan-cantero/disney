package io.juanqui.disney.repository.specs;

import io.juanqui.disney.model.Personaje;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;


// los specification estan basados en el specification pattern y sirven para hacer consultas mas complejas
// a la base de datos con mas filtros
public class PersonajeSpecifications {



    public static Specification<Personaje> likeFirstName(String name) {
        if (name == null) {
            return null;
        }
        return new Specification<Personaje>() {
            @Override
            public Predicate toPredicate(Root<Personaje> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("nombre"),"%"+name+"%");

            }
        };

    }

    public static Specification<Personaje> equalAge(Integer age) {
        if (age == null) {
            return null;
        }
        return new Specification<Personaje>() {
            @Override
            public Predicate toPredicate(Root<Personaje> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("edad"),age);

            };
        };

    }

    public static Specification<Personaje> equalWeight(Float weight) {
        if (weight == null) {
            return null;
        }
        return new Specification<Personaje>() {
            @Override
            public Predicate toPredicate(Root<Personaje> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("peso"),weight);

            };
        };

    }




}
