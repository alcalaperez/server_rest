package business.impl.rutina;

import java.util.List;

import business.exception.BusinessException;
import business.impl.command.Command;
import business.model.DiaEntreno;
import business.model.Ejercicio;
import business.model.Rutina;
import business.model.Serie;
import infrastructures.Factories;

public class FindByCaracs implements Command<List<Rutina>> {

	private String somatotipo;
	private String objetivo;

	public FindByCaracs(String somatotipo, String objetivo) {
		this.somatotipo = somatotipo;
		this.objetivo = objetivo;
	}

	@Override
	public List<Rutina> execute() throws BusinessException {
		List<Rutina> rutinas = Factories.persistence.getRutinaoDao().findBySomaObjet(somatotipo, objetivo);

		for(Rutina r: rutinas) {
			List<DiaEntreno> dias = Factories.persistence.getDiaRutinaoDao().findByRutinaId(r.getNombre());

			for(DiaEntreno d: dias) {
				List<Serie> series = Factories.persistence.getSerieDao().findByDiaId(d.getId());
				
				for(Serie s: series) {
					Ejercicio ejercicio = Factories.persistence.getEjercicioDao().findByName(s.getEjercicioId());
					s.setEjercicio(ejercicio);
					d.addSerie(s);
				}
				
				r.addDiaEntrenamiento(d);
			}

		}
		
		return rutinas;
	}

}
