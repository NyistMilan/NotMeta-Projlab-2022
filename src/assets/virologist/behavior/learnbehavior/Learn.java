package assets.virologist.behavior.learnbehavior;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : field.virologist.behavior.learnbehavior.Learn.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import assets.virologist.State;
import collectables.genome.Genome;
import main.Controller;
import assets.virologist.Virologist;
import main.Skeleton;
public class Learn implements LearnBehavior {
    /**
     * The field.virologist.Virologist learns the collectables.genome.Genome from the field.field.Laboratory if he didn't know it already.
     * If he has learned all the available Genomes he wins the game.
     * After that he sets his state to AFTER_ACTION
     *
     * @param v the field.virologist.Virologist who wants to learn the collectables.genome.Genome
     */
    @Override
    public void LearnGenome(Virologist v) {
        Skeleton.methodCall(this, "v");
        Genome g = v.GetRoute().GetLocation().GetGenome();
        if( g == null){
            Skeleton.methodReturn(this);
            return;
        }
        boolean added = v.Add(g);
        if(!added){
            Skeleton.methodReturn(this);
            return;
        }
        Controller.TestWin(v);
        v.SetState(State.AFTER_ACTION);
        Skeleton.methodReturn(this);
    }
}
