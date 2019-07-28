package Model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeLogin {
	

	private static String POM= "USE " + MyMethods.getDatabaseName();
	
	private static String LOGIN= "SELECT * FROM employeeLogin WHERE employeeID= ? AND password= ?";
		
	private int employeeID= 0;
	
	
	public EmployeeLogin(int employeeID, String password) throws SQLException, ClassNotFoundException, IOException {
		
		Connection aConnection= DriverManager.getConnection(MyMethods.getConnURL());
		
		Statement selectDatabase= aConnection.createStatement();
		
		selectDatabase.execute(POM);
		
		PreparedStatement aPreparedStatement= aConnection.prepareStatement(LOGIN);
		
		aPreparedStatement.setInt(1, employeeID);
		
		aPreparedStatement.setString(2, password);
		
		ResultSet aResultSet= aPreparedStatement.executeQuery();
		
		aResultSet.next();
		
		this.employeeID= aResultSet.getInt("employeeID");
		
		
		//FREE	UP	RESOURCES
		
		aPreparedStatement.close();
		
		selectDatabase.close();
		
		aConnection.close();
		
	}
	
	
	public int getEmployeeID() {
		
		return employeeID;
	}

}
