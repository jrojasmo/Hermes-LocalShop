package dataStructures;

public class Stack<T> {
		@SuppressWarnings("hiding")
		public class Node<T> {
		    
	        private T key;
	        Node<T> next;
	        
	        //CONSTRUCTOR
	        public Node(T key, Node<T> top){
	            this.key = key;
	            this.next = top;
	        }
	        public Node(T key){
	            this.key = key;
	        }
	        
	        //METHODS
	        void setKey(T key){
	            this.key = key;
	        }
	        T getKey(){
	            return key;
	        }
	        Node<T> next(){
	            return next;
	        }   
	        void setNext(Node<T> node){
	            this.next = node;
	        }
	    }
		
		private Node<T> top;
	    private int size;
	    
	    //Size of the stack
	    public int size() {
	        return size;
	    }

	    //Is Empty?
	    public boolean isEmpty() {
	       return top == null;
	    }

	    //Add to the Stack
	    public void push(T key) {
	        Node<T> node = new Node<>(key, this.top);
	        this.top = node;
	        size++;
	    }

	    //Remove and return the top of the stack
	    public T pop() {
	        if(isEmpty()){
	            System.out.println("Error!! : EMPTY STACK");
	            return null;
	        }
	        
	        T temp = this.top.getKey();
	        this.top = top.next();
	        size--;
	        return temp;
	    }

	    //Return the top of the stack
	    public T top() {
	        if(isEmpty()){
	            //System.out.println("Error!! : EMPTY STACK");
	            return null;
	        }
	        
	        return top.getKey();
	    }
	    
	    //Print
	    public void displayStack() {
	    	Node<T> tmp = top;
	    	System.out.println("*TOP* ->"+tmp.getKey().toString());
	    	tmp = tmp.next;
	    	while(tmp != null) {
	    		System.out.println("      * "+tmp.getKey().toString());
	    		tmp = tmp.next();
	    	}
	    }
}
