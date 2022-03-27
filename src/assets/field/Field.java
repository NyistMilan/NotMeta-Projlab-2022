package assets.field;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : field.field.Field.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import collectables.Collectable;
import assets.Backpack;
import assets.virologist.Virologist;
import assets.virologist.behavior.learnbehavior.NotLearn;
import collectables.genome.Genome;
import main.Skeleton;
import java.util.ArrayList;

/** The Virologists move from field.field.Field to field.field.Field during the game. The Fields can also store Collectables*/
public abstract class Field {
	/** The Virologists on the field.field.Field*/
	protected ArrayList<Virologist> virologists;

	protected ArrayList<Field> neighbours;

	protected Backpack backpack;

	/** Returns the neighbour in the given direction*/
	public Field GetNeighbour(int d) {
		Skeleton.methodCall(this, "d");
		Field f = neighbours.get(d-1);
		Skeleton.methodReturn(this);
		return f;
	}

	/** Accepts a field.virologist.Virologist in the field.field.Field. He can not learn here unless it is a field.field.Laboratory(Overwrite)*/
	public void Accept(Virologist v){
		Skeleton.methodCall(this, "v");
		virologists.add(v);
		v.SetLearnBehavior(new NotLearn());
		Skeleton.methodReturn(this);
	}

	public void Remove(Virologist v) {
		Skeleton.methodCall(this, "v");
		virologists.remove(v);
		Skeleton.methodReturn(this);
	}


	/**
	 * Adds a collectables.Collectable to the field.field.Field
	 *
	 * @param v the field.virologist.Virologist who drops the collectables.Collectable
	 * @param c the collectables.Collectable
	 */
	public void Add(Virologist v, Collectable c) {
		Skeleton.methodCall(this, "v","c");
		c.AddToBackpack(v, this.backpack);
		Skeleton.methodReturn(this);
	}

	/**
	 * Removes a collectables.Collectable from the field.field.Field
	 *
	 * @param v the field.virologist.Virologist who picks up the collectables.Collectable
	 * @param c the collectables.Collectable
	 */
	public void Remove(Virologist v, Collectable c) {
		Skeleton.methodCall(this, "v","c");
		c.RemoveFromBackpack(v, this.backpack);
		Skeleton.methodReturn(this);
	}

	public void SetNeighbour(Field f) {
		Skeleton.methodCall(this, "f");
		neighbours.add(f);
		Skeleton.methodReturn(this);
	}

	/** Returns the direction a field.virologist.Virologist can move from this field.field.Field*/
	public ArrayList<Integer> GetDirections() {
		Skeleton.methodCall(this);
		ArrayList<Integer> directions = new ArrayList<>();
		for(Field f: neighbours){
			directions.add(neighbours.indexOf(f));
		}
		Skeleton.methodReturn(this);
		return directions;
	}

	public Backpack getBackpack() {
		return backpack;
	}

	public Genome GetGenome(){
		return null;
	}
}