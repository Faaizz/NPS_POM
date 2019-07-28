package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import Model.Inmate;
import Model.InmateMethods;
import Model.PointsMethods;

public class InmatePoints {
	
	private Inmate currInmate= null;
	
	private int[][] pointsByMonth= null;
	
	private String month= "";
	
	private String category= "";
	
	private int singlePoint= 0;
	
	public InmatePoints(int inmateID, int centreID) throws SQLException, ClassNotFoundException, IOException {
		
		currInmate= InmateMethods.getInmateByID(inmateID, centreID);
		
		pointsByMonth= PointsMethods.collectPoints(inmateID);
	}
	
	public int[][] getAllPoints(){
		
		return pointsByMonth;
		
	}
	
	public int getInmateID() {
		
		return currInmate.getInmateID();
		
	}
	
	public int getCentreID() {
		
		return currInmate.getCentreID();
		
	}
	
	public String getName() {
		
		StringBuilder inmateName= new StringBuilder();
		
		inmateName.append(currInmate.getLastname());
		
		inmateName.append(" ");
		
		inmateName.append(currInmate.getMiddlename());
		
		inmateName.append(" ");
		
		inmateName.append(currInmate.getFirstname());
		
		return inmateName.toString();
	}
	
	public LocalDate getDob() {
		
		return currInmate.getDob();
		
	}
	
	public String getGender() {
		
		return currInmate.getGender();
		
	}
	
	public int getLife_changePoints() {
		
		return currInmate.getLife_changePoints();
		
	}
	
	public int getBehaviourPoints() {
		
		return currInmate.getBehaviourPoints();
		
	}
	
	public int getConductPoints() {
		
		return currInmate.getConductPoints();
		
	}
	
	public int getAttitudePoints() {
		
		return currInmate.getAttitudePoints();
		
	}
	
	public int getTotalPoints() {
		
		return currInmate.getTotalPoints();
		
	}
	
	public void byMonth(int month, int category) {
		
		/*THIS METHOD RETURNS POINTS MY MONTH AND CATEGORY.
		 * IT SETS THE OBJECTS "month", "category" AND "point" INSTANCE VARIABLES TO ALLOW GETTERS RETURN APPROPRIATE VALUES*/
		
		switch(month) {
			case 1: this.month= "January";
					break;
					
			case 2: this.month= "February";
					break;
			
			case 3: this.month= "March";
					break;
			
			case 4: this.month= "April";
					break;
			
			case 5: this.month= "May";
					break;
			
			case 6: this.month= "June";
					break;
					
			case 7: this.month= "July";
					break;
			
			case 8: this.month= "August";
					break;
			
			case 9: this.month= "September";
					break;
			
			case 10: this.month= "October";
					break;
			
			case 11: this.month= "November";
					break;
			
			case 12: this.month= "December";
					break;
					
			default: this.month= "";
		}
		
		switch(category) {
		
		case 1: this.category= "Changes from old life";
				break;
				
		case 2: this.category= "Good Behaviour";
				break;
				
		case 3: this.category= "Conduct";
				break;
				
		case 4: this.category= "Attitude towards work";
				break;
		
		default: this.category= "";
		}
		
		//SET POINT
		
		//offsets month and category indices by 1 such that 1 is the first index position not 0.
		
		this.singlePoint= pointsByMonth[month-1][category-1];
	}
	
	public String getCategory() {
		
		return this.category;
		
	}
	
	public String getMonth() {
		
		return this.month;
		
	}
	
	public int getSinglePoint() {
		
		return this.singlePoint;
		
	}
	

}











