//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : WareHouse.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import java.util.ArrayList;

/** At the start of the game Materials are placed in the WarHouses*/
public class WareHouse extends Field {
	/** Constructor*/
	WareHouse(){
		Skeleton.methodCall(this);
		this.virologists = new ArrayList<>();
		this.neighbours = new ArrayList<>();
		backpack = new Backpack();
		Skeleton.methodReturn(this);
	}
}
