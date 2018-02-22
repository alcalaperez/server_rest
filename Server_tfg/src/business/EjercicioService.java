package business;

import java.util.List;

import business.exception.BusinessException;
import business.model.Ejercicio;
import business.model.StringJax;

public interface EjercicioService {

	public Long createEjercicio(Ejercicio ejercicio) throws BusinessException;
	public void deleteEjercicioByName(String name) throws BusinessException;
	public void updateEjercicio(Ejercicio ejercicio) throws BusinessException;
	public List<Ejercicio> findAll() throws BusinessException;
	public List<Ejercicio> findByMusculo(String musculo) throws BusinessException;
	public List<StringJax> findMusculos() throws BusinessException;
	Ejercicio findByName(String name) throws BusinessException;
}
