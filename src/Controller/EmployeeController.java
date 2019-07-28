package Controller;

import java.io.IOException;
import java.sql.SQLException;

import Model.EmployeeLogin;

public class EmployeeController {
	
	private EmployeeLogin anEmp;
	
	private int employeeID= 0;
	
	
	public EmployeeController(int employeeID, String password) throws SQLException, ClassNotFoundException, IOException {
		
		anEmp= new EmployeeLogin(employeeID, password);
		
		this.employeeID= anEmp.getEmployeeID();
		
	}
	
	
	public int getEmployeeID() {
		
		return this.employeeID;
		
	}

}
