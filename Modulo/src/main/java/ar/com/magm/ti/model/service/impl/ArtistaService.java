package ar.com.magm.ti.model.service.impl;

import ar.com.magm.ti.model.Artista;
import ar.com.magm.ti.model.dao.IArtistaDAO;
import ar.com.magm.ti.model.dao.IEntidadDAO;
import ar.com.magm.ti.model.service.IArtistaService;
import ar.com.magm.ti.service.impl.GenericService;

public class ArtistaService extends GenericService<Artista, Integer> implements IArtistaService {
    public ArtistaService(IArtistaDAO dao) {
        super(dao);
    }
}
