package ar.com.magm.ti.model.service;

import ar.com.magm.ti.model.Concierto;
import ar.com.magm.ti.model.Usuario;
import ar.com.magm.ti.service.IGenericService;
import ar.com.magm.ti.service.exception.ServiceException;

import java.util.ArrayList;

public interface IUsuarioService extends IGenericService<Usuario, Integer> {
    public ArrayList<Concierto> getConciertosEnMiPais(Usuario usuario) throws ServiceException;
}
