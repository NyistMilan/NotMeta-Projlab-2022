package collectables.equipment;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : collectables.equipment.Gloves.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import assets.virologist.Virologist;
import assets.virologist.behavior.getinfectedbehavior.InfectBack;
import collectables.equipment.Equipment;
import main.Skeleton;

/** The collectables.equipment.Gloves protect the field.virologist.Virologist from any collectables.agent.Agent, and it Infects back the field.virologist.Virologist who tris to infect him*/
public class Gloves extends Equipment implements java.io.Serializable{

	public Gloves(){
		durability=3;
	}

	@Override
	public void DecreaseEquipmentDurability() {
		durability--;
	}


	//TODO
	/** Applies the effect to the field.virologist.Virologist if there is no stronger effect on him*/
	public void Apply(Virologist v) {
		Skeleton.methodCall(this, "v");
		if(v.GetGetInfectedBehavior().GetPriority() < 3)
			v.SetGetInfectedBehavior(new InfectBack(this));
		Skeleton.methodReturn(this);
	}

	@Override
	public String GetName() {
		return "gloves";
	}
}
