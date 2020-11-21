package business;

import javax.swing.ImageIcon;

public class User implements Comparable<User>{
	
	String id = "";
	public String username = "";
	public String email = "";
	private String password = "";
	ImageIcon userPhoto;
	
	//CONSTRUCTOR
	public User(String username, String passsword, String email, ImageIcon photo) {
		super();
		if (username == null || passsword == null)
            throw new NullPointerException();
		this.username = username;
		this.password = passsword;
		this.email = email;
		this.userPhoto = photo;
	}
	public User(String username, String passsword, String email) {
		super();
		if (username == null || passsword == null)
            throw new NullPointerException();
		this.username = username;
		this.password = passsword;
		this.email = email;
		//this.userPhoto = new javax.swing.ImageIcon(getClass().getResource("/img/defaultUser.png"));
		this.userPhoto = null;
	}
	public User(String username, String passsword, String email, String use) {
		super(); 
		if (username == null || passsword == null)
            throw new NullPointerException();
		this.username = username;
		this.password = passsword;
		this.email = email;
		this.id = use;
		//this.userPhoto = new javax.swing.ImageIcon(getClass().getResource("/img/defaultUser.png"));
		this.userPhoto = null;
	}
	
	//COMPARATIONS
	public boolean equals(Object o) {
        if (!(o instanceof User))
            return false;
        User n = (User) o;
        return n.username.equals(username) && n.password.equals(password) && n.id.equals(id);
    }

    public int hashCode() {
        return 31*username.hashCode() + password.hashCode();
    }

    public String toString() {
    	return "id : " + id + " */* user : " + username + " */* email : " + email;
    }

    public int compareTo(User n) {
    	int lastCmp;
    	if((username.equals(" ") && password.equals(" ")) || (n.username.equals(" ") && n.password.equals(" ")))
    		lastCmp = id.compareTo(n.id);
    	else {
	        lastCmp = username.compareTo(n.username);
	        if(lastCmp == 0)
	        	lastCmp = password.compareTo(n.password);
	        if(lastCmp == 0) 
	        	if(id.equals("FIND") || n.id.equals("FIND"))
	        		lastCmp = 0;
	        	else
	        		lastCmp = id.compareTo(n.id);
    	}
        return lastCmp;
    }
    //METHODS
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
