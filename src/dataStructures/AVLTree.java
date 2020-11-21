package dataStructures;


public class AVLTree < T extends Comparable <?super T> >{
	public static class AVLNode <T>{
		private T key; // Data in the node (key)
		AVLNode <T> left; // Left child
		AVLNode <T> right; // Right child
		int height; 
		
		public AVLNode(T key) {
			this.setKey(key);
			this.height = 1;
		}

		public T getKey() {
			return key;
		}

		public void setKey(T key) {
			this.key = key;
		}
	}
		
	public AVLNode<T> root;
	
	//CONSTRUCTOR
		public AVLTree(T data) {
			this.root = new AVLNode<T>(data);
		}
		public AVLTree() {
			this.root = null;
		}
		
	//Empty
	public void makeEmpty() {
		 root=null;
	}
	//Test if the tree is empty
	public boolean isEmpty() {
		 return (root == null);
	}
	//Height
	int height (AVLNode<T> n) {
        if (n == null)
            return 0;
        return n.height;
    }
	
	//Rotations
	private AVLNode<T> rightRotation(AVLNode<T> t){ //R
		AVLNode<T> tmp = t.left;
		AVLNode<T> tmpR = tmp.right;
		//Rotation
		tmp.right = t;
		t.left = tmpR;
		//Update Heights
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		tmp.height = Math.max(height(tmp.left), height(tmp.right)) + 1;
	
		//System.out.println("RR");
		return tmp;
	}
	private AVLNode<T> leftRotation(AVLNode<T> t){ //L
		AVLNode<T> tmp = t.right;
		AVLNode<T> tmpL = tmp.left;
		//Rotation
		tmp.left = t;
		t.right = tmpL;
		//Update Heights
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		tmp.height = Math.max(height(tmp.left), height(tmp.right)) + 1;
	
		//System.out.println("LL");
		return tmp;
	}
	private AVLNode<T> doubleLRRotation(AVLNode<T> t){ //LR
		t.left =  leftRotation(t.left); 
		//System.out.println("LR");
        return rightRotation(t);
	}
	private AVLNode<T> doubleRLRotation(AVLNode<T> t){ //RL
		t.right = rightRotation(t.right);
		//System.out.println("RL");
        return leftRotation(t);
	}
	
	//Balance
	private int getBalance(AVLNode<T> t) {
		if (t == null)
            return 0;
        return height(t.left) - height(t.right);
    }
	private AVLNode<T> balanceTree(T x, AVLNode<T> t){
		 int balance = getBalance(t); 
		 //System.out.println(balance);
	    // If is unbalanced, there are 4 cases
	     if (balance > 1 && (x.compareTo(t.left.getKey()) < 0) )// Left Left
	    	 return rightRotation(t);
	     if (balance < -1 && (x.compareTo(t.right.getKey()) > 0) )// Right Right
	    	 return leftRotation(t);
	     if (balance > 1 && (x.compareTo(t.left.getKey()) > 0) )// Left Right
	         return doubleLRRotation(t);
	     if (balance < -1 && (x.compareTo(t.right.getKey()) < 0) )// Left Right
	         return doubleRLRotation(t);
	     
	     // No rotations needed
	        return t;
	}
	
	//Min value - Max value
	private AVLNode<T> findMin( AVLNode<T> t ) {
	     if ( t == null ) 
	         return null;
	     else if  ( t.left == null )  
	         return t;
	     
	     return findMin( t.left );
	}
	public T findMin () {
	     if ( root == null ) {
	    	 System.out.println("The tree is empty!");
	    	 return null;
	     }
	     return findMin( root ).getKey();
	}
	
	private AVLNode<T> findMax( AVLNode<T> t ) {
	     if ( t == null ) 
	         return null;
	     else if  ( t.right == null )  
	         return t;
	     
	     return findMin( t.right );
	}
	public T findMax () {
	     if ( root == null ) {
	    	 System.out.println("The tree is empty!");
	    	 return null;
	     }
	     return findMax( root ).getKey();
	}
	
