package Model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InmateMethods {

	
	private final static String POM= "USE " + MyMethods.getDatabaseName();
	
	
	
	private final static String ADDINMATE= "INSERT INTO inmates VALUES(null, ?, ?, ?, ?, ?, ?)";
	
	private final static String[] POMCOLUMNS= MyMethods.getPomColumns();
	
	
	public static void addInmate(Inmate aInmate) throws SQLException, ClassNotFoundException, IOException {
		
		Connection aConnection= DriverManager.getConnection(MyMethods.getConnURL());
		
		aConnection.setAutoCommit(false);			//ENTER TRANSACTION MODE, SET AUTOCOMMIT TO FALSE
		
		Statement selectDatabase= aConnection.createStatement();
		
		selectDatabase.executeQuery(POM);
		
		PreparedStatement aPrepStat= aConnection.prepareStatement(ADDINMATE);
		
		aPrepStat.setInt(1, aInmate.getCentreID());
		
		aPrepStat.setString(2, aInmate.getFirstname());
		
		aPrepStat.setString(3, aInmate.getLastname());
		
		aPrepStat.setString(4, aInmate.getMiddlename());
		
		java.sql.Date sqlDob= java.sql.Date.valueOf(aInmate.getDob());
		
		aPrepStat.setDate(5, sqlDob);
		
		aPrepStat.setString(6, aInmate.getGender());
		
		aPrepStat.execute();
		
		aPrepStat.close();
		
		
		//ADD INMATE ID TO POM TABLES AND INITIALISE POINTS TO ZERO
		
		Statement getLastInmate= aConnection.createStatement();
		
		ResultSet lastInmate= getLastInmate.executeQuery("SELECT inmateID FROM inmates");
		
		int lastInmateID= 0;
		
		int tempInt= 0;
		
		while(lastInmate.next()) {
			
			tempInt= lastInmate.getInt("inmateID");
		
			if (tempInt > lastInmateID) {
				
				lastInmateID= tempInt;
		
			}
			
		}
		
		lastInmate.close();
		
		getLastInmate.close();
		
		StringBuilder pointsZeroValues= new StringBuilder();
		
		for(int ctrOne= 0; ctrOne < 51; ctrOne++) {
			
			pointsZeroValues.append(" 0,");
			
		}
			
		aPrepStat= aConnection.prepareStatement("INSERT INTO inmates_points VALUES( ?, " + 
				
				pointsZeroValues + "0 )");
		
		//System.out.println("table name: " + temp);
		
		//System.out.println("inmate ID: " + lastInmateID);
		
		//System.out.println("centre ID: " + aInmate.getCentreID());
		
		aPrepStat.setInt(1, lastInmateID);
		
		aPrepStat.execute();
		
		aPrepStat.close();
		
		
		//COMMIT CHANGES
		
		aConnection.commit();
		
		
		//FREE UP RESOURCES
		
		selectDatabase.close();
		
		//aPrepStat.close();
		
		aConnection.close();
		
		
	}
	
	
	private final static String SELECTINMATE= "SELECT * FROM inmates WHERE inmateID= ? AND centreID= ?";
	
	
	public static Inmate getInmateByID(int inmateID, int centreID) throws SQLException, ClassNotFoundException, IOException {
		
		Connection aConnection= DriverManager.getConnection(MyMethods.getConnURL());
		
		aConnection.setAutoCommit(false);			//ENTER TRANSACTION MODE, SET AUTOCOMMIT TO FALSE
		
		Statement selectDatabase= aConnection.createStatement();
		
		selectDatabase.executeQuery(POM);
		
		PreparedStatement selectInmate= aConnection.prepareStatement(SELECTINMATE);
		
		selectInmate.setInt(1, inmateID);
		
		selectInmate.setInt(2, centreID);
		
		ResultSet selectResult= selectInmate.executeQuery();
		
		selectResult.next();
		
		LocalDate localDOB= selectResult.getDate("dob").toLocalDate();
		
		int aInmateID= selectResult.getInt("inmateID");
		
		int aCentreID= selectResult.getInt("centreID");
		
		String aFirstname= selectResult.getString("firstname");
		
		String aLastname= selectResult.getString("lastname");
		
		String aMiddlename= selectResult.getString("middlename");
		
		String aGender= selectResult.getString("gender");
		
		
		//OBTAIN POM POINTS
		
		int life_change= 0;
		
		int behaviour= 0;
		
		int conduct= 0;
		
		int attitude= 0;

		
		PreparedStatement getPoints= null;
		
		ResultSet points= null;
			
		String pointsQuery= "SELECT * FROM inmates_points WHERE inmateID= ?";
		
		getPoints= aConnection.prepareStatement(pointsQuery);
		
		getPoints.setInt(1, aInmateID);
		
		points= getPoints.executeQuery();
		
		points.next();
		
		for(String column : POMCOLUMNS) {
		
			life_change+= points.getInt(column + "life_change");
			
			behaviour+= points.getInt(column + "behaviour");
			
			conduct+= points.getInt(column + "conduct");
			
			attitude+= points.getInt(column + "attitude");
			
		}
		
		getPoints.close();
		
				
		Inmate selectedInmate= new Inmate(aInmateID, aCentreID, aFirstname, aLastname, aMiddlename, localDOB, aGender, life_change, behaviour, conduct,
											attitude);
		
		//COMMIT CHANGES
		
		aConnection.commit();
		
		//FREE UP RESOURCES
		
		selectDatabase.close();
		
		selectResult.close();
		
		aConnection.close();
		
		
		return selectedInmate;
		
	
	}
	
	
	private final static String VIEWINMATESBYCENTRE= "SELECT * FROM inmates WHERE centreID= ?";
	
	public static List<Inmate> getInmatesByCentre(int centreID) throws SQLException, ClassNotFoundException, IOException{
		
		Connection aConnection= DriverManager.getConnection(MyMethods.getConnURL());
		
		aConnection.setAutoCommit(false);			//ENTER TRANSACTION MODE, SET AUTOCOMMIT TO FALSE
		
		Statement selectDatabase= aConnection.createStatement();
		
		selectDatabase.executeQuery(POM);
		
		PreparedStatement selectInmates= aConnection.prepareStatement(VIEWINMATESBYCENTRE);
		
		selectInmates.setInt(1, centreID);
		
		ResultSet selectedInmates= selectInmates.executeQuery();
		
		Inmate tempInmate= null;
		
		List<Inmate> inmatesList= new ArrayList<>();
		
		while(selectedInmates.next()) {
			
			LocalDate localDOB= selectedInmates.getDate("dob").toLocalDate();
			
			int aInmateID= selectedInmates.getInt("inmateID");
			
			int aCentreID= selectedInmates.getInt("centreID");
			
			String aFirstname= selectedInmates.getString("firstname");
			
			String aLastname= selectedInmates.getString("lastname");
			
			String aMiddlename= selectedInmates.getString("middlename");
			
			String aGender= selectedInmates.getString("gender");
			
			
			//OBTAIN POM POINTS
			
			int life_change= 0;
			
			int behaviour= 0;
			
			int conduct= 0;
			
			int attitude= 0;
			
			PreparedStatement getPoints= null;
			
			ResultSet points= null;

			String pointsQuery= "SELECT * FROM inmates_points WHERE inmateID= ?";

			getPoints= aConnection.prepareStatement(pointsQuery);

			getPoints.setInt(1, aInmateID);

			points= getPoints.executeQuery();

			while(points.next()) {

				life_change+= points.getInt("total_life_change");

				behaviour+= points.getInt("total_behaviour");

				conduct+= points.getInt("total_conduct");

				attitude+= points.getInt("total_attitude");
			}

			getPoints.close();
					
			tempInmate= new Inmate(aInmateID, aCentreID, aFirstname, aLastname, aMiddlename, localDOB, aGender, life_change, behaviour, conduct,
												attitude);
			
			inmatesList.add(tempInmate);
			
		}
		
		//COMMIT CHANGES
		
		aConnection.commit();
		
		//FREE UP RESOURCES
		
		selectDatabase.close();
		
		selectedInmates.close();
		
		aConnection.close();
		
		
		return inmatesList;
	}
	
	private final static String SELECTINMATEID= "SELECT * FROM inmates";
	
	public static int getLastInmateID() throws SQLException, ClassNotFoundException, IOException {
		
		Connection aConnection= DriverManager.getConnection(MyMethods.getConnURL());
		
		Statement aStat= aConnection.createStatement();
		
		ResultSet aResSet= aStat.executeQuery(SELECTINMATEID);
		
		int lastInmateID= 0;
		
		while(aResSet.next()) {
			
			if(aResSet.getInt("inmateID") > lastInmateID)
				lastInmateID= aResSet.getInt("inmateID");
		}
		
		aStat.close();
		
		aConnection.close();
		
		return lastInmateID;
		
	}

}







