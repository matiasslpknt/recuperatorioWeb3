package ar.com.magm.model;

import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Cancion;
import ar.com.magm.ti.model.Playlist;
import ar.com.magm.ti.model.Usuario;
import ar.com.magm.ti.model.dao.hibernate.CancionDAO;
import ar.com.magm.ti.model.dao.hibernate.ConciertoDAO;
import ar.com.magm.ti.model.dao.hibernate.PlaylistDAO;
import ar.com.magm.ti.model.dao.hibernate.UsuarioDAO;
import ar.com.magm.ti.model.service.ICancionService;
import ar.com.magm.ti.model.service.IPlaylistService;
import ar.com.magm.ti.model.service.IUsuarioService;
import ar.com.magm.ti.model.service.impl.CancionService;
import ar.com.magm.ti.model.service.impl.PlaylistService;
import ar.com.magm.ti.model.service.impl.UsuarioService;
import ar.com.magm.ti.service.exception.ServiceException;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BTestPlaylist extends BaseTest {

    @Test
    public void save() throws ServiceException, NotFoundException {
        IPlaylistService service = new PlaylistService(new PlaylistDAO(sessionFactory()));
        ICancionService servCancion = new CancionService(new CancionDAO(sessionFactory()));
        IUsuarioService serviceUsuario = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()), new ConciertoDAO((SessionFactory) sessionFactory()));
        Playlist playlist = new Playlist();
        playlist.setNombre("playlist 1");

        Usuario usuario = serviceUsuario.load(1);
        playlist.setUsuario(usuario);

        List<Cancion> canciones =  servCancion.list();
        playlist.setCanciones(canciones);

        playlist = service.save(playlist);

        Assert.assertTrue(playlist.getIdPlaylist() > -1);
    }

    @Test
    public void load() throws NotFoundException, ServiceException {
        IPlaylistService service = new PlaylistService(new PlaylistDAO(sessionFactory()));

        Playlist playlist = service.load(1);

        // Esto funciona gracias al fetch =  EAGER
        for (Cancion cancion: playlist.getCanciones()) {
            System.out.println(cancion);
        }

        Assert.assertNotNull(playlist);
    }

    @Test
    public void loadList() throws ServiceException {
        IPlaylistService service = new PlaylistService(new PlaylistDAO(sessionFactory()));

        List<Playlist> playlists = service.list();

        Assert.assertNotNull(playlists);

        for (Playlist playlist:playlists) {
            System.out.println(playlist.getIdPlaylist() + " : " + playlist.getNombre());
        }
        Assert.assertTrue(playlists.size() > 0);

    }

    /* El delete no funciona por ser una relacion muchos a muchos
     * no se como hacer para borrarla pero tiene que ver con quien
     * es el dueño de la relacion y quien no.
     * Si no van a necesitar borrar las playlist ni se molesten
     * de lo contrario van a tener que investigar porque posta no encuentro
     * como hacerlo prros.
     */
    //@Test
    public void delete() throws NotFoundException, ServiceException {
        IPlaylistService service = new PlaylistService(new PlaylistDAO(sessionFactory()));

        List<Playlist> playlists = service.list();

        service.delete(playlists.get(playlists.size() - 1));
    }
}
