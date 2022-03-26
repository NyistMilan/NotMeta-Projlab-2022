package assets.virologist;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : field.virologist.Virologist.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import assets.virologist.behavior.createbehavior.*;
import assets.virologist.behavior.dropbehavior.*;
import assets.virologist.behavior.getinfectedbehavior.*;
import assets.virologist.behavior.getstolenbehavior.*;
import assets.virologist.behavior.infectbehavior.*;
import assets.virologist.behavior.learnhevior.*;
import assets.virologist.behavior.movebehavior.*;
import assets.virologist.behavior.pickupbehavior.*;
import assets.virologist.behavior.stealbehavior.*;
import assets.field.*;
import collectables.Collectable;
import collectables.agent.*;
import collectables.genome.*;
import collectables.equipment.*;
import main.Skeleton;

import java.util.ArrayList;

/**
 * The field.virologist.Virologist is the avatar that the player controls.
 * He can interact with Collectables on the field.field.Field and other Virologists.
 * He moves around the map and learns Genomes, of which he can create Agents.
 * */
public class Virologist{

	/** Constructor, creates the attributes of the field.virologist.Virologist and sets his field.virologist.behaviors to the default value*/
	public Virologist(){
		Skeleton.methodCall(this);
		route = new Route();
		backPack = new VirologistBackpack();
		learnedGenomes = new ArrayList<>();
		DefaultBehaviors();
		Skeleton.methodReturn(this);
	}
	/** The current state the field.virologist.Virologist is in*/
	private State state;

	private String name;

	private final VirologistBackpack backPack;

	private final Route route;
	
	/** The Genomes the field.virologist.Virologist knows*/
	private final ArrayList<Genome> learnedGenomes;

	/** The field.virologist.behaviors of the field.virologist.Virologist*/
	private MoveBehavior moveBehavior;

	private PickUpBehavior pickUpBehavior;

	private StealBehavior stealBehavior;

	private GetStolenBehavior getStolenBehavior;

	private DropBehavior dropBehavior;

	private LearnBehavior learnBehavior;

	private CreateBehavior createBehavior;

	private InfectBehavior infectBehavior;

	private GetInfectedBehavior getInfectedBehavior;

	public VirologistBackpack GetBackpack(){
		Skeleton.methodCall(this);
		Skeleton.methodReturn(this);
		return backPack;
	}

	/** If the field.virologist.Virologist didn't move yet in his turn he calls his MoveBehavior*/
	public void Move(int d) {
		Skeleton.methodCall(this, "d");
		if(this.state == State.BEFORE_MOVE) {
			moveBehavior.Move(this, d);
		}
		Skeleton.methodReturn(this);
	}

	/** If the field.virologist.Virologist didn't do action in his turn he calls his PickUpBehavior*/
	public void PickUpCollectable(ArrayList<Collectable> c) {
		Skeleton.methodCall(this, "c");
		if(state == State.BEFORE_ACTION){
			pickUpBehavior.PickUpCollectable(this, c);
		}
		Skeleton.methodReturn(this);
	}

	/** If the field.virologist.Virologist didn't do action in his turn he calls his StealBehavior*/
	public void Steal(Virologist v2, ArrayList<Collectable> c) {
		Skeleton.methodCall(this, "c");
		if(state == State.BEFORE_ACTION){
			stealBehavior.Steal(this, v2, c);
		}
		Skeleton.methodReturn(this);
	}

	/** The field.virologist.Virologist calls his GetStolenBehavior and returns the result*/
	public boolean GetStolenFrom(ArrayList<Collectable> c) {
		Skeleton.methodCall(this,"c");
		boolean result = getStolenBehavior.GetStolenFrom(this, c);
		Skeleton.methodReturn(this);
		return result;
	}

