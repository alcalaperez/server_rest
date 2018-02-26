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
		Ejercicio ejercicioRepetido = Factories.persistence.getEjercicioDao().findByName(ejercicio.getNombre());
		if(ejercicioRepetido == null) {
			Factories.persistence.getEjercicioDao().save(ejercicio);
			return (long) 1;
		} else {
			return (long) 0;
		}
	}
	
}
