package business.impl.rutina;

import business.exception.BusinessException;
import business.impl.command.Command;
import business.model.DiaEntreno;
import business.model.Rutina;
import business.model.Serie;
import infrastructures.Factories;

public class CreateRutinaCommand implements Command<Long> {

	private Rutina rutina;

	public CreateRutinaCommand(Rutina rutina) {
		this.rutina = rutina;
	}

	@Override
	public Long execute() throws BusinessException {	
		Rutina rutinaExistente = Factories.persistence.getRutinaoDao().findById(rutina.getNombre());

		if (rutinaExistente == null) {
			Factories.persistence.getRutinaoDao().save(rutina);

			for (DiaEntreno de : rutina.getDiasEntrenamiento()) {
				int diaid = Factories.persistence.getDiaRutinaoDao().save(de, rutina.getNombre());

				for (Serie s : de.getSeries()) {
					Factories.persistence.getSerieDao().save(s, diaid);
				}
			}
			return (long) 1;

		} else {
			return (long) 0;

		}

	}

}
