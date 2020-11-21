package business;

import processes.RandomString;

public class Employee extends User{
	
	//profile picture
		
	public Employee(String username, String passsword, String email) {
		super(username, passsword, email);
		// TODO Auto-generated constructor stub
		this.id = "E" + RandomString.getAlphaNumericString(16);
		//profile picture
	}

}
