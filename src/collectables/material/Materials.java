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
import main.Skeleton;

/** The collectables.material.Materials are the things that the Agents are made of*/
public abstract class Materials implements Collectable {
    /** Nothing happens*/
    @Override
    public void Apply(Virologist v) {
        Skeleton.methodCall(this, "v");
        Skeleton.methodReturn(this);
    }

    /** Nothing happens*/
    @Override
    public void Remove(Virologist v) {
        Skeleton.methodCall(this, "v");
        Skeleton.methodReturn(this);
    }
}