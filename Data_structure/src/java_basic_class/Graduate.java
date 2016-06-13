package java_basic_class;

public class Graduate extends Student{
	String degree = null;
	
	public Graduate(String name, int year, double grade, String degree){
		super(name, year, grade);
		this.degree = degree;
	}
	
	@Override
	public void graduate_year() {
		if(degree == "석사"){
			System.out.println("졸업년도(석사) : "+ (year + 2)); //석사
		}
		else if(degree == "박사"){
			System.out.println("졸업년도(박사) : "+ (year + 5)); //박사
		}
		else{
			System.out.println("잘못입력하셨습니다.");
		}
	}
}

