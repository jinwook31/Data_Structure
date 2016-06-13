package java_basic_class;

public class UnderGraduate extends Student {
	boolean army = false;
	
	public UnderGraduate(String name, int year, double grade, boolean army){
		super(name, year, grade);
		this.army = army;
	}
	
	@Override
	public void graduate_year(){
		if(army = true){
			System.out.println("Á¹¾÷³âµµ : " + (year + 6));
		}
		else{
			System.out.println("Á¹¾÷³âµµ : " + (year + 4));
		}
	}
}

