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

import collectables.genome.Genome;
import assets.Backpack;
import assets.virologist.Virologist;
import assets.virologist.behavior.learnbehavior.Learn;
import main.Skeleton;

import java.util.ArrayList;

/** In a field.field.Laboratory a field.virologist.Virologist can learn a collectables.genome.Genome*/
public class Laboratory extends Field {
	/** Constructor*/
	public Laboratory(Genome g){
		Skeleton.methodCall(this);
		virologists = new ArrayList<>();
		neighbours = new ArrayList<>();
		backpack = new Backpack();
		genome = g;
		Skeleton.methodReturn(this);
	}

	/** The collectables.genome.Genome that can be learned from the field.field.Laboratory*/
	private final Genome genome;

	public Genome GetGenome() {
		Skeleton.methodCall(this);
		Skeleton.methodReturn(this);
		return genome;
	}
	
	/** If the field.virologist.Virologist steps on a field.field.Laboratory he can learn the collectables.genome.Genome*/
	public void Accept(Virologist v) {
		Skeleton.methodCall(this, "v");
		v.SetLearnBehavior(new Learn());
		virologists.add(v);
		Skeleton.methodReturn(this);
	}
}
