package main.java.tests;

import ec.EvolutionState;
import ec.Evolve;
import ec.gp.ADFStack;
import ec.gp.GPData;
import ec.gp.GPIndividual;
import ec.gp.GPNode;
import ec.gp.GPTree;
import ec.util.ParameterDatabase;
import main.java.actions.FailableTactic;
import main.java.actions.operators.SequenceOperator;
import main.java.main.OmnetStateData;
import main.java.main.OmnetStatePath;
import main.java.main.SingleObjectiveProblem;
import main.java.omnet.components.ServerA;
import main.java.omnet.tactics.DecreaseDimmerLevelA;
import main.java.omnet.tactics.DecreaseDimmerLevelB;
import main.java.omnet.tactics.DecreaseDimmerLevelC;
import main.java.omnet.tactics.DecreaseDimmerLevelD;
import main.java.omnet.tactics.DecreaseDimmerLevelF;
import main.java.omnet.tactics.DecreaseTrafficLevelA;
import main.java.omnet.tactics.DecreaseTrafficLevelB;
import main.java.omnet.tactics.DecreaseTrafficLevelD;
import main.java.omnet.tactics.DecreaseTrafficLevelG;
import main.java.omnet.tactics.IncreaseDimmerLevelA;
import main.java.omnet.tactics.IncreaseDimmerLevelB;
import main.java.omnet.tactics.IncreaseDimmerLevelC;
import main.java.omnet.tactics.IncreaseDimmerLevelD;
import main.java.omnet.tactics.IncreaseDimmerLevelE;
import main.java.omnet.tactics.IncreaseDimmerLevelF;
import main.java.omnet.tactics.IncreaseTrafficLevelA;
import main.java.omnet.tactics.IncreaseTrafficLevelB;
import main.java.omnet.tactics.IncreaseTrafficLevelC;
import main.java.omnet.tactics.IncreaseTrafficLevelD;
import main.java.omnet.tactics.IncreaseTrafficLevelE;
import main.java.omnet.tactics.IncreaseTrafficLevelF;
import main.java.omnet.tactics.IncreaseTrafficLevelG;
import main.java.omnet.tactics.ServerTactic;
import main.java.omnet.tactics.ShutdownServerA;
import main.java.omnet.tactics.ShutdownServerB;
import main.java.omnet.tactics.ShutdownServerC;
import main.java.omnet.tactics.ShutdownServerD;
import main.java.omnet.tactics.ShutdownServerE;
import main.java.omnet.tactics.ShutdownServerF;
import main.java.omnet.tactics.ShutdownServerG;
import main.java.omnet.tactics.StartNewServerA;
import main.java.omnet.tactics.StartNewServerB;
import main.java.omnet.tactics.StartNewServerC;
import main.java.omnet.tactics.StartNewServerF;
import main.java.omnet.tactics.StartNewServerG;

public class TestUndoTactics {
	
