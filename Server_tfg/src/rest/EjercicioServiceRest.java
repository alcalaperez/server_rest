package rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import business.exception.BusinessException;
import business.model.Ejercicio;
/**
 * Rest para servicios de categorias
 * 
 */
@Path("/EjercicioServiceRs")
public interface EjercicioServiceRest {

	@GET
	@Path("/findAll")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Ejercicio> findAllEjercicios(@Context HttpServletRequest request)
			throws BusinessException;


	@PUT 
	@Path("/createEjercicio")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void createEjercicio(Ejercicio ejercicio, @Context HttpServletRequest request) throws BusinessException;

	@POST
	@Path("/updateEjercicio")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void updateEjercicio(Ejercicio ejercicio, @Context HttpServletRequest request) throws BusinessException;


}
