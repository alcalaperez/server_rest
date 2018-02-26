package rest.impl;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import business.RutinaService;
import business.exception.BusinessException;
import business.model.Rutina;
import infrastructures.Factories;
import rest.RutinaServiceRest;

public class RutinaServiceRestImpl implements RutinaServiceRest {
	RutinaService service = Factories.services.getRutinaService();

	  
	@Override
	public List<Rutina> findAllRutinas() throws BusinessException {
		return service.findAll();
	}


	@Override
	public Response createRutina(Rutina rutina) throws BusinessException {
		Response response;
		Long result = service.createRutina(rutina);
		if(result == 1) {
			response = Response.status(Status.CREATED).build();
		} else {
			response = Response.status(Status.CONFLICT).build();
		}
		return response;
		
	}


	@Override
	public void updateRutina(Rutina rutina) throws BusinessException {
		service.updateRutina(rutina);

	}


	@Override
	public void deleteRutina(String name) throws BusinessException {
		service.deleteRutinaByName(name);
		
	}


	@Override
	public List<Rutina> findRutinaBySomatotipoObjetivo(String somatotipo, String objetivo)
			throws BusinessException {
		return service.findBySomaObjet(somatotipo, objetivo);
	}


	@Override
	public List<Rutina> findRutinaBySomatotipo(String somatotipo) throws BusinessException {
		return service.findBySoma(somatotipo);

	}


	@Override
	public List<Rutina> findAllRutinasLight() throws BusinessException {
		return service.findAllOnlyNames();

	}


	@Override
	public Rutina findAssignedBySomatotipoObjetivo(String somatotipo, String objetivo) throws BusinessException {
		return service.findAssignedRutina(somatotipo, objetivo);
	}


	@Override
	public String findAssignedBySomatotipoObjetivoLight(String somatotipo, String objetivo) throws BusinessException {
		return service.findAssignedRutinaLight(somatotipo, objetivo);

	}
}
