package persistence;


import java.util.List;

import business.model.Rutina;
import persistence.util.GenericDao;


public interface RutinaDao extends GenericDao<Rutina, Long> {
	int deleteByName(String name);
	Rutina findById(String name);
	List<Rutina> findBySomaObjet(String somatotipo, String objetivo);

	
	

}

