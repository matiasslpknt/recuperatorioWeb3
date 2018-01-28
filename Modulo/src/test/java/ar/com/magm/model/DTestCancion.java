package ar.com.magm.model;

import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.*;
import ar.com.magm.ti.model.dao.hibernate.CancionDAO;
import ar.com.magm.ti.model.service.ICancionService;
import ar.com.magm.ti.model.service.impl.CancionService;
import ar.com.magm.ti.service.exception.ServiceException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DTestCancion extends BaseTest {

    @Test
    public void save() throws ServiceException {
        ICancionService service = new CancionService(new CancionDAO(sessionFactory()));

        Cancion cancion = new Cancion();

        Artista artista = new Artista();
        artista.setNombre("artistaCancion");

        artista.setGenero("Rock");


        List<Concierto> conciertos = new ArrayList<Concierto>();
        Concierto concierto = new Concierto();
        concierto.setArtista(artista);
        conciertos.add(concierto);
        artista.setConciertos(conciertos);

        List<Album> albumes = new ArrayList<Album>();
        Album album = new Album();
        album.setArtista(artista);
        album.setNombre("Album1");
        albumes.add(album);
        artista.setAlbums(albumes);

        cancion.setAlbum(album);
        cancion.setTitulo("Cancion1");

        Genero genero = new Genero();
        genero.setNombre("GeneroCancion");
        cancion.setGenero(genero);

        cancion = service.save(cancion);
        assertTrue(cancion.getIdCancion() > -1);
    }

    @Test
    public void load() throws NotFoundException, ServiceException {
        ICancionService service = new CancionService(new CancionDAO(sessionFactory()));

        Cancion cancion = service.load(1);

        assertEquals(1, cancion.getIdCancion());
    }

    @Test
    public void loadNupdate() throws NotFoundException, ServiceException {
        ICancionService service = new CancionService(new CancionDAO(sessionFactory()));

        Cancion cancion = service.load(1);

        cancion = service.saveOrUpdate(cancion);

        assertNotNull("Cancion update Failed", cancion);
    }

    @Test
    public void listLoad() throws ServiceException {
        ICancionService service = new CancionService(new CancionDAO(sessionFactory()));

        List<Cancion> canciones = service.list();

        assertNotNull("lista nula", canciones);

        for (Cancion cancion: canciones) {
            System.out.println(cancion);
        }
        assertTrue("lista vacia", canciones.size() > 0);

    }
}
