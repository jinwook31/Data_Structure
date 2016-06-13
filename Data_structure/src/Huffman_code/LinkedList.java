package Huffman_code;

public class LinkedList {
	private int size;
	private trecord start;
	

	public int size(){
		return size;
	}

	public boolean add(trecord object){  //입력받은 원소를 연결구조 마지막에 저장		
		if(start == null){   //연결구조 맨 앞이 null일 경우
			start = new trecord(object);
			++size;
			return true;
		}

		for(trecord p = start; p != null; p = p.next){  //맨 앞이 null이 아니고 뒤에 원소가 있는 경우			
			if(p.next == null){  //linked list의 맨 뒷자리를 찾았을 경우 삽입
				p.next = new trecord(object);
				++size;
				return true;
			}
		}return false;
	}
	
	public String getCode(char word){
		for(trecord p = start; p != null; p = p.next){
			if(p.alphabet == word){
				return p.binaryCode;
			}
		}
		return null;
	}
	
	public String getWord(String code){
		for(trecord p = start; p != null; p = p.next){
			if((p.binaryCode).equals(code)){
				return p.alphabet+"";
			}
		}
		return null;
	}
	
	public void print(){
		for(trecord p = start; p != null; p = p.next){
			System.out.println(p.binaryCode + " : "+ p.alphabet);
		}
	}
}