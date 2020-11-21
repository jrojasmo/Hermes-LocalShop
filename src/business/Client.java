package business;

import processes.RandomString;
import dataStructures.DynArray;

public class Client extends User{

	//profile picture
	float money;
	public class ShoppingCart {
		DynArray<Product> cart;
		
		//CONSTRUCTOR
		ShoppingCart(){
			this.cart = new DynArray<Product>(5);
		}
		
		//METHODS
		public void addProduct(Product p) {
			p.reserve();
			cart.pushBack(p);
		}
		public boolean rmProduct(int index) {
			Product p = cart.remove(index);
			if(!p.equals(null)) {
				p.unReserve();
				return true;
			}
			return false;
		}
		public boolean rmProduct(Product p) {
			Product prod = cart.remove(cart.find(p));
			if(!prod.equals(null)) {
				prod.unReserve();
				return true;
			}
			return false;
		}
	}
	
	ShoppingCart cart;
	
	public Client(String username, String passsword, String email) {
		super(username, passsword, email);
		// TODO Auto-generated constructor stub
		this.id = "C" + RandomString.getAlphaNumericString(16);
		this.cart = new ShoppingCart();
		this.money = 0;
		//profile picture
	}
	

}
