package ar.com.magm.model;

import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Artista;
import ar.com.magm.ti.model.Concierto;
import ar.com.magm.ti.model.Playlist;
import ar.com.magm.ti.model.Usuario;
import ar.com.magm.ti.model.dao.hibernate.ArtistaDAO;
import ar.com.magm.ti.model.dao.hibernate.ConciertoDAO;
import ar.com.magm.ti.model.dao.hibernate.PlaylistDAO;
import ar.com.magm.ti.model.dao.hibernate.UsuarioDAO;
import ar.com.magm.ti.model.service.IArtistaService;
import ar.com.magm.ti.model.service.IPlaylistService;
import ar.com.magm.ti.model.service.IUsuarioService;
import ar.com.magm.ti.model.service.impl.ArtistaService;
import ar.com.magm.ti.model.service.impl.PlaylistService;
import ar.com.magm.ti.model.service.impl.UsuarioService;
import ar.com.magm.ti.service.exception.ServiceException;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class ATestUsuario extends BaseTest {

    @Test
    public void save() throws ServiceException {
        IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()), new ConciertoDAO((SessionFactory) sessionFactory()));
        IArtistaService serviceArtista = new ArtistaService(new ArtistaDAO(sessionFactory()));
        IPlaylistService servicePlaylist = new PlaylistService(new PlaylistDAO(sessionFactory()));

        Usuario usuario = new Usuario();

        usuario.setUsuario("usuario1");
        usuario.setContraseña("123");
        usuario.setMail("mail.com");
        usuario.setPais("argentina");
        usuario.setPremium(true);


        List<Artista> artistas = serviceArtista.list();
        usuario.setArtistaSeguidos(artistas);

        List<Playlist> playlists = servicePlaylist.list();
        usuario.setPlaylists(playlists);


        usuario = service.save(usuario);

        Assert.assertTrue(usuario.getIdUser() > 0);
    }

    @Test
    public void load() throws NotFoundException, ServiceException {
        IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()), new ConciertoDAO((SessionFactory) sessionFactory()));

        Usuario usuario = service.load(1);

        Assert.assertNotNull(usuario);
    }

    @Test
    public void loadList() throws ServiceException {
        IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()), new ConciertoDAO((SessionFactory) sessionFactory()));

        List<Usuario> usuarios = service.list();

        Assert.assertNotNull(usuarios);
        Assert.assertTrue(usuarios.size() > -1);
    }

    @Test
    public void getConciertosEnMiPais() throws ServiceException {
        ArrayList<Concierto> c = null;
        try {
            IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()), new ConciertoDAO((SessionFactory) sessionFactory()));

            Usuario usuario = service.load(2);
            c = service.getConciertosEnMiPais(usuario);
            if(c.size()==0){
                c = null;
            }


        } catch (NotFoundException ex) {
            Logger.getLogger(ATestUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull("No se generó la lista", c);
    }
}
