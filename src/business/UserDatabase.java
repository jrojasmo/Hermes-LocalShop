package business;

import dataStructures.HashTable;

public class UserDatabase {
	
	HashTable<User> database;
	
	//CONSTRUCTOR
	public UserDatabase() {
		this.database = new HashTable<>();
	}
	
	//Add user
	public void addUser (User u) {
		database.add(u);
	}
	//Delete user
	public void remUser (User u) {
		database.remove(u);
	}
	//Is in the database?
	public boolean contains (User u) {
		return database.contains(u);
	}

	public User consultUser (String username, String password) {
		User u = new User(username, password, " ", "FIND");
		return database.get(u);
	}

	
	//Edit
	public boolean editUser(User u, User new_u) {
		if(new_u == null || u == null)
			throw new NullPointerException();
		if(contains(u)) {
			new_u.setId(u.getId());
			remUser(u);
			addUser(new_u);
			return true;
		}
		return false;
	}
	public void printDatabase() {
		database.print();
	}
}
