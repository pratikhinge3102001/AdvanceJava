package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcurl = "jdbc:mysql://localhost:3306/Pune";

            Connection conn = DriverManager.getConnection(jdbcurl, "root", "root");
            System.out.println("Connection Established");

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
