package connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	private Connection connection = null;
	public Connection getType4Connection(){
	
		// Setup the connection with the DB
        try {
        	loadDriver("com.mysql.jdbc.Driver");
			connection = DriverManager
			          .getConnection("jdbc:mysql://www.papademas.net/fp?"
		+"user=dbfp&password=510");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return connection;
	}
	
	
	private void loadDriver(String driverName) throws ClassNotFoundException{
        Class.forName(driverName);
    }
	
	public void closeConnection(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
      
}
