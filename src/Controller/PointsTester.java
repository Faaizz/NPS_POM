package Controller;

import java.sql.SQLException;

public class PointsTester {

	public static void main(String[] args) {
		
		/*
		
		try {
			
			AllotPoints.allot(7, 1, 7, 15, 15, 15, 15);
			
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		*/
		
		
		/*
		try {
			
			PardonList newList= new PardonList();
			
			if(newList.moreInmates()) {
				
				newList.nextInmate();
				
				System.out.println("Inmate ID: " + newList.getInmateID());
				
				System.out.println("Centre ID: " + newList.getCentreID());
				
				System.out.println("Name: " + newList.getName());
				
				System.out.println("DOB: " + newList.getDob());
				
				System.out.println("Gender: " + newList.getGender());
				
				System.out.println("Changes from old life: " + newList.getLife_changePoints());
				
				System.out.println("Behaviour: " + newList.getBehaviourPoints());
				
				System.out.println("Conduct: " + newList.getConductPoints());
				
				System.out.println("Attitude: " + newList.getAttitudePoints());
				
				System.out.println("Points: " + newList.getPoints());
			}
			
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		*/
		
		try {
			
			InmatePoints aIM= new InmatePoints(7, 1);
			
			System.out.println("Inmate ID: " + aIM.getInmateID());
			
			System.out.println("Centre ID: " + aIM.getCentreID());
			
			System.out.println("Name: " + aIM.getName());
			
			System.out.println("DOB: " + aIM.getDob());
			
			System.out.println("Gender: " + aIM.getGender());
			
			System.out.printf("\n\n\n");
			
			for(int ctrOne= 1; ctrOne <= 12; ctrOne++) {
				
				for(int ctrTwo= 1; ctrTwo <= 4; ctrTwo++) {
					
					aIM.byMonth(ctrOne, ctrTwo);
					
					System.out.println(aIM.getCategory() + ": " + aIM.getSinglePoint());
				}
				
				System.out.printf("%s\n\n\n", aIM.getMonth());
			}
			
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}








