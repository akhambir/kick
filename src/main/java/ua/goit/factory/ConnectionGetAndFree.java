package ua.goit.factory;

import java.sql.Connection;

public class ConnectionGetAndFree {
 
	private final DBConnectionManager connectionManager = DBConnectionManager.getInstance();
	private String name = null;
		
	public ConnectionGetAndFree (ConnectionPoolNames name) {
		this.name = name.getStringName();
	}
		
	public Connection getConnection() {
		return connectionManager.getConnection(name);
	}

	public void freeConnection(Connection connection) {
		connectionManager.freeConnection(connection, name);
	}

	public void release() {
		 connectionManager.release();
	}
}
