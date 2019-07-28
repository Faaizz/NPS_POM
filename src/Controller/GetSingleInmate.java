package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import Model.Inmate;
import Model.InmateMethods;

public class GetSingleInmate {
	
	private Inmate thisInmate= null;
	
	public GetSingleInmate(int inmateID, int centreID) throws SQLException, ClassNotFoundException, IOException {
		
		thisInmate= InmateMethods.getInmateByID(inmateID, centreID);
		
	}
	
	public int getInmateID() {
		
		return thisInmate.getInmateID();
		
	}
	
	public int getCentreID() {
		
		return thisInmate.getCentreID();
		
	}
	
	public String getName() {
		
		StringBuilder inmateName= new StringBuilder();
		
		inmateName.append(thisInmate.getLastname());
		
		inmateName.append(" ");
		
		inmateName.append(thisInmate.getMiddlename());
		
		inmateName.append(" ");
		
		inmateName.append(thisInmate.getFirstname());
		
		return inmateName.toString();
	}
	
	public LocalDate getDob() {
		
		return thisInmate.getDob();
		
	}
	
	public String getGender() {
		
		return thisInmate.getGender();
		
	}
	
	public int getPoints() {
		
		return thisInmate.getTotalPoints();
	}

}




















