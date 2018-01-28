package ar.com.magm.ti.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Proxy(lazy = false)
@Access(value = AccessType.FIELD)
public class Genero implements Serializable{

    @Id
    @GeneratedValue
    private int idGenero;
    private String nombre;

    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL)
    private List<Cancion> canciones;

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
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
}
