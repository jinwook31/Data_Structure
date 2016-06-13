package java_basic_saveWord;

import java.util.Scanner;

public class Test {
	public static void main(String [] args){
		int select1 = 0;
		int select2 = 0;
		Scanner sc = new Scanner(System.in);
		SaveWord sw1 = new SaveWord();
		
		while(select1 == 0){
			System.out.print("단어를 입력하시오 : ");
			sw1.SaveWords(sc.next());
			System.out.print("단어를 계속 입력하시겠습니까?(0:예, 1:아니오) : ");
			select1 = sc.nextInt();
		}
		
		sw1.sort();
		sw1.printWord();
		System.out.println(" ");
		
		while(select2 == 0){
			System.out.print("지울 단어를 입력하시오 : ");
			sw1.removeWord(sc.next());
			System.out.print("단어를 계속 입력하시겠습니까?(0:예, 1:아니오) : ");
			select2 = sc.nextInt();
		}
		sw1.printWord();  //삭제후 문자들 출력
	}
}

