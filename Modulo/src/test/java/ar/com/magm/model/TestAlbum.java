package ar.com.magm.model;

import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Album;
import ar.com.magm.ti.model.Artista;
import ar.com.magm.ti.model.Concierto;
import ar.com.magm.ti.model.dao.hibernate.AlbumDAO;
import ar.com.magm.ti.model.service.IAlbumService;
import ar.com.magm.ti.model.service.impl.AlbumService;
import ar.com.magm.ti.service.exception.ServiceException;
import org.hibernate.annotations.common.util.impl.Log;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestAlbum extends BaseTest {
    @Test
    public void save() throws ServiceException {
        IAlbumService service = new AlbumService(new AlbumDAO(sessionFactory()));

        Album album = new Album();
        album.setNombre("Album");

        Artista artista = new Artista();
        album.setArtista(artista);
        artista.setNombre("artistaAlbum");

        artista.setGenero("Rock");


        List<Concierto> conciertos = new ArrayList<Concierto>();
        Concierto concierto = new Concierto();
        concierto.setArtista(artista);
        conciertos.add(concierto);
        artista.setConciertos(conciertos);

        List<Album> albumes = new ArrayList<Album>();
        albumes.add(album);
        artista.setAlbums(albumes);

        album = service.save(album);

        assertTrue(album.getIdAlbum()>-1);
    }

    @Test
    public void load() throws NotFoundException, ServiceException {
        IAlbumService service = new AlbumService(new AlbumDAO(sessionFactory()));

        Album album;

        album = service.load(1);

        assertNotNull("album is null", album);
    }

    @Test
    public void loadNupdate() throws ServiceException, NotFoundException {
        IAlbumService service = new AlbumService(new AlbumDAO(sessionFactory()));

        Album album;

        album = service.load(1);

        album = service.saveOrUpdate(album);

        assertEquals(1, album.getIdAlbum());
    }

    @Test
    public void listLoad() throws ServiceException {
        IAlbumService service = new AlbumService(new AlbumDAO(sessionFactory()));

        List<Album> albumes = service.list();

        for (Album album: albumes) {
            System.out.println(album);
        }

        assertNotNull(albumes);
        assertTrue(albumes.size() > 0);
    }

    //@Test
    public void delete() throws ServiceException, NotFoundException {
        IAlbumService service = new AlbumService(new AlbumDAO(sessionFactory()));
        List<Album> albumes = service.list();
        service.delete(albumes.get(albumes.size() - 1));
    }
}
