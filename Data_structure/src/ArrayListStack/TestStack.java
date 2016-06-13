package ArrayListStack;

import java.util.Scanner;

public class TestStack {
	public static void main(String [] args){
		ArrayListStack s1 = new ArrayListStack();
		
		Scanner sc = new Scanner(System.in);
		int select=0;
		
		do{
			System.out.print("원소 입력(1), 제거(2), 종료(0) 하시겠습니까? : ");
			select = sc.nextInt();
			
			switch(select){
			case 0:
				s1.print();
				System.out.println("프로그램을 종료...");
				break;
			case 1:
				System.out.print("저장할 원소를 입력하세요 : ");
				s1.push(sc.next());
				break;
			case 2:
				if(s1.isEmpty()){
					System.out.println("큐가 비어있습니다.");
				}else{
					System.out.println(s1.pop()+"가 삭제되었습니다.");
				}
				break;
			default:
				System.out.println("맨 앞원소 : " + s1.peek());
				 System.out.println("다시 입력하시오.");
				 break;
			}
		}while(select!=0);

	}
}
