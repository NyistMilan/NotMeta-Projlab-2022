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




/** */
public class Virologist {
	/** */
	private State state;
	
	/** */
	private String name;
	
	/** */
	private VirologistBackpack backPack;
	
	/** */
	private ActiveEffects activeEffects;
	
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
	private GetStolenBehavior -getStolenBehavior;
	
	/** */
	public void Move(int d) {
	}
	
	/** */
	public void PickUpCollectable(Collectable[1..*] c) {
	}
	
	/** */
	public void DropCollectable(Collectable[1..*] c) {
	}
	
	/** */
	public void Steal(Virologist v, Collectable[1..*] c) {
	}
	
	/** */
	public bool GetStolenFrom(Collectable[1..*] c) {
	}
	
	/** */
	public void Infect(Virologist v, Agent a) {
	}
	
	/** */
	public bool Add(Genom g) {
	}
	
	/** */
	public void Learn() {
	}
	
	/** */
	public void ListCollectables() {
	}
	
	/** */
	public Agent CreateAgent(Genome g) {
	}
	
	/** */
	public void GetInfected(Virologist v, Agent a) {
	}
	
	/** */
	public void SetState(State s) {
	}
	
	/** */
	public State GetState() {
	}
	
	/** */
	public Route GetRoute() {
	}
	
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
