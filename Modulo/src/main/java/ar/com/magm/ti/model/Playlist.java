package ar.com.magm.ti.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Proxy(lazy = false)
@Access(value = AccessType.FIELD)
public class Playlist implements Serializable {
    @Id
    @GeneratedValue
    private int idPlaylist;
    private String nombre;

    @ManyToOne(cascade =CascadeType.ALL)
    private Usuario usuario;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "playlist_canciones",
            joinColumns = @JoinColumn(name = "cancion"),
            inverseJoinColumns = @JoinColumn(name = "playlist"))
    private List<Cancion> canciones;

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
