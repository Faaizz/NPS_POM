package Controller;

import java.sql.SQLException;

public class CentreTester {

	public static void main(String[] args) {
				
		/*
		try {
			
			AddCentre.addCentre("Port Harcourt Max", "South-South", "Rivers");
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		try {
			
			ViewCentre aVCT= new ViewCentre();
			
			while(aVCT.moreCentre()) {
				
				aVCT.nextCentre();
				
				System.out.println("ID: " + aVCT.getID());
				
				System.out.println("Name: " + aVCT.getName());
				
				System.out.println("Region: " + aVCT.getRegion());
				
				System.out.println("State: " + aVCT.getState());
				
				System.out.printf("\n\n");
				
			}
			
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
