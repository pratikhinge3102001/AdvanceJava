package apps;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	public static void main(String[] args) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbcurl = "jdbc:mysql://localhost:3306/jdbc";
			Connection con = DriverManager.getConnection(jdbcurl, "root", "root");
			System.out.println("Conn established");
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
