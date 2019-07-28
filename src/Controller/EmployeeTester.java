package Controller;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		Scanner aScan= new Scanner(System.in);

		System.out.println("Password: ");
		String passStr= aScan.nextLine();
		
		System.out.println("EmployeeID: ");
		int employeeID= aScan.nextInt();
		
		try {
			EmployeeController aEL= new EmployeeController(employeeID, passStr);
			
			System.out.printf("ID: %s\nCentre: %s", aEL.getEmployeeID());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
