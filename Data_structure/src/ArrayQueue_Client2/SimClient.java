package ArrayQueue_Client2;

public class SimClient implements Client {

	int id;
	int arrivalTime = -1;
	int startTime = -1;
	int stopTime = -1;
	public SimClient(int id, int t) {
		this.id = id;
		arrivalTime = t;
		System.out.println(this + " arrived at time " + t);
	}
	public int getStartTIme() {
		return startTime;
	}
	public int getStopTime() {
		return stopTime;
	}
	public void setStartTime(int t) {
		startTime = t;
	}
	public void setStopTime(int t) {
		stopTime = t;
	}
	public String toString() {
		return "Client " + id;
	}
}