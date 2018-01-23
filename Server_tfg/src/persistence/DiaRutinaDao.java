package persistence;

import java.util.List;

import business.model.DiaEntreno;

public interface DiaRutinaDao {
	int save(DiaEntreno diaEntreno, String nombreRutina);
	List<DiaEntreno> findByRutinaId(String nombreRutina);
	void delete(String name);


}

