package ListBag;

public class ListBag {
	private int size;
	private Node start;
	private int diffsize;


	public boolean add(Object object){  //입력받은 원소를 연결구조 마지막에 저장
		int sameObj = 0;
		
		if(start == null){   //연결구조 맨 앞이 null일 경우
			start = new Node(object);
			++size;  ++diffsize;
			return true;
		}

		for(Node p = start; p != null; p = p.next){  //맨 앞이 null이 아니고 뒤에 원소가 있는 경우
			if((p.data).equals(object)){  //맨 뒤로 걸어나가면서 같은 원소가 있는 경우
				sameObj++;
			}
			
			if(p.next == null){  //linked list의 맨 뒷자리를 찾았을 경우 삽입
				p.next = new Node(object);
				++size;
				if(sameObj == 0){
					++diffsize;
				}
				return true;
			}
		}return false;
	}


	public boolean remove(Object object) {   //연결구조에서 입력받은 원소 제거
		int sameObj = 0;
		
		for(Node p = start; p != null; p = p.next){  //연결구조 안에 입력받은 원소가 있는지 확인
			if((p.data).equals(object)){
				++sameObj;
			}
		}
		if(sameObj == 1){  //내부에 같은 원소가 한개만 있는 경우 diffsize에 -1
			--diffsize;
		}
		
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
	
	public void print(){  //원소의 개수, 서로 다른 원소 개수, 원소를 출력하는 메소드
		System.out.println("원소의 개수: " + size + "\t서로 다른 원소들의 개수: " + diffsize);
		for(Node p = start; p != null; p = p.next){
			System.out.print(p.data + " ");
		}
		System.out.println(" ");
	}
	
	
	private static class Node{  //Node 클래스
		Object data;
		Node next;
		
		Node(Object data){
			this.data = data;
		}
	}
}
