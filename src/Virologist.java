//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Virologist.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//


import java.util.ArrayList;

/** */
public class Virologist {
	/** */
	private State state;
	
	/** */
	private String name;
	
	/** */
	private VirologistBackpack backPack;
	
	/** */
	private Route route;
	
	/** */
	private Genome learnedGenomes;
	
	/** */
	private PickUpBehavior pickUpBehavior;
	
	/** */
	private CreateBehavior createBehavior;
	
	/** */
	private LearnBehavior learnBehavior;
	
	/** */
	private StealBehavior stealBehavior;
	
	/** */
	private MoveBehavior moveBehavior;
	
	/** */
	private GetInfectedBehavior getInfectedBehavior;
	
	/** */
	private DropBehavior dropBehavior;
	
	/** */
	private InfectBehavior infectBehavior;
	
	/** */
	private GetStolenBehavior getStolenBehavior;
	
	/** */
	public void Move(int d) {
	}
	
	/** */
	public void PickUpCollectable(ArrayList<Collectable> c) {
	}
	
	/** */
	public void DropCollectable(ArrayList<Collectable> c) {
	}
	
	/** */
	public void Steal(Virologist v, ArrayList<Collectable> c) {
	}
	
	/** */
	public boolean GetStolenFrom(ArrayList<Collectable> c) {return false;}
	
	/** */
	public void Infect(Virologist v, Agent a) {
	}
	
	/** */
	public boolean Add(Genome g) {return false;}
	
	/** */
	public void Learn() {
	}
	
	/** */
	public void ListCollectables() {
	}
	
	/** */
	//public Agent CreateAgent(Genome g) {}
	
	/** */
	public void GetInfected(Virologist v, Agent a) {
	}
	
	/** */
	public void SetState(State s) {
	}
	
	/** */
	//public State GetState() {}
	
	/** */
	//public Route GetRoute() {}
	
	/** */
	public void EndTurn() {
	}
	
	/** */
	public void RefreshEffects() {
	}
	
	/** */
	public void ForgetGenome(Genome g) {
	}
}
