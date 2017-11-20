package ar.com.magm.model;

import ar.com.magm.ti.model.Cancion;
import ar.com.magm.ti.model.Genero;
import ar.com.magm.ti.model.dao.hibernate.GeneroDAO;
import ar.com.magm.ti.model.service.IGeneroService;
import ar.com.magm.ti.model.service.impl.GeneroService;
import ar.com.magm.ti.service.exception.ServiceException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CTestGenero extends BaseTest {
    @Test
    public void save() throws ServiceException {
        IGeneroService service = new GeneroService(new GeneroDAO(sessionFactory()));

        Genero genero = new Genero();
        genero.setNombre("GeneroSave");

        List<Cancion> canciones = new ArrayList<Cancion>();
        Cancion cancion = new Cancion();
        cancion.setTitulo("CancionGenero");
        canciones.add(cancion);
        genero.setCanciones(canciones);

        genero = service.save(genero);
        assertTrue(genero.getIdGenero()>-1);
    }
}
