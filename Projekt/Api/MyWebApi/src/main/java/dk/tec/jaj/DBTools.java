package dk.tec.jaj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTools 
{
	Connection con;
	Statement stmt;
	ResultSet result;
	
	String conStr = "jdbc:sqlserver://localhost;databaseName=MyApiDB;encrypt=true;trustServerCertificate=true";
	
	private void connect()
	{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(conStr, "sa", "1234");
			stmt = con.createStatement();
			//System.out.print("Alt gik godt");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public Elev getElevById(int id) 
	{
		connect();
		String sqlStr = "Select * from Elev where id = " + id;
		
		Elev elev = new Elev();
		
		try {
			result = stmt.executeQuery(sqlStr);
			if(result.next())
			{
				elev.setId(result.getInt("Id"));
				elev.setNavn(result.getString("Name"));
				elev.setAlder(result.getInt("Alder"));
				elev.setJob(result.getString("Job"));
			}		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return elev;
	}
}
