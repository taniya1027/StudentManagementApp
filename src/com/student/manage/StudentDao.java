package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDao {
	
	
	
	public static boolean insertStudent(Student st) throws SQLException
	{
		 boolean f = false;
		Connection conn = ConnectionProvider.createConn();
		
		String query = "insert into student(sname,sphone,scity) values(?,?,?)";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, st.getStudentName());
		pstmt.setString(2, st.getStudentPhone());
		pstmt.setString(3, st.getStudentCity());
		
		pstmt.executeUpdate();
		f = true;
		
		return f;
		
		
	}
	
	public static boolean deleteStudent(int id) throws SQLException
	{
		Connection conn = ConnectionProvider.createConn();
		boolean f = false;
		
		String query = "delete from student where sid = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(query);
		
		pstmt.setInt(1,id);
		pstmt.executeUpdate();
		f = true;
		
		return f;
		
		
		
	}
	
	public static void showAllStudent() throws SQLException
	{
		Connection conn = ConnectionProvider.createConn();
		
		String query = "select * from student";
		Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
		
	    while(rs.next())
	    {
	    	int id = rs.getInt(1);
	    	String name = rs.getString(2);
	    	String phone = rs.getString(3);
	    	String city = rs.getString(4);
	    	
	    	System.out.println("Student id : "+id);
	    	System.out.println("Student name : "+name);
	    	System.out.println("Student phone : "+phone);
	    	System.out.println("Student city : "+city);
	    	System.out.println("++++++++++++++++++++++++++++++++");
	    }
	}

}
