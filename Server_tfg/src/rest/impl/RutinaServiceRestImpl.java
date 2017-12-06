package rest.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import business.RutinaService;
import business.exception.BusinessException;
import business.model.Rutina;
import infrastructures.Factories;
import rest.RutinaServiceRest;

public class RutinaServiceRestImpl implements RutinaServiceRest {
	RutinaService service = Factories.services.getRutinaService();

	  
	@Override
	public List<Rutina> findAllRutinas(HttpServletRequest request) throws BusinessException {
		return service.findAll();
	}


	@Override
	public void createRutina(Rutina rutina, HttpServletRequest request) throws BusinessException {
		service.createRutina(rutina);
		
	}


	@Override
	public void updateRutina(Rutina rutina, HttpServletRequest request) throws BusinessException {
		service.updateRutina(rutina);

	}
}
