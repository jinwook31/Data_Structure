package ArrayQueue_Client2;

public interface Queue {
	public void add(Object object);
	public Object first();
	public Object remove();
	public int size();
	public void print();
}