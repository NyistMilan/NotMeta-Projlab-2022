package collectables.equipment;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : collectables.equipment.Sack.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import main.Skeleton;
import assets.virologist.Virologist;

/** The field.virologist.Virologist can store more items than usually*/
public class Sack extends Equipment {
	private static int extraInventory = 20;
	private static String name;

	/** Applies the Effect to the field.virologist.Virologist*/
	public void Apply(Virologist v) {
		Skeleton.methodCall(this, "v");
		v.GetBackpack().increaseCapacity(extraInventory);
		Skeleton.methodReturn(this);
	}
	
	/** Removes the effect From the field.virologist.Virologist*/
	public void Remove(Virologist v) {
		Skeleton.methodCall(this, "v");
		v.GetBackpack().decreaseCapacity(extraInventory);
		Skeleton.methodReturn(this);
	}

	@Override
	public String GetName() {
		return "Sack";
	}
}
