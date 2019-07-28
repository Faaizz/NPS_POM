package Model;

import java.io.Serializable;

public class Defaults implements Serializable{
	
	private String serverAddress;
	
	private String databaseName;
	
	private int portNumber;
	
	private String username;
	
	private String password;
	
	
	public Defaults(String serverAddress, String databaseName, int portNumber, String username, String password) {
		
		this.serverAddress= serverAddress;
		
		this.databaseName= databaseName;
		
		this.portNumber= portNumber;
		
		this.username= username;
		
		this.password= password;
		
	}
	
	public String getServerAddress() {
		
		return serverAddress;
		
	}
	
	public String getDatabaseName() {
		
		return databaseName;
		
	}
	
	public int getPortNumber() {
		
		return portNumber;
		
	}
	
	public String getUsername() {
		
		return username;
		
	}
	
	public String getPassword() {
		
		return password;
		
	}

}
