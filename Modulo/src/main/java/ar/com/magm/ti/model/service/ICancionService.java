package ar.com.magm.ti.model.service;

import ar.com.magm.ti.model.Cancion;
import ar.com.magm.ti.service.IGenericService;
import ar.com.magm.ti.service.exception.ServiceException;

import java.util.List;

public interface ICancionService extends IGenericService<Cancion, Integer> {


    List<Cancion> topRating(int limite) throws ServiceException;

    List<Cancion> topReproducido(int limite) throws ServiceException;
}
