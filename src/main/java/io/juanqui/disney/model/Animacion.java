package io.juanqui.disney.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "animaciones")
public class Animacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    @Column(name="fecha_creacion")
    private LocalDate fechaCreacion;
    private int calificacion;
    @ManyToMany(mappedBy = "animaciones",fetch = FetchType.EAGER)
    @JsonIgnoreProperties("animaciones")
    private Set<Personaje> personajes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genero_id")
    //  sirve para que no haya recursion
    @JsonIgnoreProperties("animaciones")
    private GeneroAnimacion genero;

    public Animacion() {
    }

    public Animacion(int id, String titulo, LocalDate fechaCreacion, int calificacion, Set<Personaje> personajes, GeneroAnimacion genero) {
        this.id = id;
        this.titulo = titulo;
        this.fechaCreacion = fechaCreacion;
        this.calificacion = calificacion;
        this.personajes = personajes;
        this.genero = genero;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Set<Personaje> getPersonajes() {
        return personajes;
    }

    public void setPersonajes(Set<Personaje> personajes) {
        this.personajes = personajes;
    }


    public GeneroAnimacion getGenero() {
        return genero;
    }

    public void setGenero(GeneroAnimacion genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Animacion{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", calificacion=" + calificacion +
                '}';
    }
}
