package ar.com.magm.ti.model.dao.hibernate;

import ar.com.magm.ti.model.Genero;
import ar.com.magm.ti.model.dao.IGeneroDAO;
import ar.com.magm.ti.persistence.dao.hibernate.GenericDAO;
import org.hibernate.SessionFactory;

public class GeneroDAO extends GenericDAO<Genero, Integer> implements IGeneroDAO {
    public GeneroDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
