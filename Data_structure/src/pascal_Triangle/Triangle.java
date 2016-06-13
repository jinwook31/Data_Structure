package pascal_Triangle;
import java.util.Scanner;

public class Triangle {
	static int[][] count;
	static int num = 0;
	
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("행의 개수를 입력하시오 : ");
		int n = sc.nextInt();
		count = new int [n][n];
		
		System.out.println("파스칼의 삼각형 ");
		for(int i = 0; i < n; i++){
			for(int j = 0; j <= i; j++){
				num = 0;
				System.out.print(pascal(i,j) + " ");
				count[i][j] = num;
			}
			System.out.println("");
		}
		
		System.out.print("\n호출 횟수 \n");
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n;j++){
				if(count[i][j] != 0)
					System.out.print(count[i][j] +" ");
			}
			System.out.println(" ");
		}
	}
	
	public static int pascal(int n, int k){
		if(n == k){
			num++;
			return 1;
		}else if(k == 0){
			num++;
			return 1;
		}else{
			num++;
			return pascal(n-1,k-1) + pascal(n-1,k);
		}
	}
}