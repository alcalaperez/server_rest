package business.impl.user;

import business.exception.BusinessException;
import business.impl.command.Command;
import business.model.GymUser;
import infrastructures.Factories;

public class GetKeyGymUserCommand implements Command<String> {

	private String userGym;

	public GetKeyGymUserCommand(String userGym) {
		this.userGym = userGym;
	}

	@Override
	public String execute() throws BusinessException {		
		GymUser ug = Factories.persistence.getUserDao().getKeyGymUser(Integer.parseInt(userGym));
		
		if(ug != null) {
			return ug.getKey();
		} else {
			return null;
		}
	}

}
