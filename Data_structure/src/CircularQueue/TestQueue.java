package CircularQueue;

import java.util.Scanner;

public class TestQueue {
	public static void main (String [] args){
		CircularQueue cq1 = new CircularQueue();
		Scanner sc = new Scanner(System.in);
		int select=0;
		
		do{
			System.out.print("원소 입력(1), 제거(2), 종료(0) 하시겠습니까? : ");
			select = sc.nextInt();
			
			switch(select){
			case 0:
				cq1.printProgress();
				System.out.println("프로그램을 종료...");
				break;
			case 1:
				System.out.print("저장할 원소를 입력하세요 : ");
				cq1.add(sc.next());
				cq1.printProgress();
				break;
			case 2:
				if(cq1.first() != null){
					System.out.println(cq1.remove()+"가 삭제되었습니다.");
					cq1.printProgress();
				}else{
					cq1.remove();
				}
				break;
			}
		}while(select!=0);
	}
}
