package ListBag;

import java.util.Scanner;

public class TestBag {
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		ListBag b1 = new ListBag();
		boolean done = true;
		int select = 0;
		
		while(select == 0){
			System.out.print("저장할 원소를 입력하세요 : ");
			b1.add(sc.next());
			System.out.print("계속입력하시겠습니까?(예:0 / 아니오:1)");
			select = sc.nextInt();
		}
		
		b1.print();
		select = 0;
		
		while(select == 0){
			System.out.print("제거할 원소를 입력하세요 : ");
			done = b1.remove(sc.next());
			if(done == true){
				System.out.print("계속입력하시겠습니까?(예:0 / 아니오:1)");
				select = sc.nextInt();
			}else if(done == false){
				System.out.println("입력한 원소가 존재하지 않습니다.");
				System.out.print("계속입력하시겠습니까?(예:0 / 아니오:1)");
				select = sc.nextInt();
			}
		}
		b1.print();
	}
}
