package Controller;

import java.io.IOException;

import Model.Defaults;
import Model.MyMethods;

public class DefaultsController {
	
	public static void setDefaults(Defaults aDefault) throws IOException {
		
		MyMethods.setDefaults(aDefault);
		
	}
	
	public static Defaults getDefaults() throws ClassNotFoundException, IOException {
		
		return MyMethods.getDefaults();
		
	}

}
