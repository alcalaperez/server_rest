package business.impl;

import java.util.List;

import business.EjercicioService;
import business.exception.BusinessException;
import business.impl.command.Command;
import business.impl.command.CommandExecutor;
import business.impl.ejercicio.CreateEjercicioCommand;
import business.impl.ejercicio.UpdateEjercicioCommand;
import business.model.Ejercicio;
import infrastructures.Factories;


public class EjercicioServiceImpl implements EjercicioService {


	@Override
	public Long createEjercicio(Ejercicio ejercicio) throws BusinessException {
		return new CommandExecutor<Long>().execute( 
				new CreateEjercicioCommand( ejercicio )
			);
	}

	@Override
	public void deleteEjercicioByName(String name) throws BusinessException {
		new CommandExecutor<Void>().execute( new Command<Void>() {
			@Override
			public Void execute() throws BusinessException {
				Factories.persistence.getEjercicioDao().deleteByName(name);
				return null;
			}
		}); 
		
	}

	@Override
	public void updateEjercicio(Ejercicio ejercicio) throws BusinessException {
		new CommandExecutor<Void>().execute( 
				new UpdateEjercicioCommand( ejercicio )
			);
		
	}


	@Override
	public List<Ejercicio> findAll() throws BusinessException {
		return new CommandExecutor<List<Ejercicio>>().execute( new Command<List<Ejercicio>>() {
			@Override public List<Ejercicio> execute() throws BusinessException {				
				return Factories.persistence.getEjercicioDao().findAll();
			}
		});
	}
}