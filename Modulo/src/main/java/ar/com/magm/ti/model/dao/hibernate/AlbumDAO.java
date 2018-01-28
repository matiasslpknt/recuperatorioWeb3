package ar.com.magm.ti.model.dao.hibernate;

import ar.com.magm.ti.model.Album;
import ar.com.magm.ti.model.dao.IAlbumDAO;
import ar.com.magm.ti.persistence.dao.hibernate.GenericDAO;
import org.hibernate.SessionFactory;

public class AlbumDAO extends GenericDAO<Album, Integer> implements IAlbumDAO {
    public AlbumDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
