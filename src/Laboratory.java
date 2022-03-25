//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Laboratory.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import java.util.ArrayList;

/** In a Laboratory a Virologist can learn a Genome*/
public class Laboratory extends Field {
	/** Constructor*/
	Laboratory(){
		Skeleton.methodCall(this);
		virologists = new ArrayList<>();
		neighbours = new ArrayList<>();
		backpack = new Backpack();
		Skeleton.methodReturn(this);
	}

	/** The Genome that can be learned from the Laboratory*/
	private Genome genome;

	public Genome GetGenome() {
		Skeleton.methodCall(this);
		Skeleton.methodReturn(this);
		return genome;
	}
	
	/** If the Virologist steps on a Laboratory he can learn the Genome*/
	public void Accept(Virologist v) {
		Skeleton.methodCall(this, "v");
		v.SetLearnBehavior(new Learn());
		Skeleton.methodReturn(this);
	}
}
