package ArrayQueue_Client;

public class SimServer implements Server {

	private Client client;
	private int id;
	private int meanServiceTime;
	private int stopTime = -1;
	@SuppressWarnings("unused")
	private java.util.Random random;

	public SimServer(int serverid, int mst) {
		id = serverid;
		meanServiceTime = mst;
		random = new ExponentialRandom(meanServiceTime);
	}
	
	public int getMeanServiceTime() {
		return meanServiceTime;
	}
	
	public int getStopTime() {
		return stopTime;
	}
	
	public boolean isIdle() {
		return client == null;
	}
	
	public void startServing(Client c, int t) {
		client = c;
		client.setStartTime(t);
		//stopTime = t + random.nextInt();
		stopTime = t + meanServiceTime;
		System.out.println(this + " started serving " + client + " at time " + t + " and will finish at time " + stopTime);
	}
	
	public void stopServing(int t) {
		client.setStopTime(t);
		System.out.println(this + " stopped serving " + client + " at time "+ t);
		client = null;
	}
	
	public String toString() {
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		return "Server " + s.charAt(id);
	}
}