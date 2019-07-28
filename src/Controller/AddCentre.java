package Controller;

import java.io.IOException;
import java.sql.SQLException;

import Model.Centre;
import Model.CentreMethods;

public class AddCentre {
	
	
	public static void addCentre(String name, String region, String state) throws SQLException, ClassNotFoundException, IOException {
		
		Centre aCentre= aCentre= new Centre(name, region, state);
		
		CentreMethods.addCentre(aCentre);
	}

}
