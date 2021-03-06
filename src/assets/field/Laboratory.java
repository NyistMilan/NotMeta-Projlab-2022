package assets.field;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : field.field.Laboratory.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import assets.Backpack;
import assets.virologist.Virologist;
import assets.virologist.behavior.learnbehavior.Learn;
import collectables.genome.Genome;

import java.util.ArrayList;

/** In a field.field.Laboratory a field.virologist.Virologist can learn a collectables.genome.Genome*/
public class Laboratory extends Field{
	/** Constructor*/
	public Laboratory(Genome g){
		virologists = new ArrayList<>();
		neighbours = new ArrayList<>();
		backpack = new Backpack();
		genome = g;
		neighbours.add(this);
	}

	/** The collectables.genome.Genome that can be learned from the field.field.Laboratory*/
	private final Genome genome;

	public Genome GetGenome() {
		return genome;
	}
	
	/** If the field.virologist.Virologist steps on a field.field.Laboratory he can learn the collectables.genome.Genome*/
	public void Accept(Virologist v) {
		v.SetLearnBehavior(new Learn());
		virologists.add(v);
	}

	@Override
	public String GetType(){
		return "laboratory";
	}
}
