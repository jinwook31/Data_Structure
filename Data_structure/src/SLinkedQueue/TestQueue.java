package SLinkedQueue;

import java.util.Scanner;

public class TestQueue {
	public static void main (String [] args){
		SLinkedQueue sq1 = new SLinkedQueue();
		Scanner sc = new Scanner(System.in);
		int select=0;
		
		do{
			System.out.print("원소 입력(1), 제거(2), 종료(0) 하시겠습니까? : ");
			select = sc.nextInt();
			
			switch(select){
			case 0:
				sq1.printProgress();
				System.out.println("프로그램을 종료...");
				break;
			case 1:
				System.out.print("저장할 원소를 입력하세요 : ");
				sq1.add(sc.next());
				sq1.printProgress();
				break;
			case 2:
				if(sq1.isEmpty()){
					System.out.println("큐가 비어있습니다.");
				}else if(sq1.first() != null){
					System.out.println(sq1.remove()+"가 삭제되었습니다.");
					sq1.printProgress();
				}else{
					sq1.remove();
				}
				break;
			}
		}while(select!=0);
	}
}
