package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ListIterator;

import Model.CentreMethods;
import Model.Inmate;
import Model.InmateMethods;

public class ViewInmatesByCentre {
	
	private List<Inmate> inmatesList= null;
	
	private ListIterator<Inmate> inmatesIterator= null;
	
	private Inmate currInmate= null;
	
	private String centreName= "";

	public ViewInmatesByCentre(int centreID) throws SQLException, ClassNotFoundException, IOException {
		
		inmatesList= InmateMethods.getInmatesByCentre(centreID);
		
		inmatesIterator= inmatesList.listIterator();
		
		centreName= CentreMethods.getCentreName(centreID);
		
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
	
	public int getPoints() {
		
		return currInmate.getTotalPoints();
	}
	
	public String getCentreName() {
		
		return centreName;
		
	}
}



















