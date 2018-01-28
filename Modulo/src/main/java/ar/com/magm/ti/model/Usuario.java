package ar.com.magm.ti.model;

import ar.com.magm.ti.model.Artista;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Proxy(lazy = false)
@Access(value = AccessType.FIELD)
public class Usuario implements Serializable {
    @Id
    @GeneratedValue
    private int idUser;
    private String usuario;
    private String contraseña;
    private String mail;
    private String pais;
    private boolean premium;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Playlist> playlists;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "userio_artista",
    joinColumns = @JoinColumn(name = "artista"),
    inverseJoinColumns = @JoinColumn(name = "usuario"))
    List<Artista> artistaSeguidos;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public List<Artista> getArtistaSeguidos() {
        return artistaSeguidos;
    }

    public void setArtistaSeguidos(List<Artista> artistaSeguidos) {
        this.artistaSeguidos = artistaSeguidos;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}