	public static void build(GPIndividual ind){
	
		//building a plan tree
		GPTree[] treeInit = {new GPTree()};
		ind.trees = treeInit;
		GPNode node1 = new SequenceOperator();
		GPNode node2 = new IncreaseDimmerLevelA();
		GPNode node3 = new SequenceOperator();
		GPNode node4 = new IncreaseDimmerLevelA();
		GPNode node5 = new SequenceOperator();
		GPNode node6 = new IncreaseDimmerLevelA();
		GPNode node7 = new SequenceOperator();
		GPNode node8 = new DecreaseDimmerLevelA();
		GPNode node9 = new SequenceOperator();
		GPNode node10 = new IncreaseDimmerLevelE();
		GPNode node11 = new SequenceOperator();
		GPNode node12 = new DecreaseDimmerLevelA();
		GPNode node13 = new SequenceOperator();
		GPNode node14 = new DecreaseDimmerLevelC();
		GPNode node15 = new SequenceOperator();
		GPNode node16 = new DecreaseDimmerLevelD();
		GPNode node17 = new SequenceOperator();
		GPNode node18 = new DecreaseDimmerLevelA();
		GPNode node19 = new SequenceOperator();
		GPNode node20 = new DecreaseTrafficLevelB();
		GPNode node21 = new SequenceOperator();
		GPNode node22 = new ShutdownServerC();
		GPNode node23 = new SequenceOperator();
		GPNode node24 = new DecreaseTrafficLevelG();
		
		GPNode[] childrenOfNode1 = new GPNode[2];
		GPNode[] childrenOfNode2 = new GPNode[0];
		GPNode[] childrenOfNode3 = new GPNode[2];
		GPNode[] childrenOfNode4 = new GPNode[0];
		GPNode[] childrenOfNode5 = new GPNode[2];
		GPNode[] childrenOfNode6 = new GPNode[0];
		GPNode[] childrenOfNode7 = new GPNode[2];
		GPNode[] childrenOfNode8 = new GPNode[0];
		GPNode[] childrenOfNode9 = new GPNode[2];
		GPNode[] childrenOfNode10 = new GPNode[0];
		GPNode[] childrenOfNode11 = new GPNode[2];
		GPNode[] childrenOfNode12 = new GPNode[0];
		GPNode[] childrenOfNode13 = new GPNode[2];
		GPNode[] childrenOfNode14 = new GPNode[0];
		GPNode[] childrenOfNode15 = new GPNode[2];
		GPNode[] childrenOfNode16 = new GPNode[0];
		GPNode[] childrenOfNode17 = new GPNode[2];
		GPNode[] childrenOfNode18 = new GPNode[0];
		GPNode[] childrenOfNode19 = new GPNode[2];
		GPNode[] childrenOfNode20 = new GPNode[0];
		GPNode[] childrenOfNode21 = new GPNode[2];
		GPNode[] childrenOfNode22 = new GPNode[0];
		GPNode[] childrenOfNode23 = new GPNode[1];
		GPNode[] childrenOfNode24 = new GPNode[0];
		
		childrenOfNode1[0] = node2;
		childrenOfNode1[1] = node3;
//		childrenOfNode2[0] = null;
//		childrenOfNode2[1] = null;
		childrenOfNode3[0] = node4;
		childrenOfNode3[1] = node5;
//		childrenOfNode4[0] = null;
//		childrenOfNode4[1] = null;
		childrenOfNode5[0] = node6;
		childrenOfNode5[1] = node7;
//		childrenOfNode6[0] = null;
//		childrenOfNode6[1] = null;
		childrenOfNode7[0] = node8;
		childrenOfNode7[1] = node9;
//		childrenOfNode8[0] = null;
//		childrenOfNode8[1] = null;
		childrenOfNode9[0] = node10;
		childrenOfNode9[1] = node11;
//		childrenOfNode10[0] = null;
//		childrenOfNode10[1] = null;
		childrenOfNode11[0] = node12;
		childrenOfNode11[1] = node13;
//		childrenOfNode12[0] = null;
//		childrenOfNode12[1] = null;
		childrenOfNode13[0] = node14;
		childrenOfNode13[1] = node15;
//		childrenOfNode14[0] = null;
//		childrenOfNode14[1] = null;
		childrenOfNode15[0] = node16;
		childrenOfNode15[1] = node17;
//		childrenOfNode16[0] = null;
//		childrenOfNode16[1] = null;
		childrenOfNode17[0] = node18;
		childrenOfNode17[1] = node19;
//		childrenOfNode18[0] = null;
//		childrenOfNode18[1] = null;
		childrenOfNode19[0] = node20;
		childrenOfNode19[1] = node21;
//		childrenOfNode20[0] = null;
//		childrenOfNode20[1] = null;
		childrenOfNode21[0] = node22;
		childrenOfNode21[1] = node23;
//		childrenOfNode22[0] = null;
//		childrenOfNode22[1] = null;
		childrenOfNode23[0] = node24;
//		childrenOfNode23[1] = null;
//		childrenOfNode24[0] = null;
//		childrenOfNode24[1] = null;
		
		ind.trees[0].child=node1;
		node1.children = childrenOfNode1;
		node2.children = childrenOfNode2;
		node3.children = childrenOfNode3;
		node4.children = childrenOfNode4;
		node5.children = childrenOfNode5;
		node6.children = childrenOfNode6;
		node7.children = childrenOfNode7;
		node8.children = childrenOfNode8;
		node9.children = childrenOfNode9;
		node10.children = childrenOfNode10;
		node11.children = childrenOfNode11;
		node12.children = childrenOfNode12;
		node13.children = childrenOfNode13;
		node14.children = childrenOfNode14;
		node15.children = childrenOfNode15;
		node16.children = childrenOfNode16;
		node17.children = childrenOfNode17;
		node18.children = childrenOfNode18;
		node19.children = childrenOfNode19;
		node20.children = childrenOfNode20;
		node21.children = childrenOfNode21;
		node22.children = childrenOfNode22;
		node23.children = childrenOfNode23;
		node24.children = childrenOfNode24;
		node1.parent = ind.trees[0];
		node2.parent = node1;
		node3.parent = node1;
		node4.parent = node3;
		node5.parent = node3;
		node6.parent = node5;
		node7.parent = node5;
		node8.parent = node7;
		node9.parent = node7;
		node10.parent = node9;
		node11.parent = node9;
		node12.parent = node11;
		node13.parent = node11;
		node14.parent = node13;
		node15.parent = node13;
		node16.parent = node15;
		node17.parent = node15;
		node18.parent = node17;
		node19.parent = node17;
		node20.parent = node19;
		node21.parent = node19;
		node22.parent = node21;
		node23.parent = node21;
		node24.parent = node23;
	}
	
