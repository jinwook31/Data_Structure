package CircularQueue;

public class CircularQueue implements Queue {
	private int MAX_QUEUE_SIZE = 4;
	private Object[ ] a = new Object [MAX_QUEUE_SIZE];
	private int front=0, rear=0;
	
	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		if((rear + 1) % MAX_QUEUE_SIZE == front){
			System.out.println("Queue is full");
		}else{
			rear = (rear + 1) % MAX_QUEUE_SIZE;
			a[rear % MAX_QUEUE_SIZE] = object;
		}
	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub
		if((a[(front + 1)%MAX_QUEUE_SIZE])== null){
			return null;
		}else
			return a[(front + 1)%MAX_QUEUE_SIZE];
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		if((a[(front + 1)%MAX_QUEUE_SIZE]) == null){
			System.out.println("Queue is empty");
			return null;
		}else{
			front = (front + 1) % MAX_QUEUE_SIZE;
			Object temp = a[front];
			a[front] = null;
			return temp;
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		int size=0;
		for(int i=0; i < a.length; i++){
			if(a[i]!=null){
				size++;
			}
		}
		return size;
	}
	
	public void printProgress(){
		System.out.print("큐에 저장된 원소 : ");
		if(size() != 0){
			for(int i = 0; i < a.length; i++){
				if(a[i] != null)
				System.out.print(a[i] + " ");
			}
			System.out.println(" ");
		}else{
			System.out.println("Queue is empty");
		}
	}
}
