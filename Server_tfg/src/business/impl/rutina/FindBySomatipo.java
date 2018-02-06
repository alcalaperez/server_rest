package business.impl.rutina;

import java.util.List;

import business.exception.BusinessException;
import business.impl.command.Command;
import business.model.DiaEntreno;
import business.model.Rutina;
import business.model.Serie;
import infrastructures.Factories;

public class FindBySomatipo implements Command<List<Rutina>> {

	private String somatotipo;

	public FindBySomatipo(String somatotipo) {
		this.somatotipo = somatotipo;
	}

	@Override
	public List<Rutina> execute() throws BusinessException {
		List<Rutina> rutinas = Factories.persistence.getRutinaoDao().findBySoma(somatotipo);

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
