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
import collectables.equipment.Equipment;
import collectables.material.Aminoacid;
import collectables.material.Nucleotide;
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
		capacity = 5;
		agents = new ArrayList<>();
		appliedAgents = new ArrayList<>();
	}
	/** The number of materials the field.virologist.Virologist can carry*/
	private int capacity;

	/** The Agents the field.virologist.Virologist created and ready to use*/
	private final ArrayList<Agent> agents;
	
	/** The Agents the field.virologist.Virologist was infected with*/
	private final ArrayList<Agent> appliedAgents;
	//TODO
	/** A Virologist can store 3 Equipments in his Backpack*/
	@Override
	public boolean Add(Equipment e){
		Skeleton.methodCall(this, "e");
		if(equipments.size() < 3){
			equipments.add(e);
			Skeleton.printWithIndent("Equipment in Backpack:"+ equipments.size());
			Skeleton.methodReturn(this);
			return true;
		}
		Skeleton.methodReturn(this);
		return false;
	}


	/** A Virologist can sture a certain amount of Aminoacids in his Backpack*/
	@Override
	public boolean Add(Aminoacid a){
		Skeleton.methodCall(this, "a");
		if(aminoacids.size() < capacity){
			aminoacids.add(a);
			Skeleton.printWithIndent("Aminoacids in Backpack:"+ aminoacids.size());
			Skeleton.methodReturn(this);
			return true;
		}
		Skeleton.methodReturn(this);
		return false;
	}

	/** A Virologist can sture a certain amount of Nucleotide in his Backpack*/
	@Override
	public boolean Add(Nucleotide n){
		Skeleton.methodCall(this, "n");
		if(nucleotids.size() < capacity){
			nucleotids.add(n);
			Skeleton.printWithIndent("Nucleotide in Backpack:"+ nucleotids.size());
			Skeleton.methodReturn(this);
			return true;
		}
		Skeleton.methodReturn(this);
		return false;
	}
	/** Adds the created collectables.agent.Agent to the field.Backpack*/
	@SuppressWarnings("SameReturnValue")
	public boolean Add(Agent a) {
		Skeleton.methodCall(this, "a");
		agents.add(a);
		Skeleton.methodReturn(this);
		return true;
	}
	
	/** Adds the applied Agent to the field.Backpack*/
	public void AddApplied(Agent a) {
		Skeleton.methodCall(this, "a");
		appliedAgents.add(a);
		Skeleton.methodReturn(this);
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
	
	/** Removes a collectables.agent.Agent from the field.Backpack*/
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
	//TODO
	/**
	 * Decreases the warranties of the stored Agents and the Duration of the applied Agents
	 * If one's warranty or duration reaches 0, it gets removed from the field.Backpack
	 * */
	public void DecreaseWarranties() {
		Skeleton.methodCall(this);
		for(int i = 0; i < agents.size(); i++) {
			int w = agents.get(i).DecreaseWarranty();
			if (w == 0) {
				Remove(agents.get(i));
			}
		}

		for(int i = 0; i < appliedAgents.size(); i++) {
			int w = appliedAgents.get(i).DecreaseDuration();
			if (w == 0) {
				RemoveApplied(appliedAgents.get(i));
			}
		}
		Skeleton.methodReturn(this);
	}
	//TODO
	/**
	 * Decides if there is enough material in the field.Backpack for the collectables.agent.Agent the field.virologist.Virologist wants to create
	 *
	 * @param a the required number of aminoacid
	 * @param n the required number of nucleotide
	 * @return true if there is enough material, false if there isn't
	 */
	public boolean EnoughMaterials(int a, int n) {
		Skeleton.methodCall(this, "a", "n");
		if (aminoacids.size() >= a && nucleotids.size() >= n){
			Skeleton.methodReturn(this);
			return true;
		}
		Skeleton.methodReturn(this);
		return false;
	}

	/**
	 * Extends the capacity with a given value.
	 * @param addition the new capacity
	 */
	public void increaseCapacity(int addition){
		Skeleton.methodCall(this, "addition");
		capacity += addition;
		Skeleton.printWithIndent("Extended capacity:"+capacity);
		Skeleton.methodReturn(this);
	}
	//TODO
	/**
	 * Decrease the capacity with a given value, whether there is more material then the decreased capacity,
	 * the extra materials will be dropped to the field.
	 * @param reduction
	 */
	public void decreaseCapacity(int reduction){
		Skeleton.methodCall(this, "reduction");
		capacity -= reduction;
		int aminoBonus = aminoacids.size() - capacity;
		while(aminoBonus > 0){
			Skeleton.printWithIndent("AminoBonus:"+aminoBonus+"Aminoacids size"+aminoacids.size()+"capacity"+capacity);
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
	//TODO
	/**
	 * Remove equipments with 0 durability.
	 */
	public void checkEquipmentDurability(){
		equipments.removeIf(eq -> eq.GetDurability() == 0);
	}
}
