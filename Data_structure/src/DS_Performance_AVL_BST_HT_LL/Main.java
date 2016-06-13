package DS_Performance_AVL_BST_HT_LL;

import java.io.*;
import java.util.StringTokenizer;

public class Main{
	
	static HashTable h = new HashTable(30);
	static LinkedList l = new LinkedList();
	static BinarySearchTree b = new BinarySearchTree();
	static AVLTree a;
	
	private static long htime=0, ltime=0, btime=0, atime=0;
	private long startTime = 0;
	private long endTime = 0;
	
	public Main(String file){
		int lineNumber = 0;
		boolean first = true;
		
		try{
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line = in.readLine();
			while(line != null){
				++lineNumber;
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!");
				while(parser.hasMoreTokens()){  //단어를 한개씩 입력받음
					
					String word = parser.nextToken().toUpperCase();
					
					startTime = System.nanoTime();
					l.add(word);  //단일 연결 구조 삽입
					endTime = System.nanoTime();
					ltime += endTime - startTime;
					
					startTime = System.nanoTime();
					b.add(word);  //이진 트리 삽입
					endTime = System.nanoTime();
					btime += endTime - startTime;
					
					if(first){
						startTime = System.nanoTime();
						a = new AVLTree(word);
						endTime = System.nanoTime();
						first = false;		
					}else{
						startTime = System.nanoTime();
						a.add(word);
						endTime = System.nanoTime();
					}
					atime += endTime - startTime;
					
					startTime = System.nanoTime();
					//h.put(word, word);  //해쉬 삽입
					endTime = System.nanoTime();
					htime += endTime - startTime;
				}
				line = in.readLine();
			}
			in.close();
		}catch(IOException e){System.out.println(e);}
	}
	
	public static void main(String[] args){	
		h.setMode(2);  //이중해싱 사용
		
		new Main("C:/Users/jinWook/Desktop/과제 문서/eclipse/자료구조_설계/src/HW07/example.txt");	
		
		System.out.println("1. 단일 연결리스트 결과  ");
		l.print();
		
		System.out.println("\n2. 이진 탐색 트리 결과  ");
		b.inorderPrint();
		
		System.out.println("\n3. AVLTree 결과  ");
		a.toString();
		
		System.out.println("\n4. 이중 해싱 결과  ");
		//h.Print();
		
		System.out.println("\n------------------------------------------------------\n");
		System.out.println("성능 비교 (삽입 총 소요 시간)");
		
		System.out.println("1. 단일 연결  : " + ltime);
		System.out.println("2. 이진 탐색  : " + btime);
		System.out.println("3. AVL 트리 : " + atime);
		System.out.println("4. 이중 해싱 : " + htime);
		
	}
}