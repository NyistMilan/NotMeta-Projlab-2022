package collectables.agent;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : collectables.agent.Paralysis.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import assets.virologist.behavior.createbehavior.NotCreate;
import assets.virologist.behavior.getstolenbehavior.GetStolen;
import assets.virologist.behavior.infectbehavior.NotInfect;
import assets.virologist.behavior.learnbehavior.NotLearn;
import assets.virologist.behavior.movebehavior.NotMove;
import assets.virologist.behavior.pickupbehavior.NotPickUp;
import assets.virologist.behavior.stealbehavior.NotSteal;
import main.Skeleton;
import assets.virologist.*;
import assets.virologist.behavior.dropbehavior.*;

/** The field.virologist.Virologist can not do anything. Other Virologists can steal from him*/
public class Paralysis extends Agent {
	/** Constructor*/
	public Paralysis(){
		warranty = baseWarranty;
		duration = effectDuration;
	}

	/** The number of turns the collectables.agent.Agent can be used after its creation*/
	private static int baseWarranty;
	private static int effectDuration;
	private static String name;

	/** Applies the effects on a field.virologist.Virologist*/
	public void Apply(Virologist v) {
		Skeleton.methodCall(this, "v");
		if(v.GetMoveBehavior().GetPriority() < 2)
			v.SetMoveBehavior(new NotMove());
		v.SetCreateBehavior(new NotCreate());
		v.SetLearnBehavior(new NotLearn());
		v.SetStealBehavior(new NotSteal());
		v.SetPickUpBehavior(new NotPickUp());
		v.SetInfectBehavior(new NotInfect());
		v.SetDropBehavior(new NotDrop());
		v.SetGetStolenBehavior(new GetStolen());
		Skeleton.methodReturn(this);
	}
}
