package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	static private Connection connection;

	//So that no one create its object from outside and 
		//we can get single instance of Connection for complete project
	
	private ConnectionProvider() {
		super();
	}

	public static Connection getConnection() {
		if (connection == null) {
			String url = "jdbc:mysql://localhost:3306/Event_Management_System";
			try {
				connection = DriverManager.getConnection(url, "root", "nir13072001@N");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	
	}
	

}
