package rest;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import business.exception.BusinessException;
import business.model.GymUser;
import business.model.Usuario;
/**
 * Rest para servicios de categorias
 * 
 */
@Path("/UserServiceRs")
public interface UserServiceRest {

	@PUT 
	@Path("/createUser")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void createUser(Usuario user, @Context HttpServletRequest request) throws BusinessException;

	
	@GET
	@Path("/findLog/{login}/{password}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Usuario findLoggableUser(@PathParam("login") String login,
			@PathParam("password") String password, 
			 @Context HttpServletRequest request) throws BusinessException;
	

	@GET
	@Path("/verify/{numeroSocio}/{key}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public GymUser verifyIsInGym(@PathParam("numeroSocio") int numeroSocio,
			@PathParam("key") String key, 
			 @Context HttpServletRequest request) throws BusinessException;

	@GET
	@Path("/alreadyReg/{numeroSocio}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	Usuario verifyAlreadyRegistered(@PathParam("numeroSocio") int numeroSocio, HttpServletRequest request) throws BusinessException;
	
	@GET
	@Path("/alreadyTak/{login}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	Usuario verifyAlreadyTaken(@PathParam("login") String login, HttpServletRequest request) throws BusinessException;
	
}
