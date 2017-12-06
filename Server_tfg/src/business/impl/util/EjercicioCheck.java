package business.impl.util;

import business.exception.BusinessCheck;
import business.exception.BusinessException;
import business.model.Ejercicio;

public class EjercicioCheck {

	public static void nameIsNotNull(Ejercicio ejercicio) throws BusinessException {
		BusinessCheck.isNotNull(ejercicio.getNombre(), 
				"Ejercicio name cannot be null");
	}

	public static void nameIsNotEmpty(Ejercicio ejercicio) throws BusinessException {
		BusinessCheck.isFalse( ejercicio.getNombre().length() == 0 , 
				"Ejercicio name cannot be empty");
	}

	public static void descriptionIsNotNullOrEmpty(Ejercicio ejercicio) throws BusinessException {
		BusinessCheck.isNotNull( ejercicio.getDescripcion(),
				"A description cant be null");
		
		BusinessCheck.isFalse( ejercicio.getDescripcion().length() == 0 , 
				"Description cannot be empty");
	}
	
	public static void consejoIsNotNullOrEmpty(Ejercicio ejercicio) throws BusinessException {
		BusinessCheck.isNotNull( ejercicio.getConsejo(),
				"A consejo cant be null");
		
		BusinessCheck.isFalse( ejercicio.getConsejo().length() == 0 , 
				"Consejo cannot be empty");
	}
	
	public static void fotosIsNotNullOrEmpty(Ejercicio ejercicio) throws BusinessException {
		BusinessCheck.isNotNull( ejercicio.getFoto1(),
				"A foto cant be null");
		BusinessCheck.isNotNull( ejercicio.getFoto2(),
				"A foto cant be null");
		
	}

}
