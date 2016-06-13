package java_basic_ArraySet;

public class TestEqualset {
	public static void main(String [] args){
		ArraySet a1 = new ArraySet();
		ArraySet a2 = new ArraySet();
		
		System.out.println("객체1 입력");
		a1.askAdd();
		System.out.println("객체2 입력");
		a2.askAdd();
		
		equalset(a1,a2);
	}
	
	public static void equalset(ArraySet a1, ArraySet a2){
		int same = 0;
		if(a1.size() == a2.size()){
			for(int i = 0; i < a1.size(); i++){
				for(int j=0; j < a2.size(); j++){
					if(a1.getObject(i).equals(a2.getObject(j))){
						++same;
					}
				}
			}
			if(same == a1.size()){
				System.out.println("두 객체 안의 원소가 서로 같습니다.");
			}else{
				System.out.println("두 객체 안의 원소가 서로 다릅니다.");
			}
		}else{
			System.out.println("두 객체 안의 원소가 서로 다릅니다.");
		}
	}
}