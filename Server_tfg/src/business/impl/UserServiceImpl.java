package business.impl;

import java.util.List;

import business.UserService;
import business.exception.BusinessException;
import business.impl.command.CommandExecutor;
import business.impl.user.CreateUserCommand;
import business.impl.user.FindAll;
import business.impl.user.FindLoggableUserCommand;
import business.impl.user.UpdateRutinaAsignadaCommand;
import business.impl.user.UpdateRutinaAsignadaForAllCommand;
import business.impl.user.VerifyAlreadyRegisteredCommand;
import business.impl.user.VerifyAlreadyTakenCommand;
import business.impl.user.VerifyUserGymCommand;
import business.model.GymUser;
import business.model.Usuario;


public class UserServiceImpl implements UserService {

	@Override
	public void createUser(Usuario user) throws BusinessException {
		new CommandExecutor<Long>().execute( 
				new CreateUserCommand( user )
			);
		
	}

	@Override
	public Usuario findLoggableUser(String username, String password) throws BusinessException {
		return new CommandExecutor<Usuario>()
				.execute(new FindLoggableUserCommand<Usuario>(username, password));
	}

	@Override
	public GymUser verifyIsInGym(int numberCard, String key) throws BusinessException {
		return new CommandExecutor<GymUser>()
				.execute(new VerifyUserGymCommand<GymUser>(numberCard, key));
	}

	@Override
	public Usuario verifyAlreadyRegistered(int numeroSocio) throws BusinessException {
		return new CommandExecutor<Usuario>()
				.execute(new VerifyAlreadyRegisteredCommand<GymUser>(numeroSocio));
	}

	@Override
	public Usuario verifyAlreadyTaken(String login) throws BusinessException {
		return new CommandExecutor<Usuario>()
				.execute(new VerifyAlreadyTakenCommand<GymUser>(login));
	}

	@Override
	public List<Usuario> findAll() throws BusinessException {
		return new CommandExecutor<List<Usuario>>()
				.execute(new FindAll());
	}

	@Override
	public void updateRutinaAsignada(String username, String rutina) throws BusinessException {
		new CommandExecutor<Void>().execute( 
				new UpdateRutinaAsignadaCommand(username, rutina)
			);		
	}

	@Override
	public void updateAllRutinaAsignada(String somatotipo, String objetivo, String rutina) throws BusinessException {
		new CommandExecutor<Void>().execute( 
				new UpdateRutinaAsignadaForAllCommand(somatotipo, objetivo, rutina)
			);		
	}
	

}