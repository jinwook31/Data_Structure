package LinkedStack;

public class LinkedStack implements Stack {
	private Node top;
	private int size;
	
	public boolean isEmpty(){
		return (size == 0);
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(size == 0) throw new java.util.NoSuchElementException();
		return top.object;
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if(size == 0) throw new java.util.NoSuchElementException();
		Object oldTop = top.object;
		--size;
		top = top.next;
		return oldTop;
	}

	@Override
	public void push(Object object) {
		// TODO Auto-generated method stub
		top = new Node(object, top);
		++size;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	private static class Node{
		Object object;
		Node next;
		Node(Object object, Node next){
			this.object = object;
			this.next = next;
		}
	}
}
