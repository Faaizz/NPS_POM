package Model;

import java.time.LocalDate;

public class Inmate {
	
	private int inmateID= 0;
	
	private int centreID= 0;
	
	private String firstname= "";
	
	private String lastname= "";
	
	private String middlename= "";
	
	private LocalDate dob= null;
	
	private String gender= "";
	
	private int totalPoints= 0;
	
	private int life_changePoints= 0;
	
	private int behaviourPoints= 0;
	
	private int conductPoints= 0;
	
	private int attitudePoints= 0;
	
	
	public Inmate(int centreID, String firstname, String lastname, String middlename, LocalDate dob, String gender) {
		
		/*
		 * This constructor is to initailise an inmate to be added to the database*/
		
		this.centreID= centreID;
		
		this.firstname= firstname;
		
		this.lastname= lastname;
		
		this.middlename= middlename;
		
		this.dob= dob;
		
		this.gender= gender;
		
	}
	
	
	public Inmate(int inmateID, int centreID, String firstname, String lastname, String middlename, LocalDate dob, String gender, int life_changePoints,
					int behaviourPoints, int conductPoints, int attitudePoints) {
		
		/*
		 * This constructor is to capture an already existing inmate from the database
		 * */
		
		this.inmateID= inmateID;
		
		this.centreID= centreID;
		
		this.firstname= firstname;
		
		this.lastname= lastname;
		
		this.middlename= middlename;
		
		this.dob= dob;
		
		this.gender= gender;	
		
		this.life_changePoints= life_changePoints;
		
		this.behaviourPoints= behaviourPoints;
		
		this.conductPoints= conductPoints;
		
		this.attitudePoints= attitudePoints;
		
		this.totalPoints= life_changePoints + behaviourPoints + conductPoints + attitudePoints;
		
	}

	public int getCentreID() {
		
		return centreID;
	}


	public LocalDate getDob() {
		
		return dob;
	}

	public int getInmateID() {
		
		return inmateID;
	}

	public String getFirstname() {
		
		return firstname;
	}

	public String getLastname() {
		
		return lastname;
	}

	public String getMiddlename() {
		
		return middlename;
	}

	public String getGender() {
		
		return gender;
	}
	
	public int getLife_changePoints() {
		
		return life_changePoints;
		
	}
	
	public int getBehaviourPoints() {
		
		return behaviourPoints;
		
	}
	
	public int getConductPoints() {
		
		return conductPoints;
		
	}
	
	public int getAttitudePoints() {
		
		return attitudePoints;
		
	}
	
	public int getTotalPoints() {
		
		return totalPoints;
		
	}
	
	

}






