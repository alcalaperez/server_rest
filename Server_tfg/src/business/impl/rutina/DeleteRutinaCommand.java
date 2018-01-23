package business.impl.rutina;

import business.exception.BusinessException;
import business.impl.command.Command;
import business.model.DiaEntreno;
import business.model.Rutina;
import infrastructures.Factories;

public class DeleteRutinaCommand implements Command<Long> {

	private String name;

	public DeleteRutinaCommand(String name) {
		this.name = name;
	}

	@Override
	public Long execute() throws BusinessException {	
		Rutina rutina = Factories.services.getRutinaService().findById(name);

		for(DiaEntreno de: rutina.getDiasEntrenamiento()) {
			Factories.persistence.getSerieDao().delete(de.getId());

		}
		
		Factories.persistence.getDiaRutinaoDao().delete(name);

		Factories.persistence.getRutinaoDao().deleteByName(name);

		return null;
	}
	
}
