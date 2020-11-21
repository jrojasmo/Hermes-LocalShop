package dataStructures;

class Queue <T>{
	private T arr[];         // array to store elements
	private int front;         // front points to front element in the queue
	private int rear;          // to last element in the queue
	private int capacity;      // maximum capacity of the queue
	private int count;         // current size of the queue
	
	// Constructor 
	@SuppressWarnings("unchecked")
	Queue(int size){
		arr = (T[]) new Object[size];
		capacity = size;
		front = 0;
		rear = -1;
		count = 0;
	}

	public void dequeue(){
		
		if (isEmpty()){
			System.out.println("Error");
			return;
		}

		front = (front + 1) % capacity;
		count--;
	}

	public void enqueue(T item){
		if (isFull()){
			System.out.println("Error");
			return;
		}

		rear = (rear + 1) % capacity;
		arr[rear] = item;
		count++;
	}

	public T peek(){
		if (isEmpty()) {
			System.out.println("Error");
			return null;
		}
		return arr[front];
	}

	public int size(){
		return count;
	}

	public boolean isEmpty(){
		return (size() == 0);
	}

	public boolean isFull(){
		return (size() == capacity);
	}
}