package ar.com.magm.ti.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Proxy(lazy = false)
@Access(value = AccessType.FIELD)
public class Cancion implements Serializable{

    @Id
    @GeneratedValue
    private int idCancion;

    private String titulo;
    private String duracion;
    private float rating;
    private long reproducciones;

    @ManyToOne(cascade = CascadeType.ALL)
    private Album album;

    @ManyToOne(cascade = CascadeType.ALL)
    private Genero genero;

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public long getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(long reproducciones) {
        this.reproducciones = reproducciones;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return idCancion + " : " + titulo + (album != null ? " : " + album.getIdAlbum() : "");
    }
}
