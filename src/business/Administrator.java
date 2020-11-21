package business;

import processes.RandomString;

public class Administrator extends User{
	
	//profile picture
	
	public Administrator(String username, String passsword, String email) {
		super(username, passsword, email);
		// TODO Auto-generated constructor stub
		this.id = "A" + RandomString.getAlphaNumericString(16);
		//profile picture
	}

}
