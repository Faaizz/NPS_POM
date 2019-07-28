package Populator;

public class Name {
	
	private String firstname= null;
	
	private String lastname= null;
	
	private String surname= null;
	
	
	/*	C	O	N	S	T	R	U	C	T	O	R	*/
	
	public Name(String[] name) {
		
		//name IS EXPECTED TO BE A String[] WITH FIRSTNAME AT [0], MIDDLENAME AT [1] AND SURNAME AT [2]
		
		this.firstname= name[0];
		
		this.lastname= name[1];
		
		this.surname= name[2];
		
	}


	public String getFirstname() {
		
		return firstname;
		
	}


	public String getLastname() {
		
		return lastname;
		
	}


	public String getSurname() {
		
		return surname;
		
	}
	

}