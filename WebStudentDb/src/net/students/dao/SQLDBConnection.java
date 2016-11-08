package net.students.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class SQLDBConnection {

	private static Connection connection;

	public static Connection getConnection() {
		if( connection != null )
			return connection;
			try {
				Context ctx = new InitialContext();
				DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/StudentsDS");
				connection = dataSource.getConnection();
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}

		return connection;
	}


	public static void closeConnection( Connection toBeClosed ) {
		if( toBeClosed == null )
			return;
		try {
			toBeClosed.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
