package persistence.impl;

import java.sql.Connection;
import java.sql.SQLException;

import persistence.PersistenceException;
import persistence.Transaction;

public class TransactionJdbcImpl implements Transaction {
	
	private Connection con;
	private static String CONFIG_FILE = "/persistence.properties";
	private JdbcHelper jdbc = new JdbcHelper(CONFIG_FILE);

	@Override
	public void begin() {
		assertNullConnection();
		con = jdbc.createConnection();
		
	}

	@Override
	public void commit() {
		assertNonNullConnection();
		assertOpenConnection();
		
	}

	@Override
	public void rollback() {
		assertNonNullConnection();
		assertOpenConnection();
		
	}

	private void assertNullConnection() {
		if (con == null) return;
		throw new PersistenceException("Transaction is already initiated");
	}

	private void assertNonNullConnection() {
		if (con != null) return;
		throw new PersistenceException("Transaction is not initiated. "
				+ "Call begin() method before use it.");
	}

	private void assertOpenConnection() {
		if ( connectionIsOpen() ) return;
		throw new PersistenceException("Transaction is not initiated. "
				+ "Call begin() method before use it.");
	}

	private boolean connectionIsOpen() {
		try {
			return ! con.isClosed();
		} catch (SQLException e) {
			throw new PersistenceException("Unexpected JDBC error");
		}
	}

}
