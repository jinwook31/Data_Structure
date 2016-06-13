package Graph_DFS;
import java.util.Stack;

public class Graph {
	int size;
	String[] vertices;
	boolean[][] a;
	
	
	public Graph(String[] args){  //args에서 문자 가져움
		size = args.length;
		vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		a = new boolean[size][size];
	}
	
	public void add(String v, String w){  //가져온 문자를 추가  행렬을 true로 변환시킴
		int i = index(v), j= index(w);
		a[i][j] = a[j][i] = true;
	}
	
	public String toString(){    //결과값 출력 메소드
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
			if(a[i][j]) buf.append(vertices[j] + " ");
		return buf + "";
	}
	
	public void DFS_search(){
		Stack<String> s = new Stack<String>();  //스택, 출력 리스트 초기화
		String[] L = new String [size];
		String point = null;
		int L_index = 0;
		boolean[] visit = new boolean[size];
		
		s.push(vertices[0]);  //단계 2~3
		visit[0] =true;
		L[L_index] = point = (String) s.pop();
		
		do{										//4~6단계
			for(int i = 0; i<size; i++){
				if(a[index(point)][i] && visit[i] == false){
					s.push(vertices[i]);
					visit[i] = true;
				}
			}
			point = (String) s.pop();
			L[++L_index] = point;
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
}


