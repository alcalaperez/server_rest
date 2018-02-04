package persistence;

import business.model.GymUser;
import business.model.Usuario;
import persistence.util.GenericDao;

public interface UserDao  extends GenericDao<Usuario, Long> {

	Usuario findLoggableUser(String login, String password);
	GymUser verifyUser(int numberCards, String key);


}

