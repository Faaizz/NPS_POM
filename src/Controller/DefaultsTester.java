package Controller;

import java.io.IOException;

import Model.Defaults;
import Model.MyMethods;

public class DefaultsTester {

	public static void main(String[] args) {

		/*
		Defaults myDef= new Defaults("localhost", "pom", 3306, "root", "password");
		
		try {
			
			DefaultsController.setDefaults(myDef);
			
		} 
		
		catch (IOException e) {
			
			
			e.printStackTrace();
		}
		*/
		
		/*
		try {
			
			Defaults myDefaults= DefaultsController.getDefaults();
			
			System.out.println("Server Address: " + myDefaults.getServerAddress());
			
			System.out.println("Database Name: " + myDefaults.getDatabaseName());
			
			System.out.println("Port Number: " + myDefaults.getPortNumber());
			
			System.out.println("Username: " +  myDefaults.getUsername());
			
			System.out.println("Password: " + myDefaults.getPassword());
			
		} 
		
		catch (ClassNotFoundException | IOException e) {
			
			e.printStackTrace();
		}
		*/
		
		try {
			
			System.out.println(MyMethods.getConnURL());
			
		} 
		
		catch (ClassNotFoundException | IOException e) {
			
			e.printStackTrace();
		}

	}

}
