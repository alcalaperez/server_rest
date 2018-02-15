package rest.impl;

import java.util.Base64;
import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import business.UserService;
import business.exception.BusinessException;
import business.model.GymUser;
import business.model.Usuario;
import infrastructures.Factories;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import rest.UserServiceRest;

public class UserServiceRestImpl implements UserServiceRest {
	private UserService service = Factories.services.getUserService();
	byte[] decodedKey = Base64.getDecoder().decode("11162210");
	SecretKey keySign = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES"); 
 
	@Override
	public Response findLoggableUser(String login, String password)
			throws BusinessException {
		Usuario u = service.findLoggableUser(login, password);
		Response response;
		
		if(u != null) {
			response = Response.ok().entity(u).
                header("token", issueToken(login, password)).build();
		} else {
			response = Response.status(Status.UNAUTHORIZED).build();
		}
		return response;
	}


	@Override
	public void createUser(Usuario user) throws BusinessException {
		service.createUser(user);
		
	}

	@Override
	public GymUser verifyIsInGym(int numeroSocio, String key) throws BusinessException {
		return service.verifyIsInGym(numeroSocio, key);

	}
	
	@Override
	public Usuario verifyAlreadyRegistered(int numeroSocio) throws BusinessException {
		return service.verifyAlreadyRegistered(numeroSocio);

	}


	@Override
	public Usuario verifyAlreadyTaken(String login) throws BusinessException {
		return service.verifyAlreadyTaken(login);
	}

	private String issueToken(String login, String password) {		
        String jwtToken = Jwts.builder()
                .setSubject(login)
                .signWith(SignatureAlgorithm.HS256, keySign)
                .compact();
        return jwtToken;
    }


	@Override
	public List<Usuario> findAllUsers() throws BusinessException {
		return service.findAll();

	}


	@Override
	public void updateRutina(String username, String rutina) throws BusinessException {
		service.updateRutinaAsignada(username, rutina);

	}


	@Override
	public void updateRutinaByBody(String somatotipo, String objetivo, String rutina) throws BusinessException {
		service.updateAllRutinaAsignada(somatotipo, objetivo, rutina);
		
	}


	@Override
	public String getKeyGymUser(String numeroSocio) throws BusinessException {
		return service.getKeyGymUser(numeroSocio);
		
	}
	
    
}
