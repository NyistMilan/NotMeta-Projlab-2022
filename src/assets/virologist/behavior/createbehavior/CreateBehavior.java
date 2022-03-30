package assets.virologist.behavior.createbehavior;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : field.virologist.behavior.createbehavior.CreateBehavior.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import collectables.genome.Genome;
import assets.virologist.Virologist;

/** The field.virologist.behavior which decides if the field.virologist.Virologist can create a collectables.agent.Agent */
public interface CreateBehavior {
	/**
	 *
	 * @param v the field.virologist.Virologist who wants to create an agent
	 * @param g the collectables.genome.Genome he wants to use to create the collectables.agent.Agent
	 */
	void CreateAgent(Virologist v, Genome g);
}
