package collectables.material;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : collectables.material.Materials.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import assets.virologist.Virologist;
import collectables.Collectable;


/** The collectables.material.Materials are the things that the Agents are made of*/
public abstract class Materials implements Collectable , java.io.Serializable{

    /** Nothing happens*/
    @Override
    public void Apply(Virologist v) {
    }

    /** Nothing happens*/
    @Override
    public void Remove(Virologist v) {
    }

    public abstract String GetName();
}
