package Model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CentreMethods {
	/*
	 * The purpose of this class is to manage Centre objects
	 * 
	 * */
	
	private static String POM= "USE " + MyMethods.getDatabaseName();
	
	private static String ADDCENTRE= "INSERT INTO centre VALUES(null, ?, ?, ?)"; 
	
	private static String VIEWCENTRE= "SELECT * FROM centre";
	
	
	public static void addCentre(Centre aCentre) throws SQLException, ClassNotFoundException, IOException {
		
		/*
		 * Connects to database and inserts a new centre
		 * */
		
		Connection aConnection= DriverManager.getConnection(MyMethods.getConnURL());
		
		PreparedStatement aPrepStat= aConnection.prepareStatement(ADDCENTRE);
		
		aPrepStat.setString(1, aCentre.getName());
		
		aPrepStat.setString(2, aCentre.getRegion());
		
		aPrepStat.setString(3, aCentre.getState());
		
		aPrepStat.execute();
		
		
		
		//FREE	UP	RESOURCES
		
		aPrepStat.close();
		
		aConnection.close();
		
	}
	
	
	public static List<Centre> viewCentre() throws SQLException, ClassNotFoundException, IOException {
		
		Connection aConnection= DriverManager.getConnection(MyMethods.getConnURL());
		
		Statement aStat= aConnection.createStatement();
		
		ResultSet aResSet= aStat.executeQuery(VIEWCENTRE);
		
		List<Centre> centreList= new ArrayList<>();
		
		while(aResSet.next()) {
			
			int centreID= aResSet.getInt("centreID");
			
			String name= aResSet.getString("name");
			
			String region= aResSet.getString("region");
			
			String state= aResSet.getString("state");
			
			Centre tempCentre= new Centre(centreID, name, region, state);
			
			centreList.add(tempCentre);
		}
		
		aStat.close();
		
		aConnection.close();
		
		return centreList;
	}
	
	public static int getLastCentreID() throws SQLException, ClassNotFoundException, IOException {
		
		Connection aConnection= DriverManager.getConnection(MyMethods.getConnURL());
		
		Statement aStat= aConnection.createStatement();
		
		ResultSet aResSet= aStat.executeQuery(VIEWCENTRE);
		
		int lastCentreID= 0;
		
		while(aResSet.next()) {
			
			if(aResSet.getInt("centreID") > lastCentreID)
				lastCentreID= aResSet.getInt("centreID");
		}
		
		aStat.close();
		
		aConnection.close();
		
		return lastCentreID;
		
	}
	
	
	public static String getCentreName(int centreID) throws SQLException, ClassNotFoundException, IOException {
		
		Connection aConnection= DriverManager.getConnection(MyMethods.getConnURL());
		
		String centreNameQuery= "SELECT * FROM centre WHERE centreID= ?";
		
		PreparedStatement aPrepStat= aConnection.prepareStatement(centreNameQuery);
		
		aPrepStat.setInt(1, centreID);
		
		ResultSet aResSet= aPrepStat.executeQuery();
		
		String name= null;
		
		while(aResSet.next()) {
			
			name= aResSet.getString("name");
		}
		
		aPrepStat.close();
		
		aConnection.close();
		
		return name;
	}

}














