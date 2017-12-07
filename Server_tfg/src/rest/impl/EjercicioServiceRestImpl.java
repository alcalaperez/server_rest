package rest.impl;

import infrastructures.Factories;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import rest.EjercicioServiceRest;
import business.EjercicioService;
import business.exception.BusinessException;
import business.model.Ejercicio;

public class EjercicioServiceRestImpl implements EjercicioServiceRest {
	EjercicioService service = Factories.services.getEjercicioService();

	  
	@Override
	public List<Ejercicio> findAllEjercicios(HttpServletRequest request) throws BusinessException {
		return service.findAll();
	}


	@Override
	public void createEjercicio(Ejercicio ejercicio, HttpServletRequest request) throws BusinessException {
		service.createEjercicio(ejercicio);
		
	}


	@Override
	public void updateEjercicio(Ejercicio ejercicio, HttpServletRequest request) throws BusinessException {
		service.updateEjercicio(ejercicio);

	}


	@Override
	public void updateEjercicio(String nombre, HttpServletRequest request) throws BusinessException {
		service.deleteEjercicioByName(nombre);
		
	}
}
