package Huffman_code;

public class trecord {
	trecord lchild, rchild, next;
	char alphabet = '\0';	int freq;
	String binaryCode;
	
	public trecord(){}
	
	public trecord(trecord input){
		this.alphabet = input.alphabet;
		this.freq = input.freq;
		this.binaryCode = input.binaryCode;
	}
		
	public trecord(char alphabet, int freq, trecord lchild, trecord rchild){
		this.alphabet = alphabet;
		this.freq = freq;
		this.lchild = lchild;
		this.rchild = rchild;
	}
}
