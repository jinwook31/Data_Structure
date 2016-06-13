package java_basic_length;

public class MyLength implements Length {
	private int[] cm;
	private double[] inch;
	private int start, end, term;
	
	public MyLength(int start, int end, int term){
		this.start = start;
		this.end = end;
		this.term = term;
		
		int arr = (int) (end-start)/term;
		cm = new int [arr];
		inch = new double[arr];
	}
	
	@Override
	public double getCM() {
		// TODO Auto-generated method stub
		System.out.print("cm: " + start + " ");
		for(int i =0; i < cm.length; i++){
			System.out.print(cm[i] + " ");
		}
		System.out.println("");
		return 0;
	}

	@Override
	public double getInch() {
		// TODO Auto-generated method stub
		System.out.print("inch: "+ start/2.54 + " ");
		for(int i =0; i < inch.length; i++){
			System.out.print(inch[i] + " ");
		}
		System.out.println("");
		return 0;
	}

	@Override
	public void setCM() {
		// TODO Auto-generated method stub
		for(int i = 0; i < cm.length; i++){
				cm[i] = start + (term*(i+1));
		}
	}

	@Override
	public void setInch() {
		// TODO Auto-generated method stub
		for(int i = 0; i < inch.length; i++){
			inch[i] = cm[i]/(2.54);
		}
	}
}
