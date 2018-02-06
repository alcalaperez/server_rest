package business;

import business.exception.BusinessException;
import business.model.GymUser;
import business.model.Usuario;

public interface UserService {	
	public void createUser(Usuario user) throws BusinessException;
	public Usuario findLoggableUser(String username, String password) throws BusinessException;
	public GymUser verifyIsInGym(int numberCard, String key) throws BusinessException;
	public Usuario verifyAlreadyRegistered(int numeroSocio) throws BusinessException;
	public Usuario verifyAlreadyTaken(String login) throws BusinessException;

}
