package Populator;

import java.time.LocalDate;
import java.util.Random;

public class DateOfBirthMethods {
	
	public static LocalDate getRandomDateOfBirth() {
		
		int dayOfMonth= 0;
		
		int monthOfYear= 0;
		
		int year= 0;
		
		Random randomNumber= new Random();
		
		//	Y	E	A	R
		
		while(true) {
			
			//FOREVER LOOP
			
			//SETS THE MIMIMUM AGE TO 18
			year= randomNumber.nextInt(2000);
				
			if (year > 1958) {
				
				//IF GENERATED YEAR OF BIRTH IS LATER THAN 1958, TERMINATE THE LOOP
				
				break;
				
			}
			
		}
		
		//	M	O	N	T	H
		
		monthOfYear= (randomNumber.nextInt(12) + 1);		//GENERATES RANDOM NUMBERS FROM 0 TO 12, 1 IS ADDED TO OFFSET TO 1

		
		//FEBRUARY
		
		if ((monthOfYear == 2)) {
				
			//	D	A	Y
			dayOfMonth= randomNumber.nextInt(27) + 1;
			
		}
		
		
		//30 DAY MONTHS- SEPTEMBER, APRIL, JUNE, AND NOVEMBER
		
		else if ((monthOfYear == 9) || (monthOfYear == 4) || (monthOfYear == 6) || (monthOfYear == 11)) {
				
			//	D	A	Y
			dayOfMonth= randomNumber.nextInt(29) + 1;
			
		}
		
		
		//31 DAY MONTHS
		
		else {
				
			//	D	A	Y
			dayOfMonth= randomNumber.nextInt(30) + 1;
			
		}
		
		
		return LocalDate.of(year, monthOfYear, dayOfMonth);
		
	}
	

}