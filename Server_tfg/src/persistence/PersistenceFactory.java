package persistence;


public interface PersistenceFactory {
	public Transaction newTransaction() ;
	public EjercicioDao getEjercicioDao();
	public RutinaDao getRutinaoDao();
	public DiaRutinaDao getDiaRutinaoDao();
	public SerieDao getSerieDao();
	public UserDao getUserDao();

}
