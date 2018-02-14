package business.impl.user;

import business.exception.BusinessException;
import business.impl.command.Command;
import infrastructures.Factories;

public class UpdateRutinaAsignadaCommand  implements Command<Void> {

	private String usuario;
	private String rutina;

	public UpdateRutinaAsignadaCommand(String usuario, String rutina) {
		this.usuario = usuario;
		this.rutina = rutina;
	}

	@Override
	public Void execute() throws BusinessException {
		Factories.persistence.getUserDao().updateUserRutina(usuario, rutina);
		return null;
	}

}
