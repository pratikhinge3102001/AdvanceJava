package com.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import entities.Emp;

public class Jdbc2_2 {

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		String jdbcurl = "jdbc:mysql://localhost:3306/jdbc";
		Connection con = DriverManager.getConnection(jdbcurl,"root","root");
		System.out.println("Connection established");
		
		
		CallableStatement cs = con.prepareCall("{Call maxsal(?, ?)}");
		
		
		boolean rs = cs.execute("");
		
		
		
		
		
	}

}
