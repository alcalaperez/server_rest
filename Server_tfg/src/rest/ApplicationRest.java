package rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import rest.impl.EjercicioServiceRestImpl;
import rest.impl.RutinaServiceRestImpl;

/**
 * Clase para anadir los servicios rest al contenedor
 * 
 */
@ApplicationPath("/")
public class ApplicationRest extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> res = new HashSet<>();
		res.add(EjercicioServiceRestImpl.class);
		res.add(RutinaServiceRestImpl.class);

		return res;
	}
}
