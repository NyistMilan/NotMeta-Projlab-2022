//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : GenomeChorea.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//


import java.util.ArrayList;

/** */
public class GenomeChorea extends Genome {
	/** */
	public void CreateAgent(Virologist v) {
		Skeleton.methodCall(this, "b");
		Chorea agent = new Chorea();
		agent.AddToBackpack(v);
		Skeleton.methodReturn(this);
	}
}
