package business.impl;

import java.util.List;

import business.RutinaService;
import business.exception.BusinessException;
import business.impl.command.Command;
import business.impl.command.CommandExecutor;
import business.impl.rutina.CreateRutinaCommand;
import business.model.Rutina;
import infrastructures.Factories;


public class RutinaServiceImpl implements RutinaService {


	@Override
	public Long createRutina(Rutina rutina) throws BusinessException {
		return new CommandExecutor<Long>().execute( 
				new CreateRutinaCommand( rutina )
			);
	}

	@Override
	public void deleteRutinaByName(String name) throws BusinessException {
		new CommandExecutor<Void>().execute( new Command<Void>() {
			@Override
			public Void execute() throws BusinessException {
				Factories.persistence.getRutinaoDao().deleteByName(name);
				return null;
			}
		}); 
		
	}

	@Override
	public void updateRutina(Rutina rutina) throws BusinessException {
		new CommandExecutor<Void>().execute(new Command<Void>() {
			@Override
			public Void execute() throws BusinessException {
				Factories.persistence.getRutinaoDao().update(rutina);
				return null;
			}
		}); 
		
	}


	@Override
	public List<Rutina> findAll() throws BusinessException {
		return new CommandExecutor<List<Rutina>>().execute( new Command<List<Rutina>>() {
			@Override public List<Rutina> execute() throws BusinessException {				
				return Factories.persistence.getRutinaoDao().findAll();
			}
		});
	}
}