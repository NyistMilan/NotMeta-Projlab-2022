package collectables.genome;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : collectables.genome.GenomeOblivion.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import assets.virologist.Virologist;
import collectables.agent.Oblivion;
import main.Skeleton;

/** The collectables.genome.GenomeChorea is used to create the collectables.agent.Oblivion collectables.agent.Agent*/
public class GenomeOblivion extends Genome {
	private static int aminocost;
	private static int nucleocost;

	//TODO
	/**
	 * Creates a collectables.agent.Oblivion collectables.agent.Agent and puts it into the field.Backpack of the field.virologist.Virologist that created it
	 *
	 * @param v the field.virologist.Virologist who creates the collectables.agent.Agent
	 */
	public void CreateAgent(Virologist v) {
		Skeleton.methodCall(this, "v");
		Oblivion agent = new Oblivion();
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
	public String GetName() {return "Oblivion Genome";}
}
