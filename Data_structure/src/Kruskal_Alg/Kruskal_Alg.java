package Kruskal_Alg;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Kruskal_Alg {
	int size;
	String[] vertices;
	int[][] a;
	
	int[] parent;
	Node T;	
	Node E = new Node(null);
	
	public Kruskal_Alg() throws IOException{
		FileInputStream stream = new FileInputStream("C:/Users/jinWook/Desktop/과제 문서/eclipse/자료구조_설계/src/HW03/hw03");
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
					 a = new int[size][size];
					 for(int i=0; i<size; i++){
						 for(int j=0; j<size; j++){
							 if(i != j){
								 a[i][j] = Integer.MAX_VALUE;
							 }else{
								 a[i][j] = 0;
							 }
						 }
					 }
					 vertices = new String[size];
					 
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
	
	public void add(String v, String w, int weight){  //가져온 문자를 추가  행렬을 true로 변환시킴
		int i = index(v), j= index(w);
		a[i][j] = a[j][i] = weight;
		
		for(Node point = E; point != null; point = point.next){
			if(point.next == null){
				point.add_vertex(i, j, point.next, weight);
				break;
			}else if(point.next.weight > weight){
				point.add_vertex(i, j, point.next, weight);
				break;
			}
		}
	}
	
	public String toString(){
		if(size ==0) return "{}";
		StringBuffer buf = new StringBuffer("{"+vertex(0));
		for(int i=1;i < size;i++)
			buf.append(","+vertex(i));
		return buf + "}";
	}
	
	private int index(String v){
		for(int i=0; i<size; i++)
			if(vertices[i].equals(v)) return i;  //문자의 배열 인덱스 번호 반환 
		return a.length; //잘못 입력된 값
	}
	
	private String vertex(int i){
		StringBuffer buf = new StringBuffer(vertices[i] + ":");
		for(int j=0; j < size; j++)
			if(a[i][j] > 0) buf.append(vertices[j] + " ");
		return buf + "";
	}
	
	public void printGraph(){
		for(int i = 0; i<size; i++){
			System.out.print(vertices[i] + ": ");
			for(int j=0; j<size; j++){
				if(a[i][j] > 0 && a[i][j] != Integer.MAX_VALUE) System.out.print(vertices[j] + ","+ a[i][j] + "   ");
			}
			System.out.println();
		}
	}
	
	//Kruskal's algorithm
	public void weightedunion(int i, int j){  //두 집합의 합집합
		int weight = parent[i] + parent[j];
		
		if(parent[i] > parent[j]){
			parent[i] = j;
			parent[j] = weight;
		}else{
			parent[j] = i;
			parent[i] = weight;
		}
	}
	
	public int collapsingfind(int i){ //한 원소가 속한 집합
		int root = i;
		
		while(parent[root] >= 0){
			root = parent[root];
		}
		
		while(i != root){
			int temp = parent[i];
			parent[i] = root;
			i = temp;
		}		
		
		return root;
	}
	
	public void kruskal(){  //Kruskal 알고리즘 구현, weightedunion() 과 collapsingfind() 메소드 이용, 최소비용 신장트리에 포함된 에지들과 최소비용 출력
		T = new Node(null);
		parent = new int [size];		
		for(int i = 0; i <size; i++)  parent[i] = -1;
		int T_size = 0;
		
		//E간선을 생성할떄부터 weight 크기 순서대로 삽입
		
		while(T_size < size -1 && E.next != null){
			//choose a least cost edge (v,w) from E
			int v = E.next.index1, w = E.next.index2;
			int weight = E.next.weight;
			
			//delete (v,w) from E
			E.next = E.next.next;
			
			if(collapsingfind(v) != collapsingfind(w)){   //if (v,w) does not create a cycle in T
				T.add_vertex(v, w, weight);
				weightedunion(v, w);
				T_size++;
			}
		}
		
		//print path
		System.out.println("Kruskal 알고리즘 결과");
		int cost = 0;
		System.out.println("사용된 Edge: ");
		for(Node point = T.next; point != null; point = point.next){
			System.out.println(vertices[point.index1] + " - " + vertices[point.index2]);
			cost += point.weight;
		}
		System.out.println("최소 비용 :"+ cost);
	}
	
	private static class Node{
		int index1, index2;
		Node next;
		int weight;
		
		Node(Node next){
			this.next = next;
		}
		
		Node(int index1, int index2, Node next, int weight){
			this.index1 = index1;
			this.index2 = index2;
			this.next = next;
			this.weight = weight;
		}
		
		public void add_vertex(int index1, int index2, Node next, int weight){
			this.next = new Node(index1, index2, next, weight);
		}
		
		public void add_vertex(int index1, int index2, int weight){
			this.next = new Node(index1, index2, next, weight);
		}
	}
}
