package assets.virologist.behavior.createbehavior;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : field.virologist.behavior.createbehavior.Create.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import assets.virologist.State;
import collectables.genome.Genome;
import collectables.material.Aminoacid;
import collectables.material.Nucleotide;
import assets.virologist.Virologist;
import main.Skeleton;
import java.util.ArrayList;

public class Create implements CreateBehavior, java.io.Serializable{
    /**
     * If the field.virologist.Virologist has enough collectables.material.Materials he removes them from his field.Backpack and creates the collectables.agent.Agent.
     *
     * @param v the field.virologist.Virologist who wants to create an agent
     * @param g the collectables.genome.Genome he wants to use to create the collectables.agent.Agent
     */
    //TODOg
    @Override
    public void CreateAgent(Virologist v, Genome g) {
        Skeleton.methodCall(this, "v","g");
        int aminocost = g.getAminoCost();
        int nucleocost = g.getNucleoCost();
        boolean isEnough = v.GetBackpack().EnoughMaterials(aminocost, nucleocost);
        if(isEnough){
            ArrayList<Aminoacid> aminos = v.GetBackpack().GetAminos();
            for(int i = 0; i < g.getAminoCost(); i++){
                v.GetBackpack().Remove(aminos.get(0));
            }
            ArrayList<Nucleotide> nucleos = v.GetBackpack().GetNucleotide();
            for(int i = 0; i < g.getNucleoCost(); i++){
                v.GetBackpack().Remove(nucleos.get(0));
            }
            g.CreateAgent(v);
            v.SetState(State.AFTER_ACTION);
        }
        Skeleton.methodReturn(this);
    }
}
