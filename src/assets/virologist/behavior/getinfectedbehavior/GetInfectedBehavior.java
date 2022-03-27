package assets.virologist.behavior.getinfectedbehavior;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : field.virologist.behavior.getinfectedbehavior.GetInfectedBehavior.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import collectables.agent.Agent;
import assets.virologist.Virologist;

/** The field.virologist.behavior which decides if the field.virologist.Virologist can be infected by another field.virologist.Virologist */
public interface GetInfectedBehavior {

	/** The Behavior will only be changed if the new field.virologist.behavior has higher priority*/
	int priority = 0;

	int GetPriority();

	/**
	 *
	 * @param v1 the field.virologist.Virologist who wants to infect
	 * @param v2 the target of the action
	 * @param a the Agents v1 wants to infect v2 with
	 */
	void getInfected(Virologist v1, Virologist v2, Agent a);
}
