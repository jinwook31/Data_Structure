package java_basic_ArraySet;

public interface setADT {
	public boolean add(Object object);
	public boolean contains (Object object);
	public Object getFirst();
	public Object getNext();
	public boolean remove(Object object);
	public int size();
}