package rest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import business.exception.BusinessException;
import business.model.GymUser;
import business.model.Usuario;
/**
 * Rest para servicios de usuarios
 * 
 */
@Path("/UserServiceRs")
public interface UserServiceRest {

	@PUT 
	@Path("/createUser")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void createUser(Usuario user) throws BusinessException;

	
	@GET
	@Path("/findLog/{login}/{password}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response findLoggableUser(@PathParam("login") String login,
			@PathParam("password") String password) throws BusinessException;
	
	@GET
	@Path("/findAll")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@JWTTokenNeeded
	public List<Usuario> findAllUsers() throws BusinessException;

	@GET
	@Path("/verify/{numeroSocio}/{key}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public GymUser verifyIsInGym(@PathParam("numeroSocio") int numeroSocio,
			@PathParam("key") String key) throws BusinessException;

	@GET
	@Path("/alreadyReg/{numeroSocio}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Usuario verifyAlreadyRegistered(@PathParam("numeroSocio") int numeroSocio) throws BusinessException;
	
	@GET
	@Path("/alreadyTak/{login}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Usuario verifyAlreadyTaken(@PathParam("login") String login) throws BusinessException;
	
	@GET
	@Path("/updateRutina/{username}/{rutina}")
	@JWTTokenNeeded
	public void updateRutina(@PathParam("username") String username, @PathParam("rutina") String rutina) throws BusinessException;
	

	@GET
	@Path("/updateRutinaByBody/{somatotipo}/{objetivo}/{rutina}")
	@JWTTokenNeeded
	public void updateRutinaByBody(@PathParam("somatotipo") String somatotipo, @PathParam("objetivo") String objetivo, @PathParam("rutina") String rutina) throws BusinessException;
}
