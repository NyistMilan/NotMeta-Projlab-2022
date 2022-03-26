package  assets.virologist.behavior.movebehavior;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : field.virologist.behavior.movebehavior.MoveBehavior.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import assets.virologist.Virologist;

/** The field.virologist.behavior which decides if the field.virologist.Virologist can move to a field.field.Field */
public interface MoveBehavior {
	/** The Behavior will only be changed if the new field.virologist.behavior has higher priority*/
	int priority = 0;

	int GetPriority();

	/**
	 *
	 * @param v the field.virologist.Virologist who tries to move
	 * @param d the direction he wants to move
	 */
	void Move(Virologist v, int d);
}