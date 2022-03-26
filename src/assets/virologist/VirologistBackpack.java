package assets.virologist;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : field.virologist.VirologistBackpack.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import collectables.agent.Agent;
import assets.Backpack;
import main.Skeleton;

import java.util.ArrayList;

/**
 * The backpack of the field.virologist.Virologist. He keeps here his Aminoacids, collectables.material.Nucleotide, Equipments, the Agents he Created
 * and the Agents he was infected with.
 * */
public class VirologistBackpack extends Backpack {
	/** Constructor*/
	VirologistBackpack(){
		super();
		capacity = 20;
		agents = new ArrayList<>();
		appliedAgents = new ArrayList<>();
	}
	/** The number of materials the field.virologist.Virologist can carry*/
	private int capacity;

	/** The Agents the field.virologist.Virologist created and ready to use*/
	private final ArrayList<Agent> agents;
	
	/** The Agents the field.virologist.Virologist was infected with*/
	private final ArrayList<Agent> appliedAgents;
	
	/** Adds the created collectables.agent.Agent to the field.Backpack*/
	public void Add(Agent a) {
		Skeleton.methodCall(this, "a");
		agents.add(a);
		Skeleton.methodReturn(this);
	}
	
	/** Adds the applied Aget to the field.Backpack*/
	public void AddApplied(Agent a) {
		Skeleton.methodCall(this, "a");
		appliedAgents.add(a);
		Skeleton.methodReturn(this);
	}
	
	/** */
	public ArrayList<Agent> GetAgents() {
		Skeleton.methodCall(this);
		Skeleton.methodReturn(this);
		return agents;
	}

	/**
	 * Returns the Agents applied to the field.virologist.Virologist
	 * @return The Agents applied to the field.virologist.Virologist
	 */
	public ArrayList<Agent> GetAppliedAgents() {
		Skeleton.methodCall(this);
		Skeleton.methodReturn(this);
		return appliedAgents;
	}
	
	/** Removes an collectables.agent.Agent from the field.Backpack*/
	public void Remove(Agent a) {
		Skeleton.methodCall(this, "a");
		agents.remove(a);
		Skeleton.methodReturn(this);
	}
	
	/** Removes an active collectables.agent.Agent from the field.virologist.Virologist*/
	public void RemoveApplied(Agent a) {
		Skeleton.methodCall(this, "a");
		appliedAgents.remove(a);
		Skeleton.methodReturn(this);
	}
	
	/**
	 * Decreases the warranties of the stored Agents and the Duration of the applied Agents
	 * If one's warranty or duration reaches 0, it gets removed from the field.Backpack
	 * */
	public void DecreaseWarranties() {
		Skeleton.methodCall(this);
		for(Agent a: agents){
			int w = a.DecreaseWarranty();
			if(w == 0){
				Remove(a);
			}
		}
		for(Agent a: appliedAgents){
			int d = a.DecreaseDuration();
			if(d == 0){
				RemoveApplied(a);
			}
		}
		Skeleton.methodReturn(this);
	}

	/**
	 * Decides if there is enough material in the field.Backpack for the collectables.agent.Agent the field.virologist.Virologist wants to create
	 *
	 * @param a the required number of aminoacid
	 * @param n the required number of nucleotide
	 * @return true if there is enough material, false if there isn't
	 */
	public boolean EnoughMaterials(int a, int n) {
		Skeleton.methodCall(this, "a", "n");
	//	boolean isEnough = Skeleton.yesOrNoInput("Has enough materials?");
		if (aminoacids.size() >= a && nucleotids.size() >= n){
			Skeleton.methodReturn(this);
			return true;
		}
		Skeleton.methodReturn(this);
		return false;
	}
	/** */
	public int getCapacity() {
		return capacity;
	}

	/** Haho javits ki
	 * Sets the capacity of the field.Backpack to a given value. If there are more materials in the field.Backpack
	 * then the amount it can store, it removes the extra materials
	 * @param capacity the new capacity
	 */

	public void increaseCapacity(int addition){
		Skeleton.methodCall(this, "addition");
		capacity=capacity+addition;
		Skeleton.methodReturn(this);
	}

	public void decreaseCapacity(int reduction){
		Skeleton.methodCall(this, "reduction");
		capacity=capacity-reduction;
		int aminoBonus = aminoacids.size() - capacity;
		while(aminoBonus > 0){
			Remove(aminoacids.get(aminoacids.size()-1));

			aminoBonus--;
		}
		int nucleoBonus = nucleotids.size() - capacity;
		while(nucleoBonus > 0){
			Remove(nucleotids.get(nucleotids.size()-1));
			nucleoBonus--;
		}
		Skeleton.methodReturn(this);
	}

}
