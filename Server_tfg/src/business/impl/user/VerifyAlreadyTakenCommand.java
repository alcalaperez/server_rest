package business.impl.user;

import business.exception.BusinessException;
import business.impl.command.Command;
import business.model.Usuario;
import infrastructures.Factories;

public class VerifyAlreadyTakenCommand<T> implements Command<Usuario> {

	private String login;

	public VerifyAlreadyTakenCommand(String login) {
		this.login = login;
	}

	@Override
	public Usuario execute() throws BusinessException {		
		return Factories.persistence.getUserDao().verifyAlreadyTaken(login);
		
	}

}
