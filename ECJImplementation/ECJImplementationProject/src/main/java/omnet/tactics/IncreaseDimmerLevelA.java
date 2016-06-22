package main.java.omnet.tactics;

import main.java.main.OmnetStateData;
import main.java.main.OmnetStatePath;
import main.java.omnet.components.ServerA;

public class IncreaseDimmerLevelA extends IncreaseDimmerLevel {

	public IncreaseDimmerLevelA(){
		latency=1;
		failureWeight=0.05;
	}
	
	@Override
	public String toString(){
	 	return "IncreaseDimmerLevelA";
	}

	@Override
	public void callPerformTactic(OmnetStateData sd) {
		sd.performTactic(this, ServerA.class);
		
	}

	@Override
	public void reallyPerform(OmnetStatePath state) {
		int serverIndex = state.getServerIndex(ServerA.class);
		boolean tacticFail=false;
		if(state.countArray[serverIndex]==0){
			state.setAllStatesValid(false, "unable to increase dimmer level for"
					+this.toString()+". There are no active servers of that type.");
			tacticFail=true;
			state.modifiedDimmerLevel.add(false);
		}else if(state.serverArray[serverIndex].getDimmerLevel() == state.serverArray[serverIndex].getMaxDimmerLevel()){
			state.setAllStatesValid(false, "unable to increase dimmer level for"
					+this.toString()+". The dimmer level is already the highest possible"+
					" in the state.");
			tacticFail=true;
			state.modifiedDimmerLevel.add(false);
		} else{
			state.serverArray[serverIndex].setDimmerLevel(state.serverArray[serverIndex].getDimmerLevel()+1, state);
			state.modifiedDimmerLevel.add(true);
		}
		if(!tacticFail){
			state.alreadyPerformed.add(this);
		}
		state.totalTime += this.getLatency();
		state.pathProbability = state.pathProbability*(1-this.getFailureWeight());
		state.probabilityArray.add(state.pathProbability);
	}

	@Override
	public void reallyUndo(OmnetStatePath state) {
		int serverIndex = state.getServerIndex(ServerA.class);
		state.setAllStatesValid(true,"Undo the IncreaseDimmerLevel tactic");
		if(state.modifiedDimmerLevel.peekLast() != null && state.modifiedDimmerLevel.pollLast()){
			state.serverArray[serverIndex].setDimmerLevel(state.serverArray[serverIndex].getDimmerLevel()-1, state);
		}
		state.totalTime -= this.getLatency();
		if(state.pathProbability == state.probabilityArray.peekLast()){
			state.probabilityArray.removeLast();
		}
		state.pathProbability = state.probabilityArray.pollLast();
	}
}
