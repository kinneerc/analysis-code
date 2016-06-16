package main.java.omnet.tactics;

import main.java.main.OmnetStateData;
import main.java.omnet.components.ServerE;

public class IncreaseTrafficLevelE extends IncreaseTrafficLevel {

	public IncreaseTrafficLevelE(){
		latency=5;
		failureWeight=0.01;
	}
	
	
	@Override
	public String toString(){
	 	return "IncreaseTrafficLevelE";
	}

	@Override
	public void callPerformTactic(OmnetStateData sd) {
		sd.performTactic(this, ServerE.class);
		
	}
	


}