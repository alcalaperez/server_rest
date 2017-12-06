package persistence.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcHelper {
	private Properties properties;

	public JdbcHelper(String configFile) {
		properties = new Properties();
		try {
			properties.load(JdbcHelper.class.getResourceAsStream(configFile));
		} catch (IOException e) {
			throw new RuntimeException("Properties file not found: " + configFile);
		}
	}

	public Connection createConnection() {
		Connection connection = null;
		String host = "ec2-54-247-124-9.eu-west-1.compute.amazonaws.com";
		String port = "5432";
		String path = "/dek07s26cvvkds?user=snnqkzdkgcfcyv&password=7e00ae9bb72f9ca63a1a757f2cbe5fd76f01dbdc8152ead80da228759f330cb1&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
		try {
			String dbUrl = "jdbc:postgresql://" + host + ':' + port + path;
			Class.forName("org.postgresql.Driver");
			
			connection = DriverManager.getConnection(dbUrl);

		} catch (SQLException e) {
			throw new RuntimeException("Can't open JDBC conection", e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Can't find class driver", e);
		}

		return connection;

	}

	private String getProperty(String property) {
		String value = properties.getProperty(property);
		if (value == null) {
			throw new RuntimeException("Property not found " + property);
		}
		return value;
	}

	public String getSql(String sql) {
		return getProperty(sql);
	}

	public void close(PreparedStatement ps, ResultSet rs, Connection con) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ex) {
			}
		}
		;
		close(ps, con);
	}

	public void close(PreparedStatement ps, Connection con) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception ex) {
			}
		}
		;
		if (con != null) {
			try {
				con.close();
			} catch (Exception ex) {
			}
		}
		;
	}

}
