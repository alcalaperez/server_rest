package persistence;

import java.util.List;

import business.model.Serie;

public interface SerieDao {
	int save(Serie serie, int iddia);
	List<Serie> findByDiaId(int id);
	void delete(int diaid);


}

