package assets.virologist.behavior.createbehavior;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : field.virologist.behavior.createbehavior.NotCreate.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import collectables.genome.Genome;
import assets.virologist.Virologist;
import main.Skeleton;
public class NotCreate implements CreateBehavior {
    /**
     * Nothing happens
     * 
     * @param v the field.virologist.Virologist who wants to create an agent
     * @param g the collectables.genome.Genome he wants to use to create the collectables.agent.Agent
     */
    @Override
    public void CreateAgent(Virologist v, Genome g) {
        Skeleton.methodCall(this, "v","g");
        Skeleton.methodReturn(this);
    }
}