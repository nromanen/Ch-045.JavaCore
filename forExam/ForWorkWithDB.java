package forExam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ForWorkWithDB {
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String database = "jdbc:mysql://localhost:3306/myfirstdb";
			String userName = "root";
			String password = "root";
			Class.forName(driver);

			Connection conn = DriverManager.getConnection(database, userName, password);
			System.out.println("Connected");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void createTable()  {
		Connection conn = getConnection();
		try {
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS mycars(id int NOT NULL AUTO_INCREMENT, model varchar(64), year int, color varchar(25), PRIMARY KEY(id))");
			create.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	public void myCarstoTableDB(ArrayList<Car> list) throws SQLException {
		Connection conn = getConnection();

		for (Car car : list) {

			PreparedStatement s = conn.prepareStatement("INSERT INTO mycars (model, year, color) VALUES(?,?,?)");
			s.setString(1, car.getModel());
			s.setInt(2, car.getYear());
			s.setString(3, car.getColour());
			s.executeUpdate();
		}
		conn.close();
	}

	public void outputTable() throws SQLException {
		Connection conn = getConnection();
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery("select*from mycars");
		while (rs.next()) {
			int k = rs.getInt("id");
			String g = rs.getString("model");
			int m = rs.getInt("year");
			String f = rs.getString("color");
			System.out.println(k + " " + g + " " + m + " " + f);
		}
		conn.close();
	}
	
}
