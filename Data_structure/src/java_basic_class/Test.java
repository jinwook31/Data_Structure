package java_basic_class;

public class Test {
	public static void main (String [] args){
		UnderGraduate s1 = new UnderGraduate("±èÁø¿í",2014, 4.0, true);
		Graduate s2 = new Graduate("±èÁø¿í",2012, 3.5, "¼®»ç");
		
		s1.print();
		s1.graduate_year();
		System.out.println("");
		s2.print();
		s2.graduate_year();
	}
}
