package business.impl.ejercicio;

import business.exception.BusinessException;
import business.impl.command.Command;
import business.impl.util.EjercicioCheck;
import business.model.Ejercicio;
import infrastructures.Factories;

public class CreateEjercicioCommand implements Command<Long> {

	private Ejercicio ejercicio;

	public CreateEjercicioCommand(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	@Override
	public Long execute() throws BusinessException {
		EjercicioCheck.nameIsNotNull(ejercicio);
		EjercicioCheck.nameIsNotEmpty(ejercicio);
		EjercicioCheck.consejoIsNotNullOrEmpty(ejercicio);
		EjercicioCheck.descriptionIsNotNullOrEmpty(ejercicio);
		EjercicioCheck.fotosIsNotNullOrEmpty(ejercicio);
		
		return Factories.persistence.getEjercicioDao().save(ejercicio);
	}
	
}
