package business.impl.user;

import java.util.List;

import business.exception.BusinessException;
import business.impl.command.Command;
import business.model.Usuario;
import infrastructures.Factories;

public class FindAll implements Command<List<Usuario>> {

	@Override
	public List<Usuario> execute() throws BusinessException {		
		return Factories.persistence.getUserDao().findAll();				
		
	}
	
}
