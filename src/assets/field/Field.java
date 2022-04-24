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
import java.util.ArrayList;

/** The Virologists move from field.field.Field to field.field.Field during the game. The Fields can also store Collectables*/
public abstract class Field implements java.io.Serializable{
	/** The Virologists on the field.field.Field*/
	protected ArrayList<Virologist> virologists;

	protected ArrayList<Field> neighbours;

	protected Backpack backpack;

	protected String fieldID;

	public String GetFieldId(){
		return fieldID;
	}


	/** Returns the neighbour in the given direction*/
	public Field GetNeighbour(int d) {
		return neighbours.get(d);
	}

	/** Accepts a field.virologist.Virologist in the field.field.Field. He can not learn here unless it is a field.field.Laboratory(Overwrite)*/
	public void Accept(Virologist v){
		virologists.add(v);
		v.SetLearnBehavior(new NotLearn());
	}

	public void AcceptRandomOff(Virologist v){
		Accept(v);
	}

	public void Remove(Virologist v) {
		virologists.remove(v);
	}


	/**
	 * Adds a collectables.Collectable to the field.field.Field
	 *
	 * @param v the field.virologist.Virologist who drops the collectables.Collectable
	 * @param c the collectables.Collectable
	 */
	public void Add(Virologist v, Collectable c) {
		c.AddToBackpack(v, this.backpack);
	}

	/**
	 * Removes a collectables.Collectable from the field.field.Field
	 *
	 * @param v the field.virologist.Virologist who picks up the collectables.Collectable
	 * @param c the collectables.Collectable
	 */
	public void Remove(Virologist v, Collectable c) {
		c.RemoveFromBackpack(v, this.backpack);
	}

	public void SetNeighbour(Field f) {
		neighbours.add(f);
	}

	public void SetFieldId(String fieldID){
		this.fieldID = fieldID;
	}

	/** Returns the direction a field.virologist.Virologist can move from this field.field.Field*/
	public ArrayList<Integer> GetDirections() {
		ArrayList<Integer> directions = new ArrayList<>();
		for(Field f: neighbours){
			directions.add(neighbours.indexOf(f));
		}
		return directions;
	}

	public Backpack GetBackpack() {
		return backpack;
	}

	public ArrayList<Virologist> GetVirologists() {
		return virologists;
	}

	abstract public Genome GetGenome();
	public void DestroyMaterials(){

	}

    abstract public String GetType();

	public String GetFieldID() {
		return fieldID;
	}

	public void SetFieldID(String fieldID) {
		this.fieldID = fieldID;
	}
}