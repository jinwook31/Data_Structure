package java_basic_class;

public class Student {
	String name = null;
	int year = 0;
	private double grade = 0;  //전용필드
	
	public Student(String name, int year, double grade){
		this.name = name;
		this.year = year;
		this.grade = grade;
	}
	
	public void graduate_year (){
		System.out.println("졸업년도 : " + (year + 4));
	}
	
	public void print(){
		System.out.println("이름: "+ name);
		System.out.println("입학 년도: "+ year);
		System.out.println("학점: "+ grade);
	}
}