	/**
	 * If the field.virologist.Virologist is in turn, and he moved he calls his DropBehavior.
	 * If he is not in turn he just drops the items
	 * */
	public void DropCollectable(ArrayList<Collectable> c) {
		Skeleton.methodCall(this, "c");
		if(state == State.BEFORE_ACTION || state == State.AFTER_ACTION){
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

	/** If the field.virologist.Virologist didn't do action in his turn he calls his LearnBehavior*/
	public void Learn() {
		Skeleton.methodCall(this);
		if(state == State.BEFORE_ACTION){
			learnBehavior.Learn(this);
		}
		Skeleton.methodReturn(this);
	}

	/** If the field.virologist.Virologist didn't do action in his turn he calls his CreateBehavior*/
	public void CreateAgent(Genome g) {
		Skeleton.methodCall(this, "g");
		if(state == State.BEFORE_ACTION){
			createBehavior.CreateAgent(this, g);
		}
		Skeleton.methodReturn(this);
	}

	/**If the field.virologist.Virologist didn't do action in his turn he calls his InfectBehavior*/
	public void Infect(Virologist v2, Agent a) {
		Skeleton.methodCall(this, "v2", "a");
		if(state == State.BEFORE_ACTION){
			infectBehavior.Infect(this, v2, a);
		}
		Skeleton.methodReturn(this);
	}

	/**
	 * If the field.virologist.Virologist is not in his turn he calls his GetInfectedBehavior.
	 * If he is in his turn he will get infected regardless of his protection.
	 * */
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

	/**
	 * The field.virologist.Virologist Ends his turn. The warranty of all of his Agents will be decreased,
	 * as well as the durations of his applied Agents.
	 * */
	public void EndTurn() {
		Skeleton.methodCall(this);
		backPack.DecreaseWarranties();
		SetState(State.NOT_IN_TURN);
		Skeleton.methodReturn(this);
	}

	/** Sets all the effects to default. Then applies the effects of all collectables.equipment.Equipment and applies collectables.agent.Agent*/
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

	/** Sets the field.virologist.behaviors to the default value*/
	public void DefaultBehaviors(){
		Skeleton.methodCall(this);
		SetMoveBehavior(new Move());
		SetPickUpBehavior(new PickUp());
		SetStealBehavior(new Steal());
		SetGetStolenBehavior(new NotGetStolen());
		SetDropBehavior(new Drop());
		SetLearnBehavior(new Learn());
		SetCreateBehavior(new Create());
		SetInfectBehavior(new Infect());
		SetGetInfectedBehavior(new GetInfected());
		Skeleton.methodReturn(this);
	}

	/**
	 * Adds a collectables.genome.Genome to learnedGenomes if it wasn't learned yet
	 *
	 * @return true if it was added, false if it was not added
	 * */
	public boolean Add(Genome g) {
		Skeleton.methodCall(this, "g");
		if(learnedGenomes.contains(g)){
			Skeleton.methodReturn(this);
			return false;
		}
		learnedGenomes.add(g);
		Skeleton.methodReturn(this);
		return true;
	}

	/** Forgets all known genomes*/
	public void ForgetGenome() {
		Skeleton.methodCall(this);
		int s = learnedGenomes.size();
		if (s > 0) {
			learnedGenomes.subList(0, s).clear();
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
	


	public void SetMoveBehavior(MoveBehavior b){
		Skeleton.methodCall(this, "b");
		moveBehavior = b;
		Skeleton.methodReturn(this);
	}

	public void SetPickUpBehavior(PickUpBehavior b){
		Skeleton.methodCall(this, "b");
		pickUpBehavior = b;
		Skeleton.methodReturn(this);
	}

	public void SetStealBehavior(StealBehavior b){
		Skeleton.methodCall(this, "b");
		stealBehavior = b;
		Skeleton.methodReturn(this);
	}

	public void SetGetStolenBehavior(GetStolenBehavior b){
		Skeleton.methodCall(this, "b");
		getStolenBehavior = b;
		Skeleton.methodReturn(this);
	}

	public void SetDropBehavior(DropBehavior b){
		Skeleton.methodCall(this, "b");
		dropBehavior = b;
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

	public MoveBehavior GetMoveBehavior(){
		Skeleton.methodCall(this);
		Skeleton.methodReturn(this);
		return this.moveBehavior;
	}

	public GetInfectedBehavior GetGetInfectedBehavior(){
		Skeleton.methodCall(this);
		Skeleton.methodReturn(this);
		return this.getInfectedBehavior;
	}

	/** I'm not sure we need this one*/
	public void ListCollectables() {
		Skeleton.methodCall(this);
		Skeleton.methodReturn(this);
	}

}
