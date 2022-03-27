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
import main.Skeleton;

/** The field.virologist.Virologist forgets every collectables.genome.Genome he learned so far*/
@SuppressWarnings("GrazieInspection")
public class Oblivion extends Agent {
	/** Constructor*/
	public Oblivion(){
		warranty = baseWarranty;
		duration = effectDuration;
	}
	/** The number of turns the collectables.agent.Agent can be used after its creation*/
	private static final int baseWarranty = 5;
	private static final int effectDuration = 1;
	private static String name;

	/** Applies the effect on the field.virologist.Virologist*/
	public void Apply(Virologist v) {
		Skeleton.methodCall(this, "v");
		v.ForgetGenome();
		Skeleton.methodReturn(this);
	}
}
