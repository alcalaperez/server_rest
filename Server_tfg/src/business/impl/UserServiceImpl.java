package business.impl;

import business.UserService;
import business.exception.BusinessException;
import business.impl.command.CommandExecutor;
import business.impl.user.CreateUserCommand;
import business.impl.user.FindLoggableUserCommand;
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


}