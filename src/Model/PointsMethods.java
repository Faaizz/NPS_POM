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



		/*	U	P	D	A	T	E 		T	O	T	A	L 		P	O	I	N	T 	S	*/

		int total_life_change= 0;

		int total_behaviour= 0;

		int total_conduct= 0;

		int total_attitude= 0;

		String[] columns= MyMethods.getPomColumns();

		String getPointsQuery= "";

		PreparedStatement getPoints= null;

		ResultSet points= null;

		getPointsQuery= "SELECT * FROM inmates_points WHERE inmateID= ?";

		getPoints= aConnection.prepareStatement(getPointsQuery);

		getPoints.setInt(1, inmateID);

		//System.out.printf("Checking inmateID: %s \nMonth: %s \n\n", inmates.getInt("inmateID"), column);

		points= getPoints.executeQuery();

		while(points.next()){

			for (String aColumn: columns) {


				total_life_change+= points.getInt(aColumn + "life_change");
				//System.out.println(life_change);

				total_behaviour+= points.getInt(aColumn + "behaviour");

				total_conduct+= points.getInt(aColumn + "conduct");

				total_attitude+= points.getInt(aColumn + "attitude");

			}

		}

		points.close();

		getPoints.close();

		String updateTotalPoints= "UPDATE inmates_points" + " SET " + "total_life_change= ?," + "total_behaviour= ?," + "total_conduct= ?," + "total_attitude= ? WHERE inmateID= ?";

		PreparedStatement aPrepStatTwo= aConnection.prepareStatement(updateTotalPoints);

		//System.out.println("Allotted to: " + column);

		//System.out.println(life_change + " " + behaviour + " " + conduct + " " + attitude);

		aPrepStatTwo.setInt(1, total_life_change);

		aPrepStatTwo.setInt(2, total_behaviour);

		aPrepStatTwo.setInt(3, total_conduct);

		aPrepStatTwo.setInt(4, total_attitude);

		aPrepStatTwo.setInt(5, inmateID);

		aPrepStatTwo.execute();

		aPrepStatTwo.close();


		//CLOSE CONNECTION

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
		
		ResultSet inmates= getInmate.executeQuery("SELECT DISTINCT inmates.inmateID, inmates.centreID, inmates.firstname, inmates.lastname, inmates.middlename," +
														" inmates.dob, inmates.gender FROM inmates INNER JOIN inmates_points WHERE total_life_change >= 120 AND total_behaviour >= 120" +
															" AND total_attitude >= 80 AND total_conduct >= 80");
		
		Inmate tempInmate= null;

		while(inmates.next()) {
			//iterate over matched inmates

			Statement getPoints= aConnection.createStatement();

			ResultSet inmatePoints= getPoints.executeQuery("SELECT total_life_change, total_conduct, total_behaviour, total_attitude" +
					" FROM inmates_points WHERE inmateID= " + inmates.getInt("inmateID") );

			inmatePoints.next();	//move cursor to matched row

			//check if inmate meets the total points criteria (400 points)

			int total_life_change= inmatePoints.getInt("total_life_change");
			int total_behaviour= inmatePoints.getInt("total_behaviour");
			int total_conduct= inmatePoints.getInt("total_conduct");
			int total_attitude= inmatePoints.getInt("total_attitude");


			if( (total_life_change + total_behaviour +total_conduct + total_attitude) >= 400 ) {

				tempInmate = new Inmate(inmates.getInt("inmateID"), inmates.getInt("centreID"), inmates.getString("firstname"), inmates.getString("lastname"),
						inmates.getString("middlename"), inmates.getDate("dob").toLocalDate(), inmates.getString("gender"), total_life_change, total_behaviour, total_conduct, total_attitude);

				theList.add(tempInmate);        //add inmate to publish list
			}

			inmatePoints.close();
		}
		
		//FREE UP RESOURCES
		
		inmates.close();
		
		getInmate.close();
		
		aConnection.close();
		
		
		return theList;
		
		
	}

}












