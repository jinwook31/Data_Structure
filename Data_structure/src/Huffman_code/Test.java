package Huffman_code;

public class Test {
	public static void main(String [] args){
		Huffman h = new Huffman();
		System.out.println("1. 인코딩");
		h.incode();
		
		System.out.println("\n2. 디코딩");
		h.decode();
	}
}
