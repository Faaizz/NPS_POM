package Controller;

import java.io.IOException;
import java.sql.SQLException;

import Model.PointsMethods;

public class AllotPoints {
	
	public static void allot(int inmateID, int centreID, int month, int life_change, int behaviour, int conduct, int attitude) throws SQLException, ClassNotFoundException, IOException {
		
		PointsMethods.allotInmatePoints(inmateID, centreID, month, life_change, behaviour, conduct, attitude);
	}

}
