package collectables.equipment;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : collectables.equipment.Equipment.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import java.util.ArrayList;

import assets.Backpack;
import assets.virologist.Virologist;
import collectables.Collectable;
import main.Skeleton;
/**
 * The field.virologist.Virologist can pick up up to 3 collectables.equipment.Equipment.
 * They apply their effects on the field.virologist.Virologist until he drops them
 * or another field.virologist.Virologist steal them from him
 * */
public abstract class Equipment implements Collectable {
	/** Applies its effect to a field.virologist.Virologist*/
	public abstract void Apply(Virologist v);

	/** Removes its effect from a field.virologist.Virologist*/
	public void Remove(Virologist v) {
		Skeleton.methodCall(this, "v");
		v.RefreshEffects();
		Skeleton.methodReturn(this);
	}

	/**
	 * The collectables.equipment.Equipment is added to the field.Backpack.
	 * If there is not enough space to pick it up the field.virologist.Virologist can drop another collectables.equipment.Equipment.
	 *
	 * @param v the field.virologist.Virologist the backpack belongs to(Only used sometimes)
	 * @param b the field.Backpack it gets added to
	 */
	@Override
	public boolean AddToBackpack(Virologist v, Backpack b) {
		Skeleton.methodCall(this, "v","b");
		b.Add(this);
		if(b.GetEquipments().size() == 3){
			int i = Skeleton.askForInput("Which equipment do you want to drop?", 1, 3);
			Equipment e = b.GetEquipments().get(i-1);
			ArrayList<Collectable> list = new ArrayList<>();
			list.add(e);
			v.DropCollectable(list);
		}
		boolean isAdded = Skeleton.yesOrNoInput("Was added?");
		Skeleton.methodReturn(this);
		return isAdded;
	}

	/**
	 * The collectables.equipment.Equipment is removed from the field.Backpack.
	 * @param v the field.virologist.Virologist the backpack belongs to(Only used sometimes)
	 * @param b the field.Backpack it gets removed from
	 */
	@Override
	public void RemoveFromBackpack(Virologist v, Backpack b) {
		Skeleton.methodCall(this, "v", "b");
		b.Remove(this);
		Skeleton.methodReturn(this);
	}
}
