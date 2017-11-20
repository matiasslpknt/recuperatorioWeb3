package ar.com.magm.ti.model.dao.hibernate;

import ar.com.magm.ti.model.Playlist;
import ar.com.magm.ti.model.dao.IPlaylistDAO;
import ar.com.magm.ti.persistence.dao.hibernate.GenericDAO;
import org.hibernate.SessionFactory;

public class PlaylistDAO extends GenericDAO<Playlist, Integer> implements IPlaylistDAO {
    public PlaylistDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
