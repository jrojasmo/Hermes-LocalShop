package dataStructures;


public class BSTTree < T extends Comparable <?super T> >{
	//B NODE
		public static class BNode<T> {
			T key; //The data in the node
			BNode<T> left; //Left child
			BNode<T> right; //Right child
			
			/*public BNode(T key, BNode<T> left, BNode<T> right) {
				super();
				this.key = key;
				this.left = left;
				this.right = right;
			}*/
			public BNode(T key) {
				super();
				this.key = key;
				this.left = null;
				this.right = null;
			}
			
		}
		
		private BNode <T> root;

		//CONSTRUCTOR
		public BSTTree(BNode<T> root) {
			super();
			this.root = root;
		}
		public BSTTree(T data) {
			super();
			this.root = new BNode<T>(data);
		}
		public BSTTree() {
			super();
			this.root = null;
		}
		
		//METHODS
		
		/* Make the tree empty
		 * Perform the operations to free up the memory being used by the tree
		 * */
		public void makeEmpty() {
		     root=null;
		}
		
		//Test if the tree is empty
		public boolean isEmpty() {
		     return (root == null);
		}
		
		//Insert in the tree
		BNode<T> insert(T x, BNode<T> t) {
		     if (t == null) 
		          return t = new BNode<T>(x);
		     if (x.compareTo(t.key) > 0)
		          t.right= insert(x, t.right);
		     if (x.compareTo(t.key) < 0)
		          t.left= insert(x, t.left);
		     
		    return t;
		}
		BNode<T> insert(T x) {
			if (root == null) 
		          return root = new BNode<T>(x);
			
		    return insert(x, root);
		}
		
		//Search
		boolean contains( T x, BNode<T> t ) { 
		    if ( t == null ) 
		        return false;
		    
		    if ( x.compareTo(t.key) > 0 )
		         return contains( x, t.right );
		    else if ( x.compareTo(t.key) < 0 )
		         return contains( x, t.left );
		    else
		    	return true;
		}
		boolean contains( T x ) { 
			return contains(x, root);
		}
		
		//Min - Max
		BNode<T> findMin( BNode<T> t ) {
		     if ( t == null ) 
		         return null;
		     else if  ( t.left == null ) 
		         return t;
		     
		     return findMin( t.left );
		}
		T findMin() {
		     if ( isEmpty() ) {
		    	 System.out.println("The tree is empty!");
		    	 return null;
		     }
		     return findMin( root ).key;
		}
		
		BNode<T> findMax( BNode<T> t ) {
		     if ( t == null ) 
		         return null;
		     else if  ( t.right == null ) 
		         return t;
		     
		     return findMin( t.right );
		}
		T findMax() {
		     if ( isEmpty() ) {
		    	 System.out.println("The tree is empty!");
		    	 return null;
		     }
		     return findMax( root ).key;
		}
		
		//Remove
		BNode<T> remove( T x, BNode<T> t ) {
			if(t == null)
				return t;
			
			if ( x.compareTo(t.key) < 0 )// is in the left subtree
	            t.left = remove(x, t.left);
			else if( x.compareTo(t.key) > 0 )// is in the right subtree
	            t.right = remove(x, t.right);
			else { //is the node to remove
				// 	Case node with only one child or no child
	            if( (t.left == null) || (t.right == null) ) {
	                BNode<T> tmp;
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
	                BNode<T> tmp = findMin(t.right);

	                t.key = tmp.key;

	                // Delete the in-order successor
	                t.right = remove(tmp.key, t.right);
	            }
	        }
		          
		     return t;
		}
		BNode<T> remove( T x ) {
			return root = remove( x, root );
		}
		
		//Height
		int height( BNode<T> t ){
		     if ( t == null )
		        return -1;
		     else
		         return 1 + Math.max( height(t.left), height(t.right) ); 
		}

		//Print
		void printInOrder(BNode<T> t) { 
			if (t == null) 
				return;
			printInOrder(t.left); 
			System.out.printf("%s ", t.key); 
			printInOrder(t.right); 
		}
		void printPostOrder(BNode<T> t) { 
			if (t == null) 
				return;
			printPostOrder(t.left); 
			printPostOrder(t.right);
			System.out.printf("%s ", t.key); 
		}
		void printPreOrder(BNode<T> t) { 
			if (t == null) 
				return;
			System.out.printf("%s ", t.key); 
			printPreOrder(t.left); 
			printPreOrder(t.right); 
		}
		void printTree(int c) {
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
			 default:
				 System.out.println("Bad election!");
			}
			
			System.out.println(" **");
		}

}
