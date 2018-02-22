package business.impl;

import java.util.List;

import business.RutinaService;
import business.exception.BusinessException;
import business.impl.command.Command;
import business.impl.command.CommandExecutor;
import business.impl.rutina.CreateRutinaCommand;
import business.impl.rutina.DeleteRutinaCommand;
import business.impl.rutina.FindAll;
import business.impl.rutina.FindByCaracs;
import business.impl.rutina.FindById;
import business.impl.rutina.FindBySomatipo;
import business.model.Rutina;
import infrastructures.Factories;

public class RutinaServiceImpl implements RutinaService {

	@Override
	public Long createRutina(Rutina rutina) throws BusinessException {
		return new CommandExecutor<Long>().execute(new CreateRutinaCommand(rutina));
	}

	@Override
	public void deleteRutinaByName(String name) throws BusinessException {
		new CommandExecutor<Long>().execute(new DeleteRutinaCommand(name));

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
		return new CommandExecutor<List<Rutina>>().execute(new FindAll());
	}

	@Override
	public Rutina findById(String nombre) throws BusinessException {
		return new CommandExecutor<Rutina>().execute(new FindById(nombre));
	}

	@Override
	public List<Rutina> findBySomaObjet(String somatotipo, String objetivo) throws BusinessException {
		return new CommandExecutor<List<Rutina>>().execute(new FindByCaracs(somatotipo, objetivo));
	}

	@Override
	public List<Rutina> findBySoma(String somatotipo) throws BusinessException {
		return new CommandExecutor<List<Rutina>>().execute(new FindBySomatipo(somatotipo));
	}

	@Override
	public List<Rutina> findAllOnlyNames() throws BusinessException {
		return new CommandExecutor<List<Rutina>>().execute(new Command<List<Rutina>>() {
			@Override
			public List<Rutina> execute() throws BusinessException {
				return Factories.persistence.getRutinaoDao().findAll();
			}
		});

	}

	@Override
	public Rutina findAssignedRutina(String somatotipo, String objetivo) throws BusinessException {
		return new CommandExecutor<Rutina>().execute(new Command<Rutina>() {
			@Override
			public Rutina execute() throws BusinessException {
				return new FindById(Factories.persistence.getRutinaoDao().findAsignRutina(somatotipo, objetivo).getRutinaAsignada()).execute();
				 
			}
		});
	}

	@Override
	public String findAssignedRutinaLight(String somatotipo, String objetivo) throws BusinessException {
		return new CommandExecutor<String>().execute(new Command<String>() {
			@Override
			public String execute() throws BusinessException {
				return Factories.persistence.getRutinaoDao().findAsignRutina(somatotipo, objetivo).getRutinaAsignada();
				 
			}
		});
	}
}