package ar.com.magm.model;
import static org.junit.Assert.*;

import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Album;
import ar.com.magm.ti.model.Artista;
import ar.com.magm.ti.model.Concierto;
import ar.com.magm.ti.model.dao.hibernate.ArtistaDAO;
import ar.com.magm.ti.model.service.IArtistaService;
import ar.com.magm.ti.model.service.impl.ArtistaService;
import ar.com.magm.ti.service.exception.ServiceException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestArtista extends BaseTest {

    @Test
    public void save() throws ServiceException {
        IArtistaService service = new ArtistaService(new ArtistaDAO(sessionFactory()));

        Artista artista = new Artista();
        artista.setNombre("artista");

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

        artista = (Artista) service.save(artista);

        assertTrue(artista.getIdArtista()>-1);
    }

    @Test
    public void load() throws NotFoundException, ServiceException {
        IArtistaService service = new ArtistaService(new ArtistaDAO(sessionFactory()));

        Artista artista = service.load(8);

        assertEquals(8, artista.getIdArtista());
    }

    @Test
    public void loadNupdate() throws NotFoundException, ServiceException {
        IArtistaService service = new ArtistaService(new ArtistaDAO(sessionFactory()));

        Artista artista = service.load(8);

        artista = service.saveOrUpdate(artista);

        assertNotNull("artista update nulo",artista);
    }

    @Test
    public void listLoad() throws ServiceException {
        IArtistaService service = new ArtistaService(new ArtistaDAO(sessionFactory()));

        List<Artista> artistas = service.list();

        for (Artista artista: artistas) {
            System.out.println(artista);
        }

        assertNotNull(artistas);
        assertTrue(artistas.size() > 0);
    }
}
