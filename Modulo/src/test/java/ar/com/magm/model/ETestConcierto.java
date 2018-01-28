package ar.com.magm.model;

import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Album;
import ar.com.magm.ti.model.Artista;
import ar.com.magm.ti.model.Concierto;
import ar.com.magm.ti.model.dao.hibernate.ConciertoDAO;
import ar.com.magm.ti.model.service.IConciertoService;
import ar.com.magm.ti.model.service.impl.ConciertoService;
import ar.com.magm.ti.service.exception.ServiceException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ETestConcierto extends BaseTest {

    @Test
    public void save() throws ServiceException {
        IConciertoService service = new ConciertoService(new ConciertoDAO(sessionFactory()));

        Concierto concierto = new Concierto();

        //Artista
        Artista artista = new Artista();
        artista.setNombre("artistaConcierto");
        artista.setGenero("Rock");

        List<Concierto> conciertos = new ArrayList<Concierto>();
        conciertos.add(concierto);
        artista.setConciertos(conciertos);

        List<Album> albumes = new ArrayList<Album>();
        Album album = new Album();
        album.setArtista(artista);
        album.setNombre("AlbumConcierto");
        albumes.add(album);
        artista.setAlbums(albumes);

        // Concierto
        concierto.setArtista(artista);
        concierto.setLugar("Cordoba");
        concierto.setPais("argentina");

        concierto =  service.save(concierto);

        assertTrue(concierto.getIdConcierto() > -1);
    }

    @Test
    public void load() throws NotFoundException, ServiceException {
        IConciertoService service = new ConciertoService(new ConciertoDAO(sessionFactory()));

        Concierto concierto = service.load(1);

        assertEquals(1, concierto.getIdConcierto());
    }

    @Test
    public void loadNupdate() throws NotFoundException, ServiceException {
        IConciertoService service = new ConciertoService(new ConciertoDAO(sessionFactory()));

        Concierto concierto = service.load(1);

        concierto = service.saveOrUpdate(concierto);

        assertNotNull(concierto);
    }

    @Test
    public void listLoad() throws ServiceException {
        IConciertoService service = new ConciertoService(new ConciertoDAO(sessionFactory()));

        List<Concierto> conciertos = service.list();

        assertNotNull(conciertos);

        for (Concierto concierto: conciertos) {
            System.out.println(concierto.getIdConcierto() + " : " + concierto.getArtista());
        }
        assertTrue(conciertos.size() > 0);
    }
}
