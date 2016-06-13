package Topological_Sort;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Stack;

public class Topological_Sort {
		int size;
		Node[] a;			//각 정점당 하나의 리스트를 가지게 한다
		String[] vertices;  //정점들을 저장
		int[] indegree;
		
		public Topological_Sort() throws IOException{
			FileInputStream stream = new FileInputStream("C:/Users/jinWook/Desktop/과제 문서/eclipse/자료구조_설계/src/HW04/hw04");
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
						 indegree = new int[size];
						 
						 for(int i=0; i<size; i++){
							 a[i] = new Node(i);
						 }
						 
					}break;
					
				case StreamTokenizer.TT_WORD:
					if(token.lineno() < size+2 && token.lineno() > 1){
						//정점 입력받음
						vertices[index++] = token.sval;
						
					}else{
						//graph 생성
						if(inputs[0]==null){
							inputs[0] = token.sval;
						}else{
							inputs[1] = token.sval;
							add(inputs[0], inputs[1]);
							indegree[index(inputs[1])]++;
							inputs[0] = null;
							inputs[1] = null;
						}
						
					}break;
				}			
			}
			stream.close();
		}
		
		public void add(String v, String w){
			a[index(v)].add_vertex(index(w));
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
		
		public void topsort(){
			Stack s = new Stack();
			int vert = size;
			
			do{
				//indegree가 0인 정점 stack에 저장
				for(int i=0; i < size; i++){
					if(indegree[i] == 0){
						s.push(i);
					}
				}
				
				//pop
				while(s.size() != 0){
					int p_index = (int)s.pop();
					vert--;
					if(vert != 0) System.out.print(vertices[p_index] + "->");
					else System.out.print(vertices[p_index]);
					
					//1감소
					Node point = a[p_index];
					for(Node p = point; p != null; p = p.next){
						indegree[p.index]--;
					}
				}
				
			}while(vert != 0);
		}
		
		public void printGraph(){
			for(int i=0; i < size; i++){
				Node point = a[i];
				System.out.print(vertices[point.index] + ": ");
				for(Node p = point.next; p != null; p = p.next){
					System.out.print(vertices[p.index]+"  ");
				}System.out.println();
			}
		}
		
		private static class Node{
			int index;
			Node next;
			
			Node(int index){
				this.index = index;
				this.next = null;
			}
			
			Node(int index, Node next){
				this.index = index;
				this.next = next;
			}
			
			public void add_vertex(int index){
				this.next = new Node(index, next);
			}
		}
}