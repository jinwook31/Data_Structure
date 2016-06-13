package DS_Performance_AVL_BST_HT_LL;

public class LinkedList {
	private int size;
	private Node start;

	public boolean add(Object object){  //입력받은 원소를 연결구조 마지막에 저장		
		if(start == null){   //연결구조 맨 앞이 null일 경우
			start = new Node(object);
			++size;
			return true;
		}

		for(Node p = start; p != null; p = p.next){  //맨 앞이 null이 아니고 뒤에 원소가 있는 경우
			if((p.data).equals(object)){  //맨 뒤로 걸어나가면서 같은 원소가 있는 경우
				p.count++;
				return false;
			}
			
			if(p.next == null){  //linked list의 맨 뒷자리를 찾았을 경우 삽입
				p.next = new Node(object);
				++size;
				return true;
			}
		}return false;
	}


	public boolean remove(Object object) {   //연결구조에서 입력받은 원소 제거	
		if((start.data).equals(object)){  //입력받은 원소가 맨 앞에 위치할 경우
			start = start.next;
			--size;
			return true;
		}
		
		for(Node p = start; p.next != null; p = p.next){   //입력받은 원소가 그 이후에 있을 경우
			if((p.next.data).equals(object)){
					p.next = p.next.next; 
					--size;
				return true;
			}
		}
		return false;
	}
	
	public void print(){
		for(Node p = start; p != null; p = p.next){
			System.out.println(p.data + " : "+ p.count);
		}
	}
	
	public int size(){
		return size;
	}
	
	private static class Node{  //Node 클래스
		Object data;
		Node next;
		int count = 1;
		
		Node(Object data){
			this.data = data;
		}
	}
}