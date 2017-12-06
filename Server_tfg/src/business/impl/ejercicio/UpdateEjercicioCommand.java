package business.impl.ejercicio;

import business.exception.BusinessException;
import business.impl.command.Command;
import business.impl.util.EjercicioCheck;
import business.model.Ejercicio;
import infrastructures.Factories;

public class UpdateEjercicioCommand implements Command<Void> {

	private Ejercicio ejercicio;

	public UpdateEjercicioCommand(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	@Override
	public Void execute() throws BusinessException {
		EjercicioCheck.consejoIsNotNullOrEmpty(ejercicio);
		EjercicioCheck.descriptionIsNotNullOrEmpty(ejercicio);
		EjercicioCheck.fotosIsNotNullOrEmpty(ejercicio);
		
		Factories.persistence.getEjercicioDao().update(ejercicio);
		return null;
	}

}