	//Insert
	private AVLNode<T> insert( T x , AVLNode<T> t) {
		//Usual insert in BSTs
		if(t == null)
			return t = new AVLNode<T>(x);
		
		if(x.compareTo(t.getKey()) < 0)
			t.left = insert(x, t.left);
		if((x.compareTo(t.getKey()) > 0))
			t.right = insert(x, t.right);
		
		//Update the heights (Ancestors)
		t.height = Math.max(height(t.left), height(t.right)) + 1;
		
		return balanceTree(x, t);
	}
	public AVLNode<T> insert(T x) {
		if (root == null) 
	          return root = new AVLNode<T>(x);
		
	    return root = insert(x, root);
	}
	
	//Remove
	private AVLNode<T> remove( T x , AVLNode<T> t){
		//Usual remove in BSTs
		if(t == null)
			return t;
		
		if ( x.compareTo(t.getKey()) < 0 )// is in the left subtree
            t.left = remove(x, t.left);
		else if( x.compareTo(t.getKey()) > 0 )// is in the right subtree
            t.right = remove(x, t.right);
		else { //is the node to remove
			// 	Case node with only one child or no child
            if( (t.left == null) || (t.right == null) ) {
                AVLNode<T> tmp;
                if (t.left != null)
                    tmp = t.left;
                else
                    tmp = t.right;

                if(tmp == null) {//No child
                    tmp = t;
                    t = null;
                }
                else //Child
                    t = tmp;

                tmp = null;
            }
            else {
                // Case node with two children: Get in-order successor
            	//(min in the right subtree)
                AVLNode<T> tmp = findMin(t.right);

                t.setKey(tmp.getKey());

                // Delete the in-order successor
                t.right = remove(tmp.getKey(), t.right);
            }
        }

        // If the tree had only one node then return it
        if (t == null)
            return t;

        return balanceTree(x, t);
	}
	public AVLNode<T> remove( T x ) {
		return root = remove( x, root );
	}
	
	//Search
	private boolean contains( T x, AVLNode<T> t ) { 
		if ( t == null ) 
	        return false;
	    
	    if ( x.compareTo(t.getKey()) > 0 )
	         return contains( x, t.right );
	    else if ( x.compareTo(t.getKey()) < 0 )
	         return contains( x, t.left );
	    else
	    	return true;
	}
	public boolean contains( T x ) { 
		return contains(x, root);
	}
	private T consult( T x, AVLNode<T> t ) { 	
		if(x == null || t == null) {
			return null;
		}
	    if ( x.compareTo(t.getKey()) > 0 )
	         return consult( x, t.right );
	    else if ( x.compareTo(t.getKey()) < 0 )
	         return consult( x, t.left );
	    else
	    	return t.getKey();
	}
	public T consult( T x ) { 
		return consult(x, root);
	}	
	//Print
	void printInOrder(AVLNode<T> t) { 
		if (t == null) 
			return;
		printInOrder(t.left); 
		System.out.printf("%s ", t.getKey().toString() + " ;; "); 
		printInOrder(t.right); 
	}
	void printPostOrder(AVLNode<T> t) { 
		if (t == null) 
			return;
		printPostOrder(t.left); 
		printPostOrder(t.right);
		System.out.printf("%s ", t.getKey().toString() + " ;; "); 
	}
	void printPreOrder(AVLNode<T> t) { 
		if (t == null) 
			return;
		System.out.printf("%s ", t.getKey().toString() + " ;; "); 
		printPreOrder(t.left); 
		printPreOrder(t.right); 
	}
	void print(AVLNode<T> t) { 
		if (t == null) 
			return;
		System.out.println("\\*\\" + t.getKey().toString() + " /*/ "); 
		print(t.left); 
		print(t.right); 
	}
	public void printTree(int c) {
		switch(c) {
		 case 0:
			 printInOrder(root);
		 break;
		 case 1:
			 printPreOrder(root);
		 break;
		 case 2:
			 printPostOrder(root);
		 break;
		 case 3:
			 print(root);
		 break;
		 default:
			 System.out.println("Bad election!");
		}
		
		System.out.println(" **");
	}
}
