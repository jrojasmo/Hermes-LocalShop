package business;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import processes.ReadData;

public class Main {
	public static void main(String[] args) {
		
		ProductDatabase productDatabase = new ProductDatabase();
		UserDatabase userDatabase = new UserDatabase();
		ReadData read = new ReadData();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Realize Test (?) -> (Y/N)");
		String response = sc.nextLine();
		
		//TEST
		if(response.equals("Y") || response.equals("y")) {	
		int n = 1;
		long startTime, endTime;
		float time;
		//System.out.println("Test with "+n*10000+" data");
		System.out.println("Test of Products:");
		//Products -> Testing
		startTime = System.nanoTime();
		for(int i = 0; i < n; i++) {
			try(Scanner input = new Scanner(new File("data/dataTest/products10K.txt"))){	
		  		while(input.hasNextLine()) {
		  			read.readLine(input);
		  			int quantity = Integer.parseInt(read.colB);
		  			float price = Float.parseFloat(read.colC);
		  			Product p = new Product(read.colA, quantity, price);
		  			productDatabase.addProduct(p);
		  		}
		  	} catch (IOException e) {
		  	  		System.out.println(e);
		  	}
		}
		endTime = System.nanoTime() - startTime;
		time = endTime/1000;
		System.out.println(time);
		//Finding
		System.out.println("Finding :");
		Product test_p = new Product("Seaching", 10, Float.parseFloat("9.99"));
		productDatabase.addProduct(test_p);
		startTime = System.nanoTime();
		//Product busP = productDatabase.consultByName("Seaching", "FIND");
		productDatabase.contains(test_p);
		endTime = System.nanoTime() - startTime;
		//if(busP != null) {
			System.out.println(test_p.toString());
			time = endTime/1000;
			System.out.println(time);
			
			//Edit a product (removing and inserting)
			System.out.println("Edit a product (removing and inserting) :");
			startTime = System.nanoTime();
			Product new_p = new Product("Editing", 10, Float.parseFloat("9.99"));
			productDatabase.editProduct(test_p, new_p);
			endTime = System.nanoTime() - startTime;
			time = endTime/1000;
			System.out.println(time);		
			
		//}
		
		//Users -> Testing
		System.out.println("Test of User:");
		startTime = System.nanoTime();
		for(int i = 0; i < n; i++) {
			try(Scanner input = new Scanner(new File("data/dataTest/users10K.txt"))){	
		  		while(input.hasNextLine()) {
		  			read.readLine(input);
		  			User u = new Client(read.colA, read.colB, read.colC);
		  			userDatabase.addUser(u);
		  		}
		  	} catch (IOException e) {
		  	  		System.out.println(e);
		  	}
		}
		endTime = System.nanoTime() - startTime;
		time = endTime/1000;
		System.out.println(time);
		//Finding
		System.out.println("Finding :");
		User admin = new Administrator("Luvakor", "1234", "jesusroj47@gmail.com");
		userDatabase.addUser(admin);
		
		startTime = System.nanoTime();
		User busU = userDatabase.consultUser("Luvakor", "1234");
		endTime = System.nanoTime() - startTime;
		if(busU != null) {
			System.out.println(admin.toString());
			time = endTime/1000;
			System.out.println(time);
			
			//Edit a product (removing and inserting) 
			System.out.println("Edit a user (removing and inserting) :");
			startTime = System.nanoTime();
			User new_u = new Client("Editing", "1234", "editing@gmial.com");
			userDatabase.editUser(admin, new_u);
			endTime = System.nanoTime() - startTime;
			time = endTime/1000;
			System.out.println(time);	
			
		}
	}else {
		try(Scanner input = new Scanner(new File("data/dataTest/users.txt"))){	
	  		while(input.hasNextLine()) {
	  			read.readLine(input);
	  			User u = new Client(read.colA, read.colB, read.colC);
	  			userDatabase.addUser(u);
	  		}
	  	} catch (IOException e) {
	  	  		System.out.println(e);
	  	}
		try(Scanner input = new Scanner(new File("data/dataTest/products.txt"))){	
	  		while(input.hasNextLine()) {
	  			read.readLine(input);
	  			int quantity = Integer.parseInt(read.colB);
	  			float price = Float.parseFloat(read.colC);
	  			Product p = new Product(read.colA, quantity, price);
	  			productDatabase.addProduct(p);
	  		}
	  	} catch (IOException e) {
	  	  		System.out.println(e);
	  	}	
		productDatabase.printDatabase();
		/*System.out.println("Welcome to Hermes");
		productDatabase.printDatabase();
		System.out.println("Insert your username:");
		String userName = sc.nextLine();
		System.out.println("Insert your password:");
		String password = sc.nextLine();
		User currentUser = userDatabase.consultUser(userName, password);
		if(currentUser != null) {
			System.out.println("Log In Success: ");
			System.out.println(currentUser.toString());
		}else {
			System.out.println("Error, user not found");
		}
		System.out.println("Insert name to find a product:");
		String pName = sc.nextLine();
		Product currentProduct = productDatabase.consultProductByName(pName);
		if(currentProduct != null) {
			System.out.println("Your product is: ");
			System.out.println(currentProduct.toString());
		}else {
			System.out.println("Error, product not found");
		}*/
	}
		
		
		sc.close();
	}
}
