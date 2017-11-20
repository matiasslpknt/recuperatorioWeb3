package ar.com.magm.ti.model.service.impl;

import ar.com.magm.ti.model.Genero;
import ar.com.magm.ti.model.service.IGeneroService;
import ar.com.magm.ti.persistence.dao.IGenericDAO;
import ar.com.magm.ti.service.impl.GenericService;

public class GeneroService extends GenericService<Genero, Integer> implements IGeneroService {
    public GeneroService(IGenericDAO dao) {
        super(dao);
    }
}
