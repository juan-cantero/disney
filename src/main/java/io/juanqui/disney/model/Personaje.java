package io.juanqui.disney.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "personajes")
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="nombre",unique = true)
    private String nombre;
    private int edad;
    private Float peso;
    private String historia;
    @Column(name = "imagen_url")
    private String imagenUrl;

    //join columns es la columna con al llave foranea que uno a tabla personajes con animaciones
    // y inverseJoinColumns es la tabla que hace lo opuesto
    @JoinTable(
            name = "personajes_animaciones",
            joinColumns = @JoinColumn(name = "fk_personaje", nullable = false),
            inverseJoinColumns = @JoinColumn(name="fk_animacion", nullable = false)
    )
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("personajes")
    private Set<Animacion> animaciones = new HashSet<>();




    public Personaje() {
    }


    public Personaje(int id, String nombre,int edad, Float peso, String historia, String imagenUrl, Set<Animacion> animaciones) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.imagenUrl = imagenUrl;
        this.animaciones = animaciones;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public Set<Animacion> getAnimaciones() {
        return animaciones;
    }

    public void setAnimaciones(Set<Animacion> animaciones) {
        this.animaciones = animaciones;
    }

    public void addAnimacion(Animacion animacion) {
        this.animaciones.add(animacion);
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", historia='" + historia + '\'' +
                ", imagenUrl='" + imagenUrl + '\'' +
                '}';
    }
}
