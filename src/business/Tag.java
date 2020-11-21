package business;

public class Tag implements Comparable<Tag>{
	
	String key;
	String description;
	
	//CONSTRUCTOR
	public Tag(String key, String description) {
		super();
		this.key = key.toUpperCase();
		this.description = description;
	}
	
	//COMPARATIONS
		public boolean equals(Object o) {
	        if (!(o instanceof Tag))
	            return false;
	        Tag n = (Tag) o;
	        return n.key.equals(key) && n.description.equals(description);
	    }

	    public int hashCode() {
	        return 31*key.hashCode();
	    }

	    public String toString() {
	    	return "*" + key + "*";
	    }

	    public int compareTo(Tag n) {
	        int lastCmp = key.compareTo(n.key);
	        return (lastCmp != 0 ? lastCmp : description.compareTo(n.description));
	    }
	
	//METHODS -> GET-SET
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
