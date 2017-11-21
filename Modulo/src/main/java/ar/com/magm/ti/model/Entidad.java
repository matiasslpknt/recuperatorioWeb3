package ar.com.magm.ti.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
@Access(value = AccessType.FIELD)
@Table(name = "artista")
public class Entidad implements Serializable {

	private static final long serialVersionUID = 2464927409480955012L;
	@Id
	@GeneratedValue
	private int idArtista;


	private String nombre;

	@Override
	public int hashCode() {
		return getIdArtista();

	}

	@Override
	public String toString() {
		return String.format("Entidad: %s - %s", getIdArtista(), getNombre());
	}

	public int getIdArtista() {
		return idArtista;
	}

	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public boolean equals(Object obj) {
		return getIdArtista()==((Entidad)obj).getIdArtista();
	}
}
