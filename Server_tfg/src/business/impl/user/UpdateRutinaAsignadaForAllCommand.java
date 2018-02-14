package business.impl.user;

import business.exception.BusinessException;
import business.impl.command.Command;
import infrastructures.Factories;

public class UpdateRutinaAsignadaForAllCommand  implements Command<Void> {

	private String somatotipo;
	private String objetivo;
	private String rutina;

	public UpdateRutinaAsignadaForAllCommand(String somatotipo, String objetivo, String rutina) {
		this.somatotipo = somatotipo;
		this.objetivo = objetivo;
		this.rutina = rutina;
	}

	@Override
	public Void execute() throws BusinessException {
		Factories.persistence.getUserDao().updateUserRutinaForAll(somatotipo, objetivo, rutina);
		return null;
	}

}
