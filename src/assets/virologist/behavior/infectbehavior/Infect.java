package assets.virologist.behavior.infectbehavior;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : field.virologist.behavior.infectbehavior.Infect.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import assets.virologist.State;
import collectables.agent.Agent;
import assets.virologist.Virologist;
import main.Skeleton;
public class Infect implements InfectBehavior {
    /**
     * v1 tries to infect v2.
     *
     * @param v1 the field.virologist.Virologist who wants to infect
     * @param v2 the target of the action
     * @param a the Agents v1 wants to infect v2 with
     */

    @Override
    public void InfectVirologist(Virologist v1, Virologist v2, Agent a) {
        Skeleton.methodCall(this, "v1", "v2", "a");
        v1.GetBackpack().Remove(a);
        v2.GetInfected(v1, a);
        v1.SetState(State.AFTER_ACTION);
        Skeleton.methodReturn(this);
    }
}
