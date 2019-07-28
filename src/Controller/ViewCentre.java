package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;

import Model.Centre;
import Model.CentreMethods;


public class ViewCentre {
	
	private ListIterator<Centre> anIterator= null;
	
	private List<Centre> aCenList= null;
	
	private Centre currCentre= null;
	
	
	public ViewCentre() throws SQLException, ClassNotFoundException, IOException {
		
		aCenList= CentreMethods.viewCentre();
		
		anIterator= aCenList.listIterator();
		
	}
	
	public List<Centre> getList(){

		//This method returns the entire list
		
		return aCenList;
		
	}
	
	public void nextCentre(){
		
		currCentre= anIterator.next();
		
	}
	
	public boolean moreCentre() {
		
		return anIterator.hasNext();
	}
	
	public int getID() {
		
		return currCentre.getID();
		
	}
	
	public String getName() {
		
		return currCentre.getName();
		
	}
	
	public String getRegion() {
		
		return currCentre.getRegion();
		
	}
	
	public String getState() {
		
		return currCentre.getState();
	}

}













