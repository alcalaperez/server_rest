package business.impl.user;

import business.exception.BusinessException;
import business.impl.command.Command;
import business.model.GymUser;
import infrastructures.Factories;

public class VerifyUserGymCommand<T> implements Command<GymUser> {

	private int numberCards;
	private String key;

	public VerifyUserGymCommand(int numberCards, String key) {
		this.numberCards = numberCards;
		this.key = key;
	}

	@Override
	public GymUser execute() throws BusinessException {		
		return Factories.persistence.getUserDao().verifyUser(numberCards, key);
		
	}

}
