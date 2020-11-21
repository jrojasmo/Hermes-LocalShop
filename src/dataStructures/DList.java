package dataStructures;


public class DList<T> {
	//Doubly Linked Node
	public static class DNode<T> {
		//prev <-> T <-> next
	    T key;
	    public DNode<T> next; 
	    public DNode<T> prev;
	    
	    //CONSTRUCTOR
	    public DNode (T key, DNode<T> prev, DNode<T> next){
	        this.key = key;
	        this.prev = prev;
	        this.next = next;
	    }
	    public DNode (T key){
	        this.key = key;
	        next = null;
	        prev = null;
	    }
	}
	
	public DNode<T> head;
    public DNode<T> tail;
    
    //CONSTRUCTOR
    public DList() {
    	this.head = null;
    	this.tail = null;
    }
    
    //Return Tail-Head
    public DNode<T> getHead() {
        return head;
    }
    public DNode<T> getTail() {
        return tail;
    }
    public void setHead(DNode<T> head) {
    	this.head = head;
    	return;
	}
    
    //Add element to the list
    //At head
    public void pushFront(T key){
        
        DNode<T> node2 = new DNode<>(key);
        
        if(this.head == null){
            this.tail = node2;
            this.head = tail;
        }else {
            node2.next = head;
            node2.prev = null;
            this.head = node2;
            this.head.next.prev = head;
        }
        
        if(this.tail == null)
            
            this.tail = this.head;     
    }
    //At tail
    public void pushBack(T key){
    	
        DNode<T> node2 = new DNode<>(key);
        
        node2.next = null;
        node2.prev = tail;
        
        if(this.head == null){ 
            this.tail = node2;
            this.head = tail;
        }else {
            this.tail.next = node2;
            node2.prev = this.tail;
            this.tail = node2;
        }
    }
    //After an Element
    public void addAfter (DNode<T> node, T key){
        
        DNode<T> node2 = new DNode<T>(key);
        node2.next = node.next;
        node2.prev = node;
        node.next = node2;
        
        if(node2.next != null)
            node2.next.prev = node2;
        
        if(this.tail == node)
            this.tail = node2;
    }
    //Before an Element
    public void addBefore (DNode<T> node, T key){
    
        DNode<T> node2 = new DNode<T>(key);
        node2.next = node;
        node2.prev = node.prev;
        node.prev = node2;
        
        if(node2.prev != null)
            node2.prev.next = node2;
        
        if(this.head == node)
            this.head = node2;
        
    }
    
    //Remove the last item in the list
    public void popBack(){
    	
        if(this.head == null){
              System.out.println("Error!! : EMPTY LIST");
              return;
        }
        
        if(this.head == this.tail){ //Only one
            this.tail = null;
            this.head = tail;
        }
        else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        
    }
    //Remove an element
    public void pop(T key){
        if(this.head == null)
            System.out.println("Error!! : EMPTY LIST");
        //first
        if(this.head == this.tail)
                this.head = this.tail = null;
        else if (head.key == key)        
                head = head.next;
        else {
            DNode<T> prev =head;
            DNode<T> p = head.next;
            while (p!=tail && p.key != key){
                prev = prev.next;
                prev.next = null;
            }
            
            if(p != null)
                prev.next = p.next;
            
            if(p == tail)
                tail = prev;
            }
    }
    
    //Find using a given key
    public DNode<T> findByKey(T key){
        DNode<T> dn = null;
        DNode<T> p = this.head;
        
        while(p != null){
            if(p.key == key){
                dn = p;
                break;
            }
            
            p = p.next;
        }
        return dn;
    }
    
    //Is Empty?
    public boolean isEmpty(){
        return head == null;
    }
    
    //Print
    public void displayList(){
        if(this.head == null){
            System.out.println("Error!! : EMPTY LIST");
        }
        
        DNode<T> p = this.head;
        
        System.out.print("{");
        
        while (p != null){
            System.out.print(p.key.toString()+" ");
            p = p.next;  
        } 
        
        System.out.print("}");
    }
}
