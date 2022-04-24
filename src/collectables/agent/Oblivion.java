package collectables.agent;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : collectables.agent.Oblivion.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import assets.virologist.Virologist;
import collectables.agent.Agent;

/** The field.virologist.Virologist forgets every collectables.genome.Genome he learned so far*/
@SuppressWarnings("GrazieInspection")
public class Oblivion extends Agent{

	/** The number of turns a field.virologist.Virologist can store the collectables.agent.Agent in his field.Backpack.*/
	private static int warranty;

	/** The number of turns a collectables.agent.Agent stays active on an infected field.virologist.Virologist*/
	private static int duration;

	/** Constructor*/
	public Oblivion(){
		warranty = baseWarranty;
		duration = effectDuration;
	}
	/** The number of turns the collectables.agent.Agent can be used after its creation*/
	private static final int baseWarranty = 5;
	private static final int effectDuration = 1;

	@Override
	public int getDuration() {
		return duration;
	}

	@Override
	public void setDuration(int duration) {
		Oblivion.duration = duration;
	}

	@Override
	public int getWarranty() {
		return warranty;
	}

	@Override
	public void setWarranty(int warranty) {
		Oblivion.warranty = warranty;
	}

	/** Applies the effect on the field.virologist.Virologist*/
	public void Apply(Virologist v) {
		v.ForgetGenome();
	}

	@Override
	public String GetName(){ return "oblivion";}
}
