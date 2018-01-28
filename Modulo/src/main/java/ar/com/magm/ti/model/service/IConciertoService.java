package ar.com.magm.ti.model.service;

import ar.com.magm.ti.model.Concierto;
import ar.com.magm.ti.service.IGenericService;
import ar.com.magm.ti.service.exception.ServiceException;

import java.util.List;

public interface IConciertoService extends IGenericService<Concierto, Integer> {

    public List<Concierto> listLugar(String parteDelNombre) throws ServiceException;

    public List<Concierto> listPais(String parteDelNombre) throws ServiceException;
}
