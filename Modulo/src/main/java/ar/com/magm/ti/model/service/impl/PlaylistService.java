package ar.com.magm.ti.model.service.impl;

import ar.com.magm.ti.model.Playlist;
import ar.com.magm.ti.model.service.IPlaylistService;
import ar.com.magm.ti.persistence.dao.IGenericDAO;
import ar.com.magm.ti.service.impl.GenericService;

public class PlaylistService extends GenericService<Playlist, Integer> implements IPlaylistService {
    public PlaylistService(IGenericDAO dao) {
        super(dao);
    }
}
