package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyMethods {
	
	private Defaults myDefaults= null;
	
	
	public static void setDefaults(Defaults newDefaults) throws IOException {
		
		File defaultsFile= new File("./files/Defaults.def");
		
		FileOutputStream defaultsFileStream= new FileOutputStream(defaultsFile);
		
		ObjectOutputStream defaultsObjectStream= new ObjectOutputStream(defaultsFileStream);
		
		defaultsObjectStream.writeObject(newDefaults);
		
		defaultsObjectStream.close();
		
		defaultsFileStream.close();
		
		
	}
	
	public static Defaults getDefaults() throws IOException, ClassNotFoundException {
		
		File defaultsFile= new File("./files/Defaults.def");
		
		FileInputStream defaultsFileStream= new FileInputStream(defaultsFile);
		
		ObjectInputStream defaultsObjectStream= new ObjectInputStream(defaultsFileStream);
		
		Defaults foundDefaults= (Defaults) defaultsObjectStream.readObject();
		
		defaultsObjectStream.close();
		
		defaultsFileStream.close();
		
		return foundDefaults;
		
	}
	
	public static String getConnURL() throws ClassNotFoundException, IOException {
				
		Defaults myDef= getDefaults();
		
		//"useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" IS TO FIX ERROR "The server time zone value 'WAT' is unrecognized or represents more than one time zone."
		
		return "jdbc:mysql://" + myDef.getServerAddress() + ":" + myDef.getPortNumber() + "/" + myDef.getDatabaseName()
				+ "?user=" + myDef.getUsername() + "&password=" + myDef.getPassword() + "&" 
				+ "useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		
		
		/*
		
		return "jdbc:mysql://localhost:3306/pom";
		
		*/
	
	}
	
	public static String getDatabaseName() {

		try {

			Defaults myDef = getDefaults();

			return myDef.getDatabaseName();
		}
		catch(Exception e){
			return "";
		}
		
	}
	
	public static String[] getPomColumns() {
		
		String[] POMTABLES= {"jan_", "feb_", "mar_", "apr_", "may_", "jun_", "jul_", "aug_", "sep_",
				"oct_", "nov_", "dec_"};
		
		return POMTABLES;

	}
	
	public static byte[] sha2(String inputString) throws NoSuchAlgorithmException {
		/*
		 * This method encrypts an input string with SHA-2 (256 bit) algorithm
		 * */
						
		MessageDigest aDigest= MessageDigest.getInstance("SHA-256");
		
		byte[] resByte= aDigest.digest(inputString.getBytes());
		
		return resByte;
	}

}
