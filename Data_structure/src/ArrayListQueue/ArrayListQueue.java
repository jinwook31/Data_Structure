package ArrayListQueue;
import java.util.ArrayList;

public class ArrayListQueue extends ArrayList implements Queue{
	private int rear = 0;
	
	@Override
	public void addQ(Object object) {
		// TODO Auto-generated method stub
		add(rear++, object);
	}

	@Override
	public Object first() {
		// TODO Auto-generated method stub
		if(!isEmpty()){
			return get(0);
		}
		return null;
	}

	@Override
	public Object removeQ() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			return null;
		}else
			rear--;
			return remove(0);
	}

	@Override
	public int sizeQ() {
		// TODO Auto-generated method stub
		return size();
	}
	
	public void print(){
		Object [] last = toArray();
		System.out.print("저장되어있는 원소 : ");
		for(int i = 0; i < last.length; i++){
			System.out.print(last[i] + " ");
		}
		System.out.println(" ");
	}

}