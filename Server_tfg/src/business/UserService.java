package business;

import java.util.List;

import business.exception.BusinessException;
import business.model.GymUser;
import business.model.Usuario;

public interface UserService {	
	public void createUser(Usuario user) throws BusinessException;
	public Usuario findLoggableUser(String username, String password) throws BusinessException;
	public GymUser verifyIsInGym(int numberCard, String key) throws BusinessException;
	public Usuario verifyAlreadyRegistered(int numeroSocio) throws BusinessException;
	public Usuario verifyAlreadyTaken(String login) throws BusinessException;
	public List<Usuario> findAll() throws BusinessException;
	public void updateRutinaAsignada(String username, String rutina) throws BusinessException;
	public void updateAllRutinaAsignada(String somatotipo, String objetivo, String rutina) throws BusinessException;
	public String getKeyGymUser(String numeroSocio) throws BusinessException;

}
