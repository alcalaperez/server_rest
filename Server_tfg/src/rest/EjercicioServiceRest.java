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
import business.model.Ejercicio;
import business.model.StringJax;
/**
 * Rest para servicios de categorias
 * 
 */
@Path("/EjercicioServiceRs")
public interface EjercicioServiceRest {

	@GET
	@Path("/findAll")
	@JWTTokenNeeded
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Ejercicio> findAllEjercicios()
			throws BusinessException;

	@GET
	@Path("/findByMusculo/{musculo}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@JWTTokenNeeded
	public List<Ejercicio> findByMusculo(@PathParam("musculo") String musculo)
			throws BusinessException;
	
	@GET
	@Path("/findByName/{nombre}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@JWTTokenNeeded
	public Ejercicio findByName(@PathParam("nombre") String nombre)
			throws BusinessException;
	
	@GET
	@Path("/findMusculos")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@JWTTokenNeeded
	public List<StringJax> findMusculos() throws BusinessException;

	@PUT 
	@Path("/createEjercicio")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@JWTTokenNeeded
	public void createEjercicio(Ejercicio ejercicio) throws BusinessException;

	@POST
	@Path("/updateEjercicio")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@JWTTokenNeeded
	public void updateEjercicio(Ejercicio ejercicio) throws BusinessException;

	@DELETE    
	@Path("/{id}")
	@JWTTokenNeeded
	public void deleteEjercicio(@PathParam("id") String id) throws BusinessException;


}
