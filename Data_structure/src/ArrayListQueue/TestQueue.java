package ArrayListQueue;
import java.util.Scanner;

public class TestQueue {
	public static void main (String [] args){
		ArrayListQueue q1 = new ArrayListQueue();
		Scanner sc = new Scanner(System.in);
		int select=0;
		
		do{
			System.out.print("원소 입력(1), 제거(2), 종료(0) 하시겠습니까? : ");
			select = sc.nextInt();
			
			switch(select){
			case 0:
				q1.print();
				System.out.println("프로그램을 종료...");
				break;
			case 1:
				System.out.print("저장할 원소를 입력하세요 : ");
				q1.addQ(sc.next());
				break;
			case 2:
				if(q1.isEmpty()){
					System.out.println("큐가 비어있습니다.");
				}else{
					System.out.println(q1.removeQ()+"가 삭제되었습니다.");
				}
				break;
			default:
				System.out.println("맨 앞원소 : "+q1.first());
				 System.out.println("다시 입력하시오.");
				 break;
			}
		}while(select!=0);
	}
}