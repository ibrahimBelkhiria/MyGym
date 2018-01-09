package matrix.gym.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseConnexion {

	
	String url="jdbc:mysql://localhost/matrixGym";
	String user="root";
	String password="";
	Connection c;
	
	public Connection getConnexion() {
	
		try {
				
				Class.forName("com.mysql.jdbc.Driver");
				 c =DriverManager.getConnection(url,user,password);
				System.out.println("driver charged! and connexion established");
			
				
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			
		return c;
			
	}
	
	
	
}
