package collectables.genome;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : collectables.genome.GenomeProtection.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import assets.virologist.Virologist;
import collectables.agent.Protection;
import main.Skeleton;
/** The collectables.genome.GenomeChorea is used to create the collectables.agent.Protection collectables.agent.Agent*/
public class GenomeProtection extends Genome {
	private static final int aminocost=2;
	private static final int nucleocost=2;

	//TODO
	/**
	 * Creates a collectables.agent.Protection collectables.agent.Agent and puts it into the field.Backpack of the field.virologist.Virologist that created it
	 *
	 * @param v the field.virologist.Virologist who creates the collectables.agent.Agent
	 */
	public void CreateAgent(Virologist v) {
		Skeleton.methodCall(this, "v");
		Protection agent = new Protection();
		agent.AddToBackpack(v, v.GetBackpack());
		Skeleton.methodReturn(this);
	}
	@Override
	public int getAminoCost() {
		return aminocost;
	}

	@Override
	public int getNucleoCost() {
		return nucleocost;
	}

	@Override
	public String GetName(){ return "Protection Genome";}
}
