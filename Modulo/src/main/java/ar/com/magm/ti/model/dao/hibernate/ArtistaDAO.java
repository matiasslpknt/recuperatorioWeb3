package ar.com.magm.ti.model.dao.hibernate;

import ar.com.magm.ti.model.Artista;
import ar.com.magm.ti.model.dao.IArtistaDAO;
import ar.com.magm.ti.persistence.dao.hibernate.GenericDAO;
import org.hibernate.SessionFactory;

public class ArtistaDAO extends GenericDAO<Artista, Integer> implements IArtistaDAO {
    public ArtistaDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
