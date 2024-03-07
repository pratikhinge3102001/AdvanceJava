package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class jdbc2 {

    public static void main(String[] args) {
    	Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
        // TODO Auto-generated method stub
		//step 1
		//loading driver class in memory
		//registering itself with DriverManager
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//step 2
		String jdbcurl = "jdbc:mysql://localhost:3306/jdbc";
		con = DriverManager.getConnection(jdbcurl,"root","root");
		System.out.println("Connection established");
		
		//step 3
		//empty object - holding SQL query
		stmt = con.createStatement();
		
		//step 4
		rs = stmt.executeQuery("select * from emp");
		
		//processing result set
		while(rs.next())
		{
			//iteration for one record
			System.out.print(rs.getInt(1)+" : ");
			System.out.print(rs.getString(2)+" : ");
			System.out.print(rs.getString(3)+":");
			System.out.print(rs.getInt(4)+":");
			System.out.print(rs.getDate(5)+" : ");
			System.out.print(rs.getFloat(6)+":");
			System.out.print(rs.getFloat(7)+":");
			System.out.print(rs.getInt(8));
			
			System.out.println();				
		}
		}
		
        
		catch (ClassNotFoundException e)
        {
            System.out.println("Driver class not loaded");
        } 
        
        catch (SQLException e) 
        {
            System.out.println("Connection rejected");
        }
		
    }

}
