package persistence;

import persistence.impl.DiaRutinaDaoJdbcImpl;
import persistence.impl.EjercicioDaoJdbcImpl;
import persistence.impl.RutinaDaoJdbcImpl;
import persistence.impl.SerieDaoJdbcImpl;
import persistence.impl.TransactionJdbcImpl;
import persistence.impl.UserDaoJdbcImpl;

public class SimplePersistenceFactory  implements PersistenceFactory  {
	public Transaction newTransaction() {
		return new TransactionJdbcImpl();
	}

	@Override
	public EjercicioDao getEjercicioDao() {
		return new EjercicioDaoJdbcImpl();

	}

	@Override
	public RutinaDao getRutinaoDao() {
		return new RutinaDaoJdbcImpl();
	}

	@Override
	public DiaRutinaDao getDiaRutinaoDao() {
		return new DiaRutinaDaoJdbcImpl();

	}
	

	@Override
	public SerieDao getSerieDao() {
		return new SerieDaoJdbcImpl();

	}

	@Override
	public UserDao getUserDao() {
		return new UserDaoJdbcImpl();

	}

}
