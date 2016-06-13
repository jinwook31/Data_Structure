package ExternalSort;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class sort {
	SLinkedQueue [] q = new SLinkedQueue [8];
	BinarytreeNode [] t = new BinarytreeNode[15];
	int [] result;
	int num=0;
	
	public sort() throws IOException{   //원소 입력 받음
		FileInputStream stream = new FileInputStream("C:/Users/jinWook/Desktop/과제 문서/eclipse/자료구조_설계/src/HW08/input.txt");
		InputStreamReader reader = new InputStreamReader(stream);
		StreamTokenizer token = new StreamTokenizer(reader);
		
		for(int i = 0; i < 8; i++)	q[i] = new SLinkedQueue();  //큐 생성
		
		int linenum=1;
		
		while((token.nextToken() != StreamTokenizer.TT_EOF)){
			if(linenum != token.lineno()){
				q[linenum-1].add(Integer.MAX_VALUE);
				linenum++;  //다음줄로 넘어갔을 경우
			}
			q[linenum-1].add((int)token.nval);
			num++;
		}
		q[7].add(Integer.MAX_VALUE);
		result = new int [num];
		stream.close();
		
		int j = 7;
		for(int i = 14; i >= 0; i--){   //이진 트리 생성
			if(i >= 7){
				t[i] = new BinarytreeNode(q[j--]);
			}else{
				t[i] = new BinarytreeNode(t[2*i+1], t[2*i+2]);
			}
		}
		
		externalsort();
	}
	
	public void print(){
		for(int i=0; i < num; i++){
			System.out.print(result[i] +" ");
			if(result[i] % 10 == 0) System.out.println( );
		}
	}
	
	public void externalsort(){
		result[0] = t[0].element;

		for(int i=1; i < num; i++){  //원소 개수-1 만큼 반복 (시작전에 한번 추출함)
			//Queue에서 새로운 값을 remove하여 노드에 저장
			//result 전값에 들어간 값과 같은 노드를 업데이트!!
			for(int j = 7; j < 15; j++){
				if(result[i-1] == t[j].element){
					t[j].element = (int)t[j].data.remove();
					break;
				}
			}
			
			//후위 순회를 하면서 값 update함
			if(t[0].side == 0) postOrder(t[0].leftchild); 
			else postOrder(t[0].rightchild);
			
			//top의 element, side 결정해줌
			updateNode(t[0]);
			
			result[i] = t[0].element;
		}
	}
	
	private void updateNode(BinarytreeNode node){
		if(node.side == -1){
			//리프 노드 일떄는 무시
		}else if(node.leftchild.element > node.rightchild.element){
			node.side = 1;
			node.element = node.rightchild.element;
		}else{
			node.side = 0;
			node.element = node.leftchild.element;
		}
	}
	
	private void postOrder(BinarytreeNode node) {
		if (node == null)  return;
		postOrder(node.leftchild);
	    postOrder(node.rightchild);
	    updateNode(node);
	}
	
	
	private static class BinarytreeNode{
		int side;  //-1이면 비활성화, 0은 왼쪽, 1은 오른쪽 자식
		int element;    SLinkedQueue data;
		BinarytreeNode leftchild;
		BinarytreeNode rightchild;
		
		BinarytreeNode(BinarytreeNode leftchild, BinarytreeNode rightchild){
			this.data = null;
			this.leftchild = leftchild;
			this.rightchild = rightchild;
			
			if(leftchild.element > rightchild.element){
				this.side = 1;
				this.element = rightchild.element;
			}else{
				this.side = 0;
				this.element = leftchild.element;
			}
		}
		
		BinarytreeNode(SLinkedQueue data){
			this.side = -1;
			this.data = data;
			this.element = (int) data.remove();
			this.leftchild = null;
			this.rightchild = null;
		}
	}
}
