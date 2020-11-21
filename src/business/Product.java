package business;

import javax.swing.ImageIcon;

import processes.RandomString;

public class Product implements Comparable<Product>{
	
	String id;
	String name;
	String description;
	int quantity;
	float price;
	Tag tag;
	ImageIcon productPhoto;
	//IMAGE
	
	//CONSTRUCTOR
	public Product(String name, int quantity, float price, String description, Tag tag, ImageIcon photo) {
		super();
		if (name == null || description == null || tag == null || quantity < 0 || price < 0)
            throw new NullPointerException();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		
		this.id = "P-" + tag.getKey() + "-" + RandomString.getAlphaNumericString(13);
		this.description = description;
		this.tag = tag;
		this.productPhoto = photo;
	}
	public Product(String name, int quantity, float price, String description, Tag tag) {
		super();
		if (name == null || description == null || tag == null || quantity < 0 || price < 0)
            throw new NullPointerException();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		
		this.id = "P-" + tag.getKey() + "-" + RandomString.getAlphaNumericString(13);
		this.description = description;
		this.tag = tag;
		//this.productPhoto = new javax.swing.ImageIcon(getClass().getResource("/img/defaultProduct.jpg"));
		this.productPhoto = null;
	}
	public Product(String name, int quantity, float price) {
		super();
		if (name == null || quantity < 0 || price < 0)
            throw new NullPointerException();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		
		this.tag = new Tag("NULL"," ");
		this.id = "P-" + tag.getKey() + "-" + RandomString.getAlphaNumericString(13);
		this.description = "No description";
		//this.productPhoto = new javax.swing.ImageIcon(getClass().getResource("/img/defaultProduct.jpg"));
		this.productPhoto = null;
	}
	public Product(String name, String use) {
		super();
		if (name == null || use == null)
            throw new NullPointerException();
		this.name = name;
		this.quantity = 0;
		this.price = 0;
		
		this.id = use;
		this.description = "No description";
		this.tag = new Tag("NULL"," ");
		//this.productPhoto = new javax.swing.ImageIcon(getClass().getResource("/img/defaultProduct.jpg"));
		this.productPhoto = null;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
		//COMPARATIONS
		public boolean equals(Object o) {
	        if (!(o instanceof Product))
	            return false;
	        Product n = (Product) o;
	        return n.name.equals(name) && n.quantity == quantity && n.price == price && n.id.equals(id);
	    }

	    public int hashCode() {
	        return 31*name.hashCode() + tag.hashCode();
	    }

	    public String toString() {
	    	return "id : " + id + " */* name : " + name + " */* quantity : " + quantity + " */* price : " +  price  + " */* tag : " +  tag;
	    }

	    public int compareTo(Product n) {
	    	int lastCmp;
	    	if(name.equals(" ") || n.name.equals(" "))
	    		lastCmp = id.compareTo(n.id); 
	    	else {
		        lastCmp = name.compareTo(n.name);
		        if(lastCmp == 0) 
		        	if(id.equals("FIND") || n.id.equals("FIND"))
		        		lastCmp = 0;
		        	else
		        		lastCmp = id.compareTo(n.id);
	    	}
	        return lastCmp;
	    }
	    
	    //METHODS
	    public boolean reserve() {
	    	if(quantity > 0) {
	    		quantity--;
	    		return true;
	    	}
	    	return false;
	    }
	    public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public Tag getTag() {
			return tag;
		}
		public void setTag(Tag tag) {
			this.tag = tag;
		}
		public void unReserve() {
	    	quantity++;
	    }
	    public boolean isVaild() {
	    	return (quantity > 0);
	    }
	    
	    
	
}
