package business.impl.command;

import business.exception.BusinessException;
import persistence.PersistenceException;

public class CommandExecutor<T> {
	
	public T execute(Command<T> cmd) throws BusinessException {
		
		try {

			T res = cmd.execute();
			
			return res;
		}
		catch (PersistenceException | BusinessException ex) {
			
			throw ex;
		}
	}

}
