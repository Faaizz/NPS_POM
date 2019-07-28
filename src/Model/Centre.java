package Model;

public class Centre {
	
	private int centreID= 0;
	
	private String name= "";
	
	private String region= "";
	
	private String state= "";
	
	
	public Centre(String name, String region, String state) {
		
		/*
		 * This constructor is to initailise a centre to be added to the database
		 * */
		
		this.name= name;
		
		this.region= region;
		
		this.state= state;
	}
	
	
	public Centre(int centreID, String name, String region, String state) {
		/*
		 * This constructor is to capture an already existing centre from the database
		 * */
		
		this.centreID= centreID;
		
		this.name= name;
		
		this.region= region;
		
		this.state= state;
	}
	
	
	public int getID() {
		
		return this.centreID;
	
	}
	
	
	public String getName() {
		
		return this.name;
		
	}
	
	
	public String getRegion() {
		
		return this.region;
		
	}
	
	
	public String getState() {
		
		return this.state;
		
	}
	

}





















