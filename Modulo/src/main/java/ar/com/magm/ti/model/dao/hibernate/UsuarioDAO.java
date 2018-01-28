package ar.com.magm.ti.model.dao.hibernate;

import ar.com.magm.ti.model.Usuario;
import ar.com.magm.ti.model.dao.IUsuarioDAO;
import ar.com.magm.ti.persistence.dao.hibernate.GenericDAO;
import org.hibernate.SessionFactory;

public class UsuarioDAO extends GenericDAO<Usuario, Integer> implements IUsuarioDAO {
    public UsuarioDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
