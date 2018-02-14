package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
	@JWTTokenNeeded
	public List<Rutina> findAllRutinas()
			throws BusinessException;
	
	@GET
	@Path("/findAllLight")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@JWTTokenNeeded
	public List<Rutina> findAllRutinasLight()
			throws BusinessException;
	
	@GET
	@Path("/findByCaracs/{somatotipo}/{objetivo}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Rutina> findRutinaBySomatotipoObjetivo(@PathParam("somatotipo") String somatotipo, @PathParam("objetivo") String objetivo)
			throws BusinessException;
	
	@GET
	@Path("/findByCaracs/{somatotipo}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@JWTTokenNeeded
	public List<Rutina> findRutinaBySomatotipo(@PathParam("somatotipo") String somatotipo)
			throws BusinessException;


	@PUT 
	@Path("/createRutina")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@JWTTokenNeeded
	public void createRutina(Rutina rutina) throws BusinessException;

	@POST
	@Path("/updateRutina")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@JWTTokenNeeded
	public void updateRutina(Rutina rutina) throws BusinessException;

	@DELETE
	@Path("/{id}")
	@JWTTokenNeeded
	public void deleteRutina(@PathParam("id") String name) throws BusinessException;

}
