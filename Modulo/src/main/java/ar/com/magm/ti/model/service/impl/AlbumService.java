package ar.com.magm.ti.model.service.impl;

import ar.com.magm.ti.model.Album;
import ar.com.magm.ti.model.service.IAlbumService;
import ar.com.magm.ti.persistence.dao.IGenericDAO;
import ar.com.magm.ti.service.impl.GenericService;


public class AlbumService extends GenericService<Album, Integer> implements IAlbumService {
    public AlbumService(IGenericDAO dao) {
        super(dao);
    }
}
