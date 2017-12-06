package persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConection {
	
	public static Connection getConnection() {
		// Connect to database
		
		Connection connection = null;
		String host = "ec2-54-247-124-9.eu-west-1.compute.amazonaws.com";
		String port = "5432";
		String path = "/dek07s26cvvkds?user=snnqkzdkgcfcyv&password=7e00ae9bb72f9ca63a1a757f2cbe5fd76f01dbdc8152ead80da228759f330cb1&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
		try {
		    String dbUrl = "jdbc:postgresql://" + host + ':' + port +path;
			connection = DriverManager.getConnection(dbUrl);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}

}
