package ArrayQueue_Client2;

public class ArrayQueue implements Queue {
	private static final int MAX_SIZE = 5000;
	private int front = 0,rear = 0;
	private int size;
	Object obj[] = new Object[MAX_SIZE];
	
	public ArrayQueue(){
		front = 0;
		rear = 0;
	}
	
	@Override
	public void add(Object object) {
		if((rear + 1)%MAX_SIZE == front){
			System.out.println("큐는 Full");
		}
		else {
			obj[rear] = object;
			rear = (rear+1) % MAX_SIZE;
		}
		// TODO Auto-generated method stub
		size++;
	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object remove() {
		
		if(isEmpty()){
			System.out.println("큐는 empty.");
			System.out.println("---------");
			return null;
		} else {
			Object removeObj = obj[front];
			obj[front] = null;
			front = (front+1)%MAX_SIZE;
			size--;
			return removeObj;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public void print(){
		for(int i = 0; i< obj.length; i++){
		System.out.print(obj[i] +" ");
		}
		System.out.println("");
	}
	
	public boolean isEmpty(){
		return front == rear ? true : false;
	}
	
}