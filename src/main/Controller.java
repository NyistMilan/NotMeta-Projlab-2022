package main;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Game.Controller.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import assets.field.Field;
import assets.field.Normal;
import assets.virologist.Route;
import assets.virologist.State;
import assets.virologist.Virologist;
import collectables.material.Aminoacid;

import java.util.ArrayList;

/** Controls the Game and the turns of the players*/
public class Controller {
	private ArrayList<Field> map;

	private ArrayList<Virologist> virologists;
	/** the next player*/
	private static int index;
	/** */
	public void Start() {
		Skeleton.methodCall(this);
		map = new ArrayList<>();
		virologists = new ArrayList<>();
		Field f = new Normal();
		Virologist v = new Virologist();
		index = 0;
		NextPlayer();
		Skeleton.methodReturn(this);
	}
	
	/** */
	public static void End() {
		Skeleton.printWithIndent("GAME OVER!");
	}


	/** Calls the next player and him in which directions can he move*/
	public ArrayList<Integer> NextPlayer() {

		Skeleton.methodCall(this);

		index++;
		Virologist v = virologists.get(index);
		if(v.GetState()==State.KILLED){
			virologists.remove(v);
			v = virologists.get(index);

		}
		Route r = v.GetRoute();
		Field f  = r.GetLocation();
		ArrayList<Integer> d = f.GetDirections();
		v.SetState(State.BEFORE_MOVE);
		Skeleton.methodReturn(this);
		return d;
	}
}
