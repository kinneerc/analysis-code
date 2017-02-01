package omnet.components;

import java.util.Hashtable;

public class Server {
	
	// the cost per second
	protected double cost;
	// the computational power
	protected double power;
	// the dimmer settings
	public static final int MAX_DIMMER_LVL = 4;
	public static final int MIN_DIMMER_LVL = 0;
	private int dimmer;
	// the requested traffic ratio
	public static final int MAX_TRAFFIC_LVL = 4;
	public static final int MIN_TRAFFIC_LVL = 0;
	private int traffic;
	
	// server name to keep track of multiple servers
	private String name;
	
	private boolean validState;
	
	protected double powerPerNormal;
	protected double powerPerDimmed;
	protected long latency;
	
	static Hashtable<String,Integer> startTraffic = new Hashtable<String,Integer>();
	static Hashtable<String,Integer> startDimmer = new Hashtable<String,Integer>();
	
	public Server(String name){
		this.name = name;
		
		// provide default values
		dimmer = 0;
		traffic = 4;
		
		powerPerNormal = 2;
		powerPerDimmed = 1;
		
		power = 200;
		
		cost = 1;
		
		latency = 120;
		
		validState = true;
		
		Integer starting;
		
		if( (starting = startDimmer.get(name.charAt(0)+"")) != null ){
			dimmer = starting;
		}
		if( (starting= startTraffic.get(name.charAt(0)+"")) != null ){
			traffic = starting;
		}
	
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getDimmer() {
		return dimmer;
	}

	public void setDimmer(int dimmer) {
		if (dimmer > MAX_DIMMER_LVL || dimmer < MIN_DIMMER_LVL){
			validState = false;
		}else{
			this.dimmer = dimmer;
			startDimmer.put(name.charAt(0)+"", dimmer);
		}
	}

	public int getTraffic() {
		return traffic;
	}

	public void setTraffic(int traffic) {
		if (traffic > MAX_TRAFFIC_LVL || traffic < MIN_TRAFFIC_LVL){
			validState = false;
		}else{
			this.traffic = traffic;
			startTraffic.put(name.charAt(0)+"", traffic);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isValid(){
		return validState;
	}
	
	public Object clone(){
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public double getPower() {
		return power;
	}

	public double getPowerPerNormal() {
		return powerPerNormal;
	}

	public double getPowerPerDimmed() {
		return powerPerDimmed;
	}

	public long getLatency() {
		return latency;
	}
	
	public static void reset(){
		startTraffic = new Hashtable<String,Integer>();
		startDimmer = new Hashtable<String,Integer>();
	}
	
	

}
