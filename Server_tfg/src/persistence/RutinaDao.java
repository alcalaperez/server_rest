package persistence;


import java.util.List;

import business.model.Rutina;
import business.model.SomatotiposAsignados;
import persistence.util.GenericDao;


public interface RutinaDao extends GenericDao<Rutina, Long> {
	int deleteByName(String name);
	Rutina findById(String name);
	List<Rutina> findBySomaObjet(String somatotipo, String objetivo);
	List<Rutina> findBySoma(String somatotipo);
	void updateSomatotipoAsignado(String somatotipo, String objetivo, String rutina);
	SomatotiposAsignados findAsignRutina(String somatotipo, String objetivo);

	
	

}

