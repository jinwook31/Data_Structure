package java_basic_saveWord;

public class SaveWord {
	String a [] = new String [5];
	
	public SaveWord(){  //배열 초기화
		for(int i = 0; i < a.length; i++){
			a[i]=null;
		}
	}
	
	private String[] resize (String [] word_arr){  //배열의 크기를 2배로 늘려줌
		int n = word_arr.length; 
		String [] temp = new String[2*n];
		System.arraycopy(word_arr, 0, temp, 0, n);
		return temp;
	}
	
	public void SaveWords(String word){   //배열안에 단어를 차례로 저장
		for(int i=0; i < a.length; i++){
			if(a[i]==null){
				a[i]=word;
				break;
			}else if(i == a.length-1){  //배열이 이미 다 차있을 경우
					a = resize(a);
					SaveWords(word);
					break;
				}
		}
	}
	
	public void removeWord(String word){
		for(int i = 0; i < a.length; i++){
			if(a[i] != null){
				if(a[i].compareTo(word) == 0){
					System.arraycopy(a, i+1, a, i, a.length - i - 1);
					a[a.length-1] = null;
				}
			}
		}
	}
	
	 public void sort(){   //배열 안에 있는 단어를 알파벳 순서로 재배열
		 String temp = null;
		 for(int i=0; i < a.length; i++){
			 for(int j = i+1; j < a.length; j++){
				 if(a[j] != null){
					 if(a[i].compareTo(a[j]) > 0){
					 	temp = a[i];
					 	a[i]=a[j];
					 	a[j]=temp;
				 	}
				 }
			 }
		 }
	 }
	
	public void printWord(){  //배열 내에 있는 문자 정렬 후 출력
		System.out.print("저장된 문자 : ");
		for(int i = 0; i < a.length; i++){
			if(a[i] != null){
					System.out.print(a[i] + "  ");
				}else  return;
		}
	}
}
