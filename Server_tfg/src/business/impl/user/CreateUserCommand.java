package business.impl.user;

import business.exception.BusinessException;

import business.impl.command.Command;
import business.model.Usuario;
import infrastructures.Factories;

public class CreateUserCommand implements Command<Long> {

	private Usuario usuario;

	public CreateUserCommand(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public Long execute() throws BusinessException {
		return Factories.persistence.getUserDao().save(usuario);
	}
	
}
