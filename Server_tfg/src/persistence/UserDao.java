package persistence;

import business.model.GymUser;
import business.model.Usuario;
import persistence.util.GenericDao;

public interface UserDao  extends GenericDao<Usuario, Long> {

	Usuario findLoggableUser(String login, String password);
	GymUser verifyUser(int numberCards, String key);
	Usuario verifyAlreadyRegistered(int numberCards);
	Usuario verifyAlreadyTaken(String login);
	void updateUserRutina(String usuario, String rutina);
	void updateUserRutinaForAll(String somatotipo, String objetivo, String rutina);
	GymUser getKeyGymUser(int user);


}

