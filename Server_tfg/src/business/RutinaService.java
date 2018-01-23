package business;

import java.util.List;

import business.exception.BusinessException;
import business.model.Rutina;

public interface RutinaService {

	public Long createRutina(Rutina rutina) throws BusinessException;
	public void deleteRutinaByName(String name) throws BusinessException;
	public void updateRutina(Rutina rutina) throws BusinessException;
	public List<Rutina> findAll() throws BusinessException;
	public Rutina findById(String nombre) throws BusinessException;

}
