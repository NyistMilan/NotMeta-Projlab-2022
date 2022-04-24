package collectables.agent;
import assets.virologist.Virologist;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : collectables.agent.Protection.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import assets.virologist.behavior.getinfectedbehavior.NotInfected;

/** The field.virologist.Virologist can not get infected by other Virologists*/
public class Protection extends Agent{

	/** The number of turns a field.virologist.Virologist can store the collectables.agent.Agent in his field.Backpack.*/
	private static int warranty;

	/** The number of turns a collectables.agent.Agent stays active on an infected field.virologist.Virologist*/
	private static int duration;

	/** Constructor*/
	public Protection(){
		warranty = baseWarranty;
		duration = effectDuration;
	}

	/** The number of turns the collectables.agent.Agent can be used after its creation*/
	private static final int baseWarranty = 5;
	private static final int effectDuration = 3;

	@Override
	public int getDuration() {
		return duration;
	}

	@Override
	public void setDuration(int duration) {
		Protection.duration = duration;
	}

	@Override
	public int getWarranty() {
		return warranty;
	}

	@Override
	public void setWarranty(int warranty) {
		Protection.warranty = warranty;
	}

	/** Applies the effect to the field.virologist.Virologist if there is no stronger effect on him*/
	public void Apply(Virologist v) {
		if(v.GetGetInfectedBehavior().GetPriority() < 2)
			v.SetGetInfectedBehavior(new NotInfected());
	}

	@Override
	public String GetName(){ return "protection";}
}
