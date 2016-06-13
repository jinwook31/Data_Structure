package Huffman_code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Huffman {
	MinHeap queue = new MinHeap(30);
	int[] freq = new int[26];  int word = 0;
	LinkedList l;
	String code = "";
	

	public void incode() {
		readFile(0, "book.txt", null);  //빈도수 계산
		
		for (int i = 0; i < freq.length; i++){  //최소 히프 생성
			if(freq[i] != 0){
				trecord input = new trecord((char)(i + 65), freq[i], null, null);
				queue.insert(input);
				queue.minHeap();
				word++;
			}
		}
		
		HuffmanTree();  //허프만 트리 생성
		
		l = new LinkedList();
		HuffmanCode(queue.remove());  //허프만 코드 생성
		l.print();
		
		readFile(1, "book.txt", "incode.txt");  //인코드
		
	}
	
	public void decode(){
		readFile(2, "incode.txt", null);
	}
	
	private void readFile(int op, String read, String write){
		int lineNumber = 0;
		String inputCode = "";
		FileWriter out = null;  PrintWriter bufOut = null;

		try {
			BufferedReader in = new BufferedReader(new FileReader(read));
			if(op==1){
				out = new FileWriter(write);
				bufOut = new PrintWriter(new BufferedWriter(out));
			}
			 
			String line = in.readLine();
			while (line != null) {
				++lineNumber;
				StringTokenizer parser = new StringTokenizer(line, " ,:;-.?!\"");
				while (parser.hasMoreTokens()) {
					String word = parser.nextToken().toUpperCase();
					for (int i = 0; i < word.length(); i++) {
						char input = word.charAt(i);
						
						if(op == 0)  freq[(int)input - 65]++;  //빈도수 계산
						
						else if(op == 1){
							System.out.print(l.getCode(input));  //인코딩
							bufOut.print(l.getCode(input));
						}
						
						else if(op == 2){                    //디코딩
							inputCode += (input+"");
							String result = l.getWord(inputCode);
							if(result != null){
								System.out.print(result);
								inputCode = "";
							}
						}
						
					}
				}
				line = in.readLine();
				if(op != 0){
					System.out.println();
					if(op==1) bufOut.println(" ");
				}
			}
			in.close();
			if(op == 1) bufOut.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	private void HuffmanCode(trecord root){
		if (root == null) return;
			
		root.binaryCode = code;
		if(root.alphabet != '\0'){
			l.add(root);
		}else{
			code += "0";
		}
		HuffmanCode(root.lchild);
		code = root.binaryCode;
		code += "1";
		HuffmanCode(root.rchild);
		code = root.binaryCode;
	}
	
	private void HuffmanTree() {
		for (int i = 1; i < word; i++) {
			trecord tnode = new trecord();
			tnode.lchild = queue.remove();		// 우선순위큐 queue에서 우선 순위가 높은 원소 삭제해서 리턴		
			tnode.rchild = queue.remove();
			tnode.freq = tnode.lchild.freq + tnode.rchild.freq;
			queue.insert(tnode); // 우선순위큐 queue에 새로 생성된 트리 tnode를 삽입
		}
	}
}