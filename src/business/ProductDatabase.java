package business;

import dataStructures.DynArray;
import dataStructures.HashTable;
import dataStructures.HashTable.HashNode;

public class ProductDatabase {
	
	HashTable<Product> database;
	
	//CONSTRUCTOR
	public ProductDatabase() {
		this.database = new HashTable<>();
	}
	
	//Add user
	public void addProduct (Product u) {
		database.add(u);
	}
	//Delete user
	public void remProduct (Product u) {
		database.remove(u);
	}
	//Is in the database?
	public boolean contains (Product u) {
		return database.contains(u);
	}

	
	/*public Product consultProductByName (String name) {
		Product u = new Product(name, "FIND");
		return database.consult(u);
	}
	public Product consultProductById (String id) {
		Product u = new Product(" ", id);
		return database.consult(u);
	}*/
	
	//Edit
	public boolean editProduct(Product p, Product new_p) {
		if(new_p == null || p == null)
			throw new NullPointerException();
		if(contains(p)) {
			new_p.setId(p.getId());
			remProduct(p);
			addProduct(new_p);
			return true;
		}
		return false;
	}
	public void printDatabase() {
		database.print();
	}
	
	public Product[] toArray() {
		Product[] arr = new Product[database.size()];
		DynArray<HashNode<Product>> temp = database.getSlotArray(); 
		
    	int cont = 0;
		for (int i = 0; i < temp.size(); i++) { 
        	HashNode<Product> headNode = temp.get(i);
            while (headNode != null) { 
                arr[cont] = headNode.getValue();
                //System.out.println(cont + " " + headNode.getValue().toString() );
                headNode = headNode.getNext(); 
                cont++;
            }
        } 
		//System.out.println(database.size());
		return arr;
	}
}
