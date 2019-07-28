package Controller;

import java.sql.SQLException;

public class InmatesTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		try {
			
			AddInmate.addInmate(2, "Nina", "Low", "Pope", 13, 9, 1992, "female");
			
		} 
		
		catch (DateTimeException e) {
			
			e.printStackTrace();
			
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		*/
		
		/*
		
		try {
			
			GetSingleInmate inOne= new GetSingleInmate(7, 1);
			
			System.out.println("Inmate ID: " + inOne.getInmateID());
			
			System.out.println("Centre ID: " + inOne.getCentreID());
			
			System.out.println("Name: " + inOne.getName());
			
			System.out.println("DOB: " + inOne.getDob());
			
			System.out.println("Gender: " + inOne.getGender());
			
			System.out.println("Points: " + inOne.getPoints());
			
		} 
		
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		*/

		
		
		
		try {
			
			ViewInmatesByCentre myIV= new ViewInmatesByCentre(2);
			
			if(myIV.moreInmates()) {
				
				myIV.nextInmate();
				
				System.out.println("Inmate ID: " + myIV.getInmateID());
				
				System.out.println("Centre ID: " + myIV.getCentreID());
				
				System.out.println("Name: " + myIV.getName());
				
				System.out.println("DOB: " + myIV.getDob());
				
				System.out.println("Gender: " + myIV.getGender());
				
				System.out.println("Points: " + myIV.getPoints());
				
				System.out.printf("\n\n");
			}
			
		} 
		
		catch (Exception e) {
			
			
			e.printStackTrace();
		}
		
		
		
		

	}

}
