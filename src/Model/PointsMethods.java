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

public class PointsMethods {
	
	
	public static void allotInmatePoints(int inmateID, int centreID, int month, int life_change, int behaviour, int conduct, int attitude) throws SQLException, ClassNotFoundException, IOException {
		
		Connection aConnection= DriverManager.getConnection(MyMethods.getConnURL());
		
		Statement selectDatabase= aConnection.createStatement();
		
		selectDatabase.executeQuery("USE " + MyMethods.getDatabaseName());
		
		selectDatabase.close();
		
		String column=  MyMethods.getPomColumns()[month-1];
		
		String allotToTable= "UPDATE inmates_points" + " SET " + column + "life_change= ?," + column + "behaviour= ?," + column +  "conduct= ?," + column + "attitude= ? WHERE inmateID= ?";
		
		PreparedStatement aPrepStat= aConnection.prepareStatement(allotToTable);
		
		//System.out.println("Allotted to: " + column);
		
		//System.out.println(life_change + " " + behaviour + " " + conduct + " " + attitude);
		
		aPrepStat.setInt(1, life_change);
		
		aPrepStat.setInt(2, behaviour);
		
		aPrepStat.setInt(3, conduct);
		
		aPrepStat.setInt(4, attitude);
		
		aPrepStat.setInt(5, inmateID);
		
		aPrepStat.execute();
		
		aPrepStat.close();
		
		aConnection.close();
		
		
	}
	
	public static int[][] collectPoints(int inmateID) throws SQLException, ClassNotFoundException, IOException{
		
		int[][] months= new int[12][4];
		
		Connection aConnection= DriverManager.getConnection(MyMethods.getConnURL());
		
		Statement selectDatabase= aConnection.createStatement();
		
		selectDatabase.executeQuery("USE " + MyMethods.getDatabaseName());
		
		selectDatabase.close();
		
		String[] columns= MyMethods.getPomColumns();
			
		String getPointsQuery= "";
		
		PreparedStatement getMonthPoints= null;
		
		ResultSet points= null;
		
		for( int ctrOne= 0; ctrOne<columns.length; ctrOne++) {
			
			String column= columns[ctrOne];
			//System.out.println(column);
			
			getPointsQuery= "SELECT * FROM inmates_points WHERE inmateID= ?";
			
			getMonthPoints= aConnection.prepareStatement(getPointsQuery);
			
			getMonthPoints.setInt(1, inmateID);
			
			//System.out.printf("Checking Month: %s\n\n", column);
			
			points= getMonthPoints.executeQuery();
			
			points.next();
			
			int[] temp= { points.getInt(column + "life_change"), points.getInt(column + "behaviour"), points.getInt(column + "conduct"), points.getInt(column + "attitude")};
			
			//System.out.printf("Obtained: %d %d %d %d\n\n", temp[0], temp[1], temp[2], temp[3]);
			
			months[ctrOne]= temp;
			
			points.close();
			
			getMonthPoints.close();
		}
		
		
		
		//FREE UP RESOURCES
		
		aConnection.close();
		
		return months;
	}
	
	
	public static List<Inmate> publishList() throws SQLException, ClassNotFoundException, IOException{
		
		List<Inmate> theList= new ArrayList<>();
		
		Connection aConnection= DriverManager.getConnection(MyMethods.getConnURL());
		
		Statement selectDatabase= aConnection.createStatement();
		
		selectDatabase.executeQuery("USE " + MyMethods.getDatabaseName());
		
		selectDatabase.close();
		
		Statement getInmate= aConnection.createStatement();
		
		ResultSet inmates= getInmate.executeQuery("SELECT * FROM inmates");
		
		Inmate tempInmate= null;
		
		while(inmates.next()) {
			
			//System.out.println("Checking an Inmate...");
			
			int life_change= 0;
			
			int behaviour= 0;
			
			int conduct= 0;
			
			int attitude= 0;
			
			String[] columns= MyMethods.getPomColumns();
			
			String getPointsQuery= "";
			
			PreparedStatement getPoints= null;
			
			ResultSet points= null;
			
			getPointsQuery= "SELECT * FROM inmates_points WHERE inmateID= ?";
			
			getPoints= aConnection.prepareStatement(getPointsQuery);
			
			getPoints.setInt(1, inmates.getInt("inmateID"));
			
			//System.out.printf("Checking inmateID: %s \nMonth: %s \n\n", inmates.getInt("inmateID"), column);
			
			points= getPoints.executeQuery();
			
			while(points.next()){
				
				for (String column: columns) {
					
			
					life_change+= points.getInt(column + "life_change");
					//System.out.println(life_change);
					
					behaviour+= points.getInt(column + "behaviour");
					
					conduct+= points.getInt(column + "conduct");
					
					attitude+= points.getInt(column + "attitude");
					
				}
				
			}
			
			points.close();
			
			getPoints.close();
			
			
			//VERIFY IF INMATE MEETS CRITERIA THEN ADD TO PUBLISH LIST
			
			if((life_change >= 120)	&&	(behaviour >= 80)	&&	(conduct >= 120)	&&	(attitude >= 80)) {
				
				tempInmate= new Inmate(inmates.getInt("inmateID"), inmates.getInt("centreID"), inmates.getString("firstname"), inmates.getString("lastname"),
						 	inmates.getString("middlename"), inmates.getDate("dob").toLocalDate(),  inmates.getString("gender"), life_change, behaviour,
						 	conduct, attitude);
				
				theList.add(tempInmate);		//add inmate to publish list
				
				//System.out.println("Found One");
			}
			
		}
		
		//FREE UP RESOURCES
		
		inmates.close();
		
		getInmate.close();
		
		aConnection.close();
		
		
		
		return theList;
		
		
	}

}












