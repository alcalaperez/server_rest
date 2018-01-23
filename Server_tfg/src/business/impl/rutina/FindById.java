package business.impl.rutina;

import java.util.List;

import business.exception.BusinessException;
import business.impl.command.Command;
import business.model.DiaEntreno;
import business.model.Rutina;
import business.model.Serie;
import infrastructures.Factories;

public class FindById implements Command<Rutina> {

	private String name;

	public FindById(String name) {
		this.name = name;
	}

	@Override
	public Rutina execute() throws BusinessException {
		Rutina rutina = Factories.persistence.getRutinaoDao().findById(name);

		List<DiaEntreno> dias = Factories.persistence.getDiaRutinaoDao().findByRutinaId(name);

		for (DiaEntreno d : dias) {
			List<Serie> series = Factories.persistence.getSerieDao().findByDiaId(d.getId());

			for (Serie s : series) {
				d.addSerie(s);
			}

			rutina.addDiaEntrenamiento(d);
		}

		return rutina;
	}

}
