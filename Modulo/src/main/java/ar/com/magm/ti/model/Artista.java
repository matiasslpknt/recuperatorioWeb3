package ar.com.magm.ti.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Proxy(lazy = false)
@Access(value = AccessType.FIELD)
public class Artista extends Entidad implements Serializable{
    private String genero;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
    private List<Concierto> conciertos;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
    private List<Album> albums;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<Concierto> getConciertos() {
        return conciertos;
    }

    public void setConciertos(List<Concierto> conciertos) {
        this.conciertos = conciertos;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return getIdEntidad() + " : " + getNombre() + " : " + genero.toString();
    }
}
