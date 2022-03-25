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

	Virologist(){
		Skeleton.methodCall(this);
		route = new Route();
		backPack = new VirologistBackpack();
		learnedGenomes = new ArrayList<>();
		DefaultBehaviors();
		Skeleton.methodReturn(this);
	}
	/** */
	private State state;
	
	/** */
	private String name;
	
	/** */
	private final VirologistBackpack backPack;
	
	/** */
	private final Route route;
	
	/** */
	private final ArrayList<Genome> learnedGenomes;
	
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
	public VirologistBackpack GetBackpack(){
		Skeleton.methodCall(this);
		Skeleton.methodReturn(this);
		return backPack;
	}
	/** */
	public void Move(int d) {
		Skeleton.methodCall(this, "d");
		if(this.state == State.BEFORE_MOVE) {
			moveBehavior.Move(this, d);
		}
		Skeleton.methodReturn(this);
	}
	
	/** */
	public void PickUpCollectable(ArrayList<Collectable> c) {
		Skeleton.methodCall(this, "c");
		if(state == State.BEFORE_ACTION){
			pickUpBehavior.PickUpCollectable(this, c);
		}
		Skeleton.methodReturn(this);
	}
	
	/** */
	public void DropCollectable(ArrayList<Collectable> c) {
		Skeleton.methodCall(this, "c");
		if(state == State.BEFORE_ACTION){
			dropBehavior.DropCollectable(this, c);
		}
		if(state == State.NOT_IN_TURN){
			Field f = GetRoute().GetLocation();
			for(Collectable collectable: c){
				collectable.RemoveFromBackpack(this, GetBackpack());
				collectable.Remove(this);
				f.Add(this, collectable);
			}
		}
		Skeleton.methodReturn(this);
	}
	
	/** */
	public void Steal(Virologist v2, ArrayList<Collectable> c) {
		Skeleton.methodCall(this, "c");
		if(state == State.BEFORE_ACTION){
			stealBehavior.Steal(this, v2, c);
		}
		Skeleton.methodReturn(this);
	}
	
	/** */
	public boolean GetStolenFrom(ArrayList<Collectable> c) {
		Skeleton.methodCall(this,"c");
		boolean result = getStolenBehavior.GetStolenFrom(this, c);
		Skeleton.methodReturn(this);
		return result;}
	
	/** */
	public void Infect(Virologist v2, Agent a) {
		Skeleton.methodCall(this, "v2", "a");
		if(state == State.BEFORE_ACTION){
			infectBehavior.Infect(this, v2, a);
		}
		Skeleton.methodReturn(this);
	}
	
	/** */
	public boolean Add(Genome g) {
		Skeleton.methodCall(this, "g");
		boolean result = learnedGenomes.add(g);
		Skeleton.methodReturn(this);
		return result;}
	
	/** */
	public void Learn() {
		Skeleton.methodCall(this);
		if(state == State.BEFORE_ACTION){
			learnBehavior.Learn(this);
		}
		Skeleton.methodReturn(this);
	}
	
	/** */
	public void ListCollectables() {
		Skeleton.methodCall(this);
		Skeleton.methodReturn(this);
	}
	
	/** */
	public void CreateAgent(Genome g) {
		Skeleton.methodCall(this, "g");
		if(state == State.BEFORE_ACTION){
			createBehavior.CreateAgent(this, g);
		}
		Skeleton.methodReturn(this);
	}
	
	/** */
	public void GetInfected(Virologist v1, Agent a) {
		Skeleton.methodCall(this, "v1", "a");
		if(state == State.NOT_IN_TURN){
			getInfectedBehavior.GetInfected(v1, this, a);
		}
		else{
			a.Apply(this);
			backPack.AddApplied(a);
		}
		Skeleton.methodReturn(this);
	}
	
	/** */
	public void SetState(State s) {
		Skeleton.methodCall(this, "s");
		state = s;
		Skeleton.methodReturn(this);
	}
	
	/** */
	public State GetState() {
		Skeleton.methodCall(this);
		Skeleton.methodReturn(this);
		return state;
	}
	
	/** */
	public Route GetRoute() {
		Skeleton.methodCall(this);
		Skeleton.methodReturn(this);
		return route;
	}
	
	/** */
	public void EndTurn() {
		Skeleton.methodCall(this);
		backPack.DecreaseWarranties();
		SetState(State.NOT_IN_TURN);
		Skeleton.methodReturn(this);
	}
	
	/** */
	public void RefreshEffects() {
		Skeleton.methodCall(this);
		DefaultBehaviors();
		ArrayList<Equipment> eqs = backPack.GetEquipments();
		for(Equipment e : eqs){
			e.Apply(this);
		}
		ArrayList<Agent> ags = backPack.GetAppliedAgents();
		for(Agent a: ags){
			a.Apply(this);
		}
		Skeleton.methodReturn(this);
	}
	
	/** */
	public void ForgetGenome() {
		Skeleton.methodCall(this);
		int s = learnedGenomes.size();
		if (s > 0) {
			learnedGenomes.subList(0, s).clear();
		}
		Skeleton.methodReturn(this);
	}

	public void SetMoveBehavior(MoveBehavior b){
		Skeleton.methodCall(this, "b");
		moveBehavior = b;
		Skeleton.methodReturn(this);
	}
	public void SetDropBehavior(DropBehavior b){
		Skeleton.methodCall(this, "b");
		dropBehavior = b;
		Skeleton.methodReturn(this);
	}
	public void SetInfectBehavior(InfectBehavior b){
		Skeleton.methodCall(this, "b");
		infectBehavior = b;
		Skeleton.methodReturn(this);
	}
	public void SetGetInfectedBehavior(GetInfectedBehavior b){
		Skeleton.methodCall(this, "b");
		getInfectedBehavior = b;
		Skeleton.methodReturn(this);
	}
	public void SetPickUpBehavior(PickUpBehavior b){
		Skeleton.methodCall(this, "b");
		pickUpBehavior = b;
		Skeleton.methodReturn(this);
	}
	public void SetGetStolenBehavior(GetStolenBehavior b){
		Skeleton.methodCall(this, "b");
		getStolenBehavior = b;
		Skeleton.methodReturn(this);
	}
	public void SetStealBehavior(StealBehavior b){
		Skeleton.methodCall(this, "b");
		stealBehavior = b;
		Skeleton.methodReturn(this);
	}
	public void SetLearnBehavior(LearnBehavior b){
		Skeleton.methodCall(this, "b");
		learnBehavior = b;
		Skeleton.methodReturn(this);
	}
	public void SetCreateBehavior(CreateBehavior b){
		Skeleton.methodCall(this, "b");
		createBehavior = b;
		Skeleton.methodReturn(this);
	}

	public void DefaultBehaviors(){
		Skeleton.methodCall(this);
		SetMoveBehavior(new Move());
		SetDropBehavior(new Drop());
		SetInfectBehavior(new Infect());
		SetGetInfectedBehavior(new GetInfected());
		SetPickUpBehavior(new PickUp());
		SetGetStolenBehavior(new NotGetStolen());
		SetStealBehavior(new Steal());
		SetLearnBehavior(new NotLearn());
		SetCreateBehavior(new Create());
		Skeleton.methodReturn(this);
	}

}
