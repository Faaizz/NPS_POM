package Populator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Random;

import Controller.AddInmate;
import Controller.AllotPoints;
import Model.InmateMethods;
import View.MainFrame;

public class Populate {
	
	private static void populateMaleInmates() throws DateTimeException, ClassNotFoundException, SQLException, IOException {
		
		//THIS METHOD GENERATES MALE INMATES AND POPULATES PoM POINTS FOR THEM
		
		Name inmateName= null;
		
		LocalDate dob= null;
		
		int centreID= 0;
		
		int[] possiblePoints= {0, 10, 15};
		
		int life_change= 0;
		
		int behaviour= 0;
		
		int conduct= 0;
		
		int attitude= 0;
		
		int month= 0;
		
		int inmateID= 0;
		
		Random randomGenerator= new Random();
		
		for (int ctrOne= 0; ctrOne < 198; ctrOne ++ ) {
			
			inmateName= new Name(NameMethods.getRandomMaleName());
			
			dob= DateOfBirthMethods.getRandomDateOfBirth();
			
			centreID= randomGenerator.nextInt(3) + 1;
			
			AddInmate.addInmate(centreID, inmateName.getFirstname(), inmateName.getLastname(), inmateName.getSurname(), dob, "Male");

			
			for (int ctrTwo= 0; ctrTwo < 12; ctrTwo ++) {
				
				//LOOP TO ALLOT INMATE POINTS FOR EACH MONTH
				
				inmateID= InmateMethods.getLastInmateID();
				
				//System.out.println("Inmate ID: " + inmateID);
				
				//System.out.println(dob);
				
				month= ctrTwo + 1;
				
				//System.out.println("Month:" + month);
				
				life_change= possiblePoints[randomGenerator.nextInt(3)];
				
				//System.out.println("Life Points: " + life_change);
				
				behaviour= possiblePoints[randomGenerator.nextInt(3)];
				
				conduct= possiblePoints[randomGenerator.nextInt(3)];
				
				attitude= possiblePoints[randomGenerator.nextInt(3)];
				
				AllotPoints.allot(inmateID, centreID, month, life_change, behaviour, conduct, attitude);
				
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		
		
		try {
			
			populateMaleInmates();
			
		} 

		catch (DateTimeException | ClassNotFoundException | SQLException | IOException e) {
			
			e.printStackTrace();
			
		}
		
		
		
	}
	

}
