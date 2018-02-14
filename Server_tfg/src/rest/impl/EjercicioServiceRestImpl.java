package rest.impl;

import infrastructures.Factories;
import java.util.List;
import rest.EjercicioServiceRest;
import business.EjercicioService;
import business.exception.BusinessException;
import business.model.Ejercicio;

public class EjercicioServiceRestImpl implements EjercicioServiceRest {
	EjercicioService service = Factories.services.getEjercicioService();

	  
	@Override
	public List<Ejercicio> findAllEjercicios() throws BusinessException {
		return service.findAll();
	}


	@Override
	public void createEjercicio(Ejercicio ejercicio) throws BusinessException {
		service.createEjercicio(ejercicio);
		
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
}
