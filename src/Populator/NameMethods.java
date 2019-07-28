package Populator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class NameMethods {
	
	//METHOD THAT OBTAINS 1000 NAMES FROM THE ARGUMENT SOURCE FILE
	
	private static String[] getNames( File sourceFile) throws FileNotFoundException {
		
		Scanner nameScanner= new Scanner(sourceFile);
		
		String[] namesArray= new String[1000];
		
		for(int ctrOne= 0; ctrOne < 1000; ctrOne++) {
			
			/* BECAUSE THE .TXT FILE IS OF THE FORMAT 
			 * "SHEILA         0.175 47.648    124"
			 * WE GET EACH LINE FROM THE SCANNER, THEN SPLIT THE LINE OF TEXT ON THE 1ST WHITESPACE, 
			 * AND SELECT THE FIRST ELEMENT OF THE RESULTING STRING[], THEREBY EXTRACTING ONLY THE NAME
			 */
			
			namesArray[ctrOne]= nameScanner.nextLine().split(" ")[0];
			
		}
		
		nameScanner.close();
		
		return namesArray;
		
	}
	
	
	//STATIC METHOD THAT RETURNS A STRING ARRAY OF 1000 MALE NAMES BY CALLING getNames()
	
	public static String[] getMaleNames() throws FileNotFoundException {
		
		//FILE THAT CONTAINS MALE NAMES		
		File maleNames= new File("./maleNames.txt");
		
		return getNames(maleNames);
		
	}
	
	
	//STATIC METHOD THAT RETURNS A RANDOM MALE NAME
	
	public static String[] getRandomMaleName() throws FileNotFoundException {
		
		Random randomNumbers= new Random();
		
		//AN ARRAY OF NAMES WITH FIRSTNAME= randomName[0], MIDDLENAME=  randomName[1], AND SURNAME= randomName[2]		
		String[] randomName= new String[3];
		
		//FIRSTNAME
		//randomNumbers.nextInt(1000) GENERATES  ARANDOM NUMBER THAT IS GREATER THAN ZERO BUT LESS THAN 1000
		randomName[0]= getMaleNames()[randomNumbers.nextInt(1000)];
		
		//MIDDLENAME
		randomName[1]= getMaleNames()[randomNumbers.nextInt(1000)];
		
		//SURNAME
		randomName[2]= getMaleNames()[randomNumbers.nextInt(1000)];
		
		
		return randomName;
		
	}
	
	
	//STATIC METHOD THAT RETURNS A STRING ARRAY OF 1000 MALE NAMES BY CALLING getNames()
	
	public static String[] getFemaleNames() throws FileNotFoundException {
		
		//FILE THAT CONTAINS MALE NAMES		
		File femaleNames= new File("./femaleNames.txt");
		
		return getNames(femaleNames);
		
	}
	
	
	//STATIC METHOD THAT RETURNS A RANDOM FEMALE NAME
	
	public static String[] getRandomFemaleName() throws FileNotFoundException {
		
		Random randomNumbers= new Random();
		
		//AN ARRAY OF NAMES WITH FIRSTNAME= randomName[0], MIDDLENAME=  randomName[1], AND SURNAME= randomName[2]		
		String[] randomName= new String[3];
		
		//FIRSTNAME
		//randomNumbers.nextInt(1000) GENERATES  ARANDOM NUMBER THAT IS GREATER THAN ZERO BUT LESS THAN 1000
		randomName[0]= getFemaleNames()[randomNumbers.nextInt(1000)];
		
		//MIDDLENAME
		randomName[1]= getFemaleNames()[randomNumbers.nextInt(1000)];
		
		//SURNAME. A FELAME'S SURNAME IS A MALE NAME, THUS getMaleNames() IS CALLED
		randomName[2]= getMaleNames()[randomNumbers.nextInt(1000)];
		
		
		return randomName;
		
	}
		
	
	
	public static void main(String[] args) {

		
		
		try {
			
			
			Name newName= new Name(getRandomMaleName());
			
			System.out.println(newName.getFirstname());
			System.out.println(newName.getLastname());
			System.out.println(newName.getSurname());
			
			System.out.println(DateOfBirthMethods.getRandomDateOfBirth());

			
		} 
		
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		
	}

}