package Graph_DFS2;
import java.util.Stack;

public class Graph {
	int size;
	Node[] a;			//각 정점당 하나의 리스트를 가지게 한다
	String[] vertices;  //정점들을 저장
	
	public Graph(String [] args){
		size = args.length;
		a = new Node[size];
		vertices = args;
		for(int i = 0; i < size; i++){
			a[i] = new Node(i, null);
		}
	}
	
	public void add(String v, String w){
		a[index(v)].add_vertex(index(w));
		a[index(w)].add_vertex(index(v));
	}
	
	public String toString(){
		if(size == 0) return "{}";
		StringBuffer buf = new StringBuffer("{"+vertices[0]);
		for(int i = 1; i <size; i++)
			buf.append(","+vertices[i]);
		return buf+"}";
	}
	
	private int index(String v){
		for(int i = 0; i < size; i++)
			if(vertices[i].equals(v)) return i;
		return vertices.length;
	}
	
	public void printNode(){
		for(int i=0; i < size; i++){
			Node point = a[i];
			System.out.print(vertices[point.index] + ": ");
			for(Node p = point; p != null; p = p.next){
				System.out.print(vertices[p.index] + " ");
			}System.out.println();
		}
	}
	
	public void DFS_search(){
		Stack<String> s = new Stack<String>();  //스택, 출력 리스트 초기화
		String[] L = new String [size];
		boolean[] visit = new boolean[size];
		Node point;
		int L_index = 0;
		
		s.push(vertices[0]);  //단계 2~3
		visit[0] =true;
		
		do{										//4~6단계
			point = a[index(s.pop())];
			L[L_index++] = vertices[point.index];
			
			for(Node p = point; p != null; p = p.next){
				if(visit[p.index] == false){
					s.push(vertices[p.index]);
					visit[p.index] = true;
				}
			}
		}while(!s.empty());
		
		printL(L);
	}
	
	private void printL(String[] L){
		System.out.println("깊이 우선 탐색의 결과입니다.");  //출력
		System.out.print("{");
		for(int i=0; i < size; i++){
			if(i != size-1){
				System.out.print(L[i] + "->");
			}else{
				System.out.println(L[i] + "}");
			}
		}
	}
	
	private static class Node{
		int index;
		Node next;
		
		Node(int index, Node next){
			this.index = index;
			this.next = next;
		}
		
		public void add_vertex(int index){
			this.next = new Node(index, next);
		}
	}
}
