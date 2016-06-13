package ArrayQueue_Client2;

public class ExponentialRandom extends java.util.Random {
	
	private static final long serialVersionUID = 1L;
	private double mean;
	
	public ExponentialRandom(double mean) {
		super(System.currentTimeMillis());
		this.mean = mean;
	}
	public double nextDouble() {
		return -mean*Math.log(1.0-super.nextDouble());
		
		}
	public int nextInt() { 
		return (int)Math.ceil(nextDouble());
	}

}
