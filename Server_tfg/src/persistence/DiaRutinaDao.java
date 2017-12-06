package persistence;

import business.model.DiaEntreno;

public interface DiaRutinaDao {
	int save(DiaEntreno diaEntreno, String nombreRutina);
	

}

