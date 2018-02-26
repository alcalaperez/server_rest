package rest.impl;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import business.EjercicioService;
import business.exception.BusinessException;
import business.model.Ejercicio;
import business.model.StringJax;
import infrastructures.Factories;
import rest.EjercicioServiceRest;

public class EjercicioServiceRestImpl implements EjercicioServiceRest {
	EjercicioService service = Factories.services.getEjercicioService();

	  
	@Override
	public List<Ejercicio> findAllEjercicios() throws BusinessException {
		return service.findAll();
	}


	@Override
	public Response createEjercicio(Ejercicio ejercicio) throws BusinessException {
		Response response;
		Long result = service.createEjercicio(ejercicio);
		if(result == 1) {
			response = Response.status(Status.CREATED).build();
		} else {
			response = Response.status(Status.CONFLICT).build();
		}
		return response;
		
	}


	@Override
	public void updateEjercicio(Ejercicio ejercicio) throws BusinessException {
		service.updateEjercicio(ejercicio);

	}


	@Override
	public void deleteEjercicio(String nombre) throws BusinessException {
		service.deleteEjercicioByName(nombre);
		
	}


	@Override
	public List<Ejercicio> findByMusculo(String musculo) throws BusinessException {
		return service.findByMusculo(musculo);
	}


	@Override
	public List<StringJax> findMusculos() throws BusinessException {
		return service.findMusculos();

	}


	@Override
	public Ejercicio findByName(String nombre) throws BusinessException {
		return service.findByName(nombre);

	}
}
