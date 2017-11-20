package ar.com.magm.ti.model.service.impl;

import ar.com.magm.ti.model.Concierto;
import ar.com.magm.ti.model.Usuario;
import ar.com.magm.ti.model.dao.IConciertoDAO;
import ar.com.magm.ti.model.dao.IUsuarioDAO;
import ar.com.magm.ti.model.service.IUsuarioService;
import ar.com.magm.ti.persistence.exception.PersistenceException;
import ar.com.magm.ti.service.exception.ServiceException;
import ar.com.magm.ti.service.impl.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.logging.Level;

public class UsuarioService extends GenericService<Usuario, Integer> implements IUsuarioService{
    private static Logger LOG = LoggerFactory.getLogger(UsuarioService.class);
    private IUsuarioDAO dao;
    private IConciertoDAO daoConcierto;

    public UsuarioService(IUsuarioDAO dao, IConciertoDAO daoConcierto) {
        super(dao);
        this.dao = dao;
        this.daoConcierto = daoConcierto;
    }

    @Override
    public ArrayList<Concierto> getConciertosEnMiPais(Usuario usuario) throws ServiceException {
        ArrayList<Concierto> cons = new ArrayList<Concierto>();
        ArrayList<Concierto> aux = new ArrayList<Concierto>();
        try {
            aux = (ArrayList<Concierto>)daoConcierto.listPais(usuario.getPais());
            for (Concierto c : aux) {
                if (c.getPais().equals(usuario.getPais())) {
                    cons.add(c);
                }
            }
        } catch (PersistenceException ex) {
            java.util.logging.Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cons;
    }
}
