package business.impl.rutina;

import java.util.List;

import business.exception.BusinessException;
import business.impl.command.Command;
import business.model.DiaEntreno;
import business.model.Rutina;
import business.model.Serie;
import infrastructures.Factories;

public class FindAll implements Command<List<Rutina>> {

	private List<Rutina> rutinas;


	@Override
	public List<Rutina> execute() throws BusinessException {		
		rutinas = Factories.persistence.getRutinaoDao().findAll();
				
		for(Rutina r: rutinas) {
			List<DiaEntreno> dias = Factories.persistence.getDiaRutinaoDao().findByRutinaId(r.getNombre());

			for(DiaEntreno d: dias) {
				List<Serie> series = Factories.persistence.getSerieDao().findByDiaId(d.getId());
				
				for(Serie s: series) {
					d.addSerie(s);
				}
				
				r.addDiaEntrenamiento(d);
			}

		}
		
		return rutinas;
	}
	
}
