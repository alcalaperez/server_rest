package business;

import business.impl.EjercicioServiceImpl;
import business.impl.RutinaServiceImpl;

public class SimpleServicesFactory implements ServiceFactory {

	@Override
	public EjercicioService getEjercicioService() {
		return new EjercicioServiceImpl();
	}


	@Override
	public RutinaService getRutinaService() {
		return new RutinaServiceImpl();
	}

}
