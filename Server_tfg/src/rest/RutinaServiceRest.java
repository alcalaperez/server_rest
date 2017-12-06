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
import business.model.Rutina;
/**
 * Rest para servicios de categorias
 * 
 */
@Path("/RutinaServiceRs")
public interface RutinaServiceRest {

	@GET
	@Path("/findAll")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Rutina> findAllRutinas(@Context HttpServletRequest request)
			throws BusinessException;


	@PUT 
	@Path("/createRutina")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void createRutina(Rutina rutina, @Context HttpServletRequest request) throws BusinessException;

	@POST
	@Path("/updateRutina")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void updateRutina(Rutina rutina, @Context HttpServletRequest request) throws BusinessException;


}
