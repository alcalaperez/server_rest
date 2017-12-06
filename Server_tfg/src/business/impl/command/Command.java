package business.impl.command;

import business.exception.BusinessException;

public interface Command<T> {
	T execute() throws BusinessException;

}
