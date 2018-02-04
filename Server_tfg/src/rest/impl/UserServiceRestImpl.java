package rest.impl;

import javax.servlet.http.HttpServletRequest;

import business.UserService;
import business.exception.BusinessException;
import business.model.GymUser;
import business.model.Usuario;
import infrastructures.Factories;
import rest.UserServiceRest;

public class UserServiceRestImpl implements UserServiceRest {
	UserService service = Factories.services.getUserService();
	

	@Override
	public Usuario findLoggableUser(String login, String password, HttpServletRequest request)
			throws BusinessException {
		return service.findLoggableUser(login, password);
	}


	@Override
	public void createUser(Usuario user, HttpServletRequest request) throws BusinessException {
		service.createUser(user);
		
	}

	@Override
	public GymUser verifyIsInGym(int numeroSocio, String key, HttpServletRequest request) throws BusinessException {
		return service.verifyIsInGym(numeroSocio, key);

	}

	  
}
