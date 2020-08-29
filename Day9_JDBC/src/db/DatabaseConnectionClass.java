package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnectionClass {

	Connection con; // holds connection in between java & database
	PreparedStatement ps; // executes SQL queies

	
	public DatabaseConnectionClass() throws SQLException, ClassNotFoundException {
		String path = "jdbc:oracle:thin:@localhost:1521:XE";
		String username = "user1";
		String password = "user1";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(path, username, password);
		System.out.println(" Connection Establish ----->> " + con);
	}
	
	
	public boolean doInsertCourse()throws SQLException
	{
		String query = "insert into COURSES values('SQL','DBMS',30,1)";
		ps = con.prepareStatement(query);
		int i = ps.executeUpdate();
		if(i >0) return true;
		else return false;
	}
	

	public static void main(String[] args) {

		try {
			DatabaseConnectionClass obj = new DatabaseConnectionClass();
			boolean result = obj.doInsertCourse();
			System.out.println(result);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