	public static void build2(GPIndividual ind){
		//4 actions plan
		GPTree[] treeInit = {new GPTree()};
		ind.trees = treeInit;
		GPNode node1 = new SequenceOperator();
		GPNode node2 = new IncreaseDimmerLevelA();
		GPNode node3 = new SequenceOperator();
		GPNode node4 = new DecreaseDimmerLevelA();
		GPNode node5 = new SequenceOperator();
		GPNode node6 = new DecreaseDimmerLevelA();
		GPNode node7 = new SequenceOperator();
		GPNode node8 = new ShutdownServerC();
		
		GPNode[] childrenOfNode1 = new GPNode[2];
		GPNode[] childrenOfNode2 = new GPNode[0];
		GPNode[] childrenOfNode3 = new GPNode[2];
		GPNode[] childrenOfNode4 = new GPNode[0];
		GPNode[] childrenOfNode5 = new GPNode[2];
		GPNode[] childrenOfNode6 = new GPNode[0];
		GPNode[] childrenOfNode7 = new GPNode[1];
		GPNode[] childrenOfNode8 = new GPNode[0];
		
		childrenOfNode1[0] = node2;
		childrenOfNode1[1] = node3;
//		childrenOfNode2[0] = null;
//		childrenOfNode2[1] = null;
		childrenOfNode3[0] = node4;
		childrenOfNode3[1] = node5;
//		childrenOfNode4[0] = null;
//		childrenOfNode4[1] = null;
		childrenOfNode5[0] = node6;
		childrenOfNode5[1] = node7;
//		childrenOfNode6[0] = null;
//		childrenOfNode6[1] = null;
		childrenOfNode7[0] = node8;
//		childrenOfNode7[1] = null;
//		childrenOfNode8[0] = null;
//		childrenOfNode8[1] = null;
		
		ind.trees[0].child=node1;
		node1.children = childrenOfNode1;
		node2.children = childrenOfNode2;
		node3.children = childrenOfNode3;
		node4.children = childrenOfNode4;
		node5.children = childrenOfNode5;
		node6.children = childrenOfNode6;
		node7.children = childrenOfNode7;
		node8.children = childrenOfNode8;
		node1.parent = ind.trees[0];
		node2.parent = node1;
		node3.parent = node1;
		node4.parent = node3;
		node5.parent = node3;
		node6.parent = node5;
		node7.parent = node5;
		node8.parent = node7;

	}
	
	public static void build3(GPIndividual ind){
		//4 actions plan
		GPTree[] treeInit = {new GPTree()};
		ind.trees = treeInit;
		GPNode node1 = new SequenceOperator();
		GPNode node2 = new SequenceOperator();
		GPNode node3 = new SequenceOperator();
		GPNode node4 = new StartNewServerA();
		GPNode node5 = new StartNewServerB();
		GPNode node6 = new StartNewServerC();

		
		GPNode[] childrenOfNode1 = new GPNode[2];
		GPNode[] childrenOfNode2 = new GPNode[2];
		GPNode[] childrenOfNode3 = new GPNode[1];
		GPNode[] childrenOfNode4 = new GPNode[0];
		GPNode[] childrenOfNode5 = new GPNode[0];
		GPNode[] childrenOfNode6 = new GPNode[0];

		
		childrenOfNode1[0] = node2;
		childrenOfNode1[1] = node3;
		childrenOfNode2[0] = node4;
		childrenOfNode2[1] = node5;
		childrenOfNode3[0] = node6;
		
		
		ind.trees[0].child=node1;
		node1.children = childrenOfNode1;
		node2.children = childrenOfNode2;
		node3.children = childrenOfNode3;
		node4.children = childrenOfNode4;
		node5.children = childrenOfNode5;
		node6.children = childrenOfNode6;

		node1.parent = ind.trees[0];
		node2.parent = node1;
		node3.parent = node1;
		node4.parent = node2;
		node5.parent = node2;
		node6.parent = node3;


	}
	public static void main(String[] args) throws InstantiationException{	
		
		OmnetStateData sd = new OmnetStateData();
		GPIndividual ind = new GPIndividual();
		build(ind);
		System.out.println(sd.countPossibleStates(ind.trees[0].child));
		//sd.printScores();
		//System.out.println(sd.averageScore());

	}
}
