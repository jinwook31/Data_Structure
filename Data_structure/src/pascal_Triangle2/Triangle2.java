package pascal_Triangle2;
import java.util.Scanner;

public class Triangle2 {
	static int[][] func, count;
	static int num;
	
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("행의 개수를 입력하시오 : ");
		int n = sc.nextInt();
		func = new int [n][n];
		count = new int [n][n];
		
		System.out.println("파스칼의 삼각형 ");
		for(int i = 0; i < n; i++){
			for(int j = 0; j <= i; j++){
				num = 0;
				pascal(i,j);
				count[i][j] = num;
			}
		}
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n;j++){
				if(func[i][j] != 0)
					System.out.print(func[i][j] +" ");
			}
			System.out.println(" ");
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
	
	public static void pascal(int n, int k){
		if(n == k){
			num++;
			func[n][k] = 1;
		}else if(k == 0){
			num++;
			func[n][k] = 1;
		}else{
			num++;
			func[n][k] = func[n-1][k] + func[n-1][k-1];
		}
	}
}