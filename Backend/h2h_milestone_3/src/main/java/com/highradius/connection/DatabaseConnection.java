//In this file I am making the connection of JDBC with MySQL Server
//Later I will use object of this class to setup the connection

package com.highradius.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	public static Connection getConnection() {
		Connection connection = null;
		
		//Initializing the URL, user, password for connection
		String url="jdbc:mysql://localhost:3306/h2h"; 
		String user = "root";
		String password = "PritishSQL@1234";
		
		
		try {
			//Starting Connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
	
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		
		return connection;
		
	}
	
 
}
