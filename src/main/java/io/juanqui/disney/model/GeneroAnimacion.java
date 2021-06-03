package io.juanqui.disney.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="generos")
public class GeneroAnimacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    @Column(name="imagen_url")
    private String imagenUrl;
    @OneToMany(mappedBy = "genero",fetch = FetchType.EAGER)
    private Set<Animacion> animaciones = new HashSet<>();

    public GeneroAnimacion() {
    }

    public GeneroAnimacion(int id, String nombre, String imagenUrl, Set<Animacion> animaciones) {
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "GeneroAnimacion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", imagenUrl='" + imagenUrl + '\'' +

                '}';
    }
}
