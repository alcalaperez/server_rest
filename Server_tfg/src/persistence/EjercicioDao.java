package persistence;


import business.model.Ejercicio;
import persistence.util.GenericDao;


public interface EjercicioDao extends GenericDao<Ejercicio, Long> {
	int deleteByName(String name);

	
	

}

