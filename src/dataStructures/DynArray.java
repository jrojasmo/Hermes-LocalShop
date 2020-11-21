package dataStructures;


public class DynArray<T> {
    T[] arr;
    int capacity;
    int size;
    
    //CONSTRUCTOR
    @SuppressWarnings("unchecked")
	public DynArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = (T[]) new Object[capacity];        
    }
    @SuppressWarnings("unchecked")
	public DynArray() {
        this.capacity = 1;
        this.size = 0;
        this.arr = (T[]) new Object[1];        
    }
    
    //Get the Array
     public T get(int i){
         if(i<0 || i>size){
             System.out.println("ERROR: index out of range");
             return null;
        }
             
        return arr[i];
     }
     
     //Change the Array
     public void set(int i, T val){
          if(i<0 || i>size){
             System.out.println("ERROR: index out of range");
             return;
        }
        arr[i] = val;
     }
    
    //Add to the Array
    public void pushBack(T val){
        if(size == capacity){
        	
            @SuppressWarnings("unchecked")
			T[] new_arr = (T[]) new Object[2*capacity];
            
            for(int i = 0 ; i < size; i++){
                new_arr[i] = arr[i];
            }
            
            arr = null;
            arr = new_arr;
            capacity = 2*capacity;
            arr[size] = val;
            size++;
        }else{
            arr[size] = val;
            size++;
        } 
    }
    
    //Delete element in the array
    public T remove(int i){
        if(i<0 || i>size){
             System.out.println("ERROR: index out of range");
             return null;
        }
        T tmp = arr[i];
        for(int j = i; j < size-1; j++)
            arr[j]=arr[j+1];
        size--;
        return tmp;
    }
    
    //Actual position of the last element
     public int size() {
         return size;
     }
     
     public int find(T data) {
    	 int index = 0;
    	 while(index < size) {
    		 
    		 if (arr[index].equals(data))
    			 return index;
 	 
    		 index++;
    	 }
    	 
    	 return -1;
     }
     
     //Print
     public void print(){
    	 System.out.print("[ ");
    	 
         for(int i = 0; i < size; i++)
             if(arr[i] != null){
                System.out.print(arr[i].toString());
                if(i != size-1) 
                    System.out.print(", ");                    	
             }else {
            	System.out.print("  ");
            	if(i != size-1) 
                    System.out.print(", "); 
             }
             
         
         System.out.println("]");
     }
    
    
}
