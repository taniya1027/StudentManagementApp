package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider
{
	static Connection conn;
	
	public static Connection createConn() throws SQLException
	{
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/student_manage";
			String user = "root";
			String password = "root";
			
			conn = DriverManager.getConnection(url,user,password);
		}
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

}
