package business.impl.user;

import business.exception.BusinessException;
import business.impl.command.Command;
import business.model.Usuario;
import infrastructures.Factories;

public class FindLoggableUserCommand<T> implements Command<Usuario> {

	private String login;
	private String password;

	public FindLoggableUserCommand(String login, String password) {
		this.login = login;
		this.password = password;
	}

	@Override
	public Usuario execute() throws BusinessException {		
		return Factories.persistence.getUserDao()
		.findLoggableUser(login, password);
	}

}
