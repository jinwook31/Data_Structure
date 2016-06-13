package SLinkedQueue;

public class SLinkedQueue implements Queue{
	private Node head;
	private Node rear;
	private int size;

	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		Node input = new Node(object, null);
		if(isEmpty()){ //앞이 비어있을 경우
			head = input;
		}else{
			rear.next = input;
		} 
		rear = input;
		++size;
	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub
		if(size == 0) throw new IllegalStateException("the queue is empty");
		return head.object;
	}

	@Override
	public Object remove(){
		// TODO Auto-generated method stub
		if(isEmpty()) throw new IllegalStateException("the queue is empty");
		Object temp = head.object;
		head = head.next;
		--size;
		return temp;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void printProgress(){
		System.out.print("저장된 원소 : ");
		for(Node p = head; p != null; p = p.next){
			System.out.print(p.object + " ");
		}
		System.out.println(" ");
	}
	
	private static class Node{
		Object object;
		Node next = this;
		
		Node(Object object){
			this.object = object;
		}
		
		Node(Object object, Node next){
			this.object = object;
			this.next=next;
		}
	}
}
