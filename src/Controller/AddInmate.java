package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;

import Model.Inmate;
import Model.InmateMethods;

public class AddInmate {
	
	public static void addInmate(int centreID, String firstname, String lastname, String middlename, int day, int month, int year, String gender)  throws DateTimeException, SQLException, ClassNotFoundException, IOException{
		
		LocalDate thisDate= LocalDate.of(year, month, day);		//This method throws a DateTime exception if invalid values are put in for dd-mm-yyyy
		
		Inmate tempInmate= new Inmate(centreID, firstname, lastname, middlename, thisDate, gender);
		
		InmateMethods.addInmate(tempInmate);
	}
	
	
	//OVERLOADED VERSION THAT TAKES DATE AS LocalDate OBJECT
	
	public static void addInmate(int centreID, String firstname, String lastname, String middlename, LocalDate thisDate, String gender)  throws DateTimeException, SQLException, ClassNotFoundException, IOException{
			
		Inmate tempInmate= new Inmate(centreID, firstname, lastname, middlename, thisDate, gender);
		
		InmateMethods.addInmate(tempInmate);
	}

}
