package ecj.actions;

import ec.EvolutionState;
import ec.Problem;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;
import ec.gp.GPNode;
import ecj.StateData;
import generalomnet.tactics.DecreaseDimmer;
import generalomnet.tactics.DecreaseTraffic;

public abstract class DecreaseTrafficLevel extends GPNode {

	String target;
	
	public DecreaseTrafficLevel(String target){
		this.target = target;
	}
	
	public void eval(final EvolutionState state,
			final int thread,
			final GPData input,
			final ADFStack stack,
			final GPIndividual individual,
			final Problem problem)
	{
		
		StateData o = (StateData)input;
		
		o.plan.getTactics().add(new DecreaseTraffic(target));
		
	}
	
	@Override
	public String toString(){
		return "DecreaseTrafficLevel"+target;
	}
	
}