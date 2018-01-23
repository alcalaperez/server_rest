package persistence;


import business.model.Rutina;
import persistence.util.GenericDao;


public interface RutinaDao extends GenericDao<Rutina, Long> {
	int deleteByName(String name);
	Rutina findById(String name);

	
	

}

