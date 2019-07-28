package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ListIterator;

import Model.Inmate;
import Model.PointsMethods;

public class PardonList {
	
	private List<Inmate> inmatesList= null;
	
	private ListIterator<Inmate> inmatesIterator= null;
	
	private Inmate currInmate= null;

	
	public PardonList() throws SQLException, ClassNotFoundException, IOException {
		
		inmatesList= PointsMethods.publishList();
		
		inmatesIterator= inmatesList.listIterator();
		
	}
	
	public List<Inmate> getList(){
		
		return inmatesList;
	}
	
	public boolean moreInmates() {
		
		return inmatesIterator.hasNext();
	}
	
	public void nextInmate() {
		
		currInmate= inmatesIterator.next();
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
	
	public int getPoints() {
		
		return currInmate.getTotalPoints();
		
	}

}
















