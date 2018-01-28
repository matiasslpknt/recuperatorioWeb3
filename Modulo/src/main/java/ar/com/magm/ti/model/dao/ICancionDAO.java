package ar.com.magm.ti.model.dao;

import ar.com.magm.ti.model.Cancion;
import ar.com.magm.ti.persistence.dao.IGenericDAO;
import ar.com.magm.ti.persistence.exception.PersistenceException;

import java.util.List;

public interface ICancionDAO extends IGenericDAO<Cancion, Integer> {

    public List<Cancion> topRating(int limite) throws PersistenceException;

    public List<Cancion> topReproducido(int limite) throws PersistenceException;

}

