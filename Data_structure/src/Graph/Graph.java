package Graph;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;
import java.util.Stack;

public class Graph {
	int size;
	Node[] a;			//각 정점당 하나의 리스트를 가지게 한다
	String[] vertices;  //정점들을 저장
	
	boolean[] visited;
	String[] prev;
	int[] dist;
	
	public Graph() throws IOException{
		FileInputStream stream = new FileInputStream("C:/Users/jinWook/Desktop/과제 문서/eclipse/자료구조_설계/src/HW02/hw02");
		InputStreamReader reader = new InputStreamReader(stream);
		StreamTokenizer token = new StreamTokenizer(reader);
		
		int index = 0;
		String[] inputs = {null,null};
		
		while((token.nextToken() != StreamTokenizer.TT_EOF)){			
			switch(token.ttype){
			case StreamTokenizer.TT_NUMBER:
				if(token.lineno() == 1){  
					//파일의 첫 번째 줄, 정점의 수
					 this.size = (int)token.nval;
					 a = new Node[size];
					 vertices = new String[size];
					 
					 for(int i=0;i < size; i++){
						a[i] = new Node(i, null); 
					 }
					 
				}else{
					//가중치일때
					add(inputs[0], inputs[1], (int)token.nval);
					inputs[0] = inputs[1] = null;
					
				}break;
				
			case StreamTokenizer.TT_WORD:
				if(token.lineno() < size+2 && token.lineno() > 1){
					//정점 입력받음
					vertices[index++] = token.sval;
					
				}else{
					//가중치 graph 생성
					if(inputs[0]==null){
						inputs[0] = token.sval;
					}else{
						inputs[1] = token.sval;
					}
					
				}break;
			}			
		}
		stream.close();
	}
	
	public void add(String v, String w, int weight){
		a[index(v)].add_vertex(index(w), weight);
		a[index(w)].add_vertex(index(v), weight);
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
	
	private void dijkstra(String V){
		visited = new boolean[size];
		prev = new String[size];
		dist = new int[size];
		for(int i = 0; i < size; i++)	this.dist[i] = Integer.MAX_VALUE;  //dist를 무한대로 설정
		
		prev[index(V)] = null;
		dist[index(V)] = 0;
		
		for(Node point = a[index(V)]; point != null; point = findShortestDist()){
			
			for(int i = 0; i < size;i++){
				System.out.print(visited[i]+"  ");
			}System.out.println();
			
			visited[point.index] = true;
			for(Node p = point.next; p != null; p = p.next){
				int P_index = p.index;
				if(!visited[P_index] && dist[point.index] + p.weight < dist[P_index]){
					dist[P_index] = dist[point.index] + p.weight;
					prev[P_index] = vertices[point.index];
				}
			}
		}
	}
	
	private Node findShortestDist(){
		int M_dist = Integer.MAX_VALUE;
		Node min = null;
		
		for(int i = 0; i < size; i++){
			Node point = a[i];
			if(M_dist > dist[i] && !visited[i]){
				M_dist = dist[i];
				min = point;
			}
		}
		
		if(M_dist == Integer.MAX_VALUE || M_dist == 0){
			return null;
		}else{
			return min;
		}
	}
	
	public void printpath(){
		Stack<String> s = new Stack<String>();
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<size; i++){
			System.out.print(vertices[i]+" ");
		}System.out.println("총 " + size + "개의 정점(Vertex)이 있습니다. 출발점을 입력하시오:");
		String input = sc.nextLine();
		
		dijkstra(input);
		
		for(int i = 0; i < size; i++){
			System.out.print(vertices[i] + ": 거리" +  dist[i] + " / ");
			if(index(input) == i){    //출발지점일 때
				System.out.println("출발점");
			}else if(prev[i].equals(input)){  //한번에 도착할 때
				System.out.println(input + "->" + vertices[i]);
			}else{  
				int p = i;
				do{
					s.push(vertices[p]);
					p = index(prev[p]);
				}while(!(s.peek()).equals(input));
				
				do{
					if((s.peek()).equals(vertices[i])){
						System.out.println(s.pop());
					}else{
						System.out.print(s.pop() + "->");
					}
				}while(!s.isEmpty());
			}
		}
	}
	
	public void printGraph(){
		for(int i=0; i < size; i++){
			Node point = a[i];
			System.out.print(vertices[point.index] + ": ");
			for(Node p = point.next; p != null; p = p.next){
				System.out.print(vertices[p.index] + "," + p.weight +"  ");
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
		
		printDFS(L);
	}
	
	private void printDFS(String[] L){
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
		int weight;
		
		Node(int index, Node next){
			this.index = index;
			this.next = next;
		}
		
		Node(int index, Node next, int weight){
			this.index = index;
			this.next = next;
			this.weight = weight;
		}
		
		public void add_vertex(int index, int weight){
			this.next = new Node(index, next, weight);
		}
	}
}
