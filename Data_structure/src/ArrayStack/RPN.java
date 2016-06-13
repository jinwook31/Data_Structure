package ArrayStack;

import java.util.Scanner;

public class RPN {
	public RPN(String [] args){
		Stack stack = new ArrayStack(args.length);
		double z = 0;
		for(int i = 0; i < args.length; i++){
			String input = args[i];
			if(input == null)break;
			if(isAnOperator(input)){
				double y = Double.parseDouble((String)stack.pop());
				double x = Double.parseDouble((String)stack.pop());
				z = evaluate(x,y,input);
				stack.push(" " + z);
			}
			else stack.push(input);
		}
		System.out.println("결과 값 : " + z);
	}
	
	private boolean isAnOperator(String s){
		return (s.length() == 1 && "ASMD".indexOf(s) >= 0);
	}
	
	private double evaluate(double x, double y, String op){
		double z = 0;
		if(op.equals("A")) z=x+y;
		else if(op.equals("S"))  z= x-y;
		else if(op.equals("M"))  z= x*y;
		else z = x/y;
		return z;
	}
	
	public static String[] invertInfix(String equation){
		
		String[] input = equation.split(" ");
		String [] output = new String [input.length];
		Stack stack = new ArrayStack(input.length);
		int size = 0;
		int opsize = 0;
		
		for(int i = 0; i < input.length; i++){
			
			if(i == input.length -1 && !input[i].equals(")")){                           //마지막 원소일 때 스택안에 연산 기호가 있을경우
				output[size++] = input[i];
				while(opsize != 0){
					output[size++] = (String) stack.pop();
					opsize--;
				}
				break;
			}
			
		
			if(input[i].equals("(")){   	        		     // ( 일 때
				stack.push(input[i]);
				
			}else if("ASMD".indexOf(input[i]) >= 0){       	     // ASMD 중 한개 일 때 & 연산 우선순위
				if(("MD".indexOf(input[i]) >= 0)){
					stack.push(input[i]);
					opsize++;
					
				}else if(((stack.peek()).equals("M") || (stack.peek()).equals("D")) && "AS".indexOf(input[i]) >= 0){
					output[size++] = (String) stack.pop();
					stack.push(input[i]);
					
				}else if((stack.peek()).equals("(") && "AS".indexOf(input[i]) >= 0){
					stack.push(input[i]);
					opsize++;
				}
				
			}else if(input[i].equals(")")){     			      // ) 일 때
				while(!(stack.peek()).equals("(")){
					output[size++] = (String) stack.pop();
					opsize--;
				}
				stack.pop();
					
			}else{   										      //숫자일 때
				output[size++] = input[i];
			}
			
		}
		
		System.out.print("후위식 : ");                             //변환한 식을 출력
		for(int i = 0; i < output.length; i++){
			if(output[i] != null){
				System.out.print(output[i] + " ");
			}
		}System.out.println(" ");
		return output;
	}
	
	
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("중위식을 입력하시오: ");
		args = invertInfix(sc.nextLine());
		new RPN(args);
	}
}