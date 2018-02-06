package business.impl.user;

import business.exception.BusinessException;
import business.impl.command.Command;
import business.model.Usuario;
import infrastructures.Factories;

public class VerifyAlreadyRegisteredCommand<T> implements Command<Usuario> {

	private int numberCards;

	public VerifyAlreadyRegisteredCommand(int numberCards) {
		this.numberCards = numberCards;
	}

	@Override
	public Usuario execute() throws BusinessException {		
		return Factories.persistence.getUserDao().verifyAlreadyRegistered(numberCards);
		
	}

}
