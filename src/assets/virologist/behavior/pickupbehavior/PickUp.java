package assets.virologist.behavior.pickupbehavior;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : field.virologist.behavior.pickupbehavior.PickUp.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import assets.virologist.State;
import collectables.Collectable;
import assets.virologist.Virologist;

import java.util.ArrayList;
import main.Skeleton;

public class PickUp implements PickUpBehavior {
    /**
     * The field.virologist.Virologist picks up the Collectables and sets the state to AFTER_ACTION
     *
     * @param v the field.virologist.Virologist who wants to pick up something
     * @param c the Collectables the field.virologist.Virologist wants to pick up
     */
    //TODO
    @Override
    public void PickUpCollectable(Virologist v, ArrayList<Collectable> c) {
        Skeleton.methodCall(this, "v", "c");
        for(Collectable collectable: c){
            v.GetRoute().GetLocation().Remove(v, collectable);
            boolean isAdded = collectable.AddToBackpack(v, v.GetBackpack());
            collectable.Apply(v);
            if(!isAdded){
                v.SetState(State.AFTER_ACTION);
                break;
            }
        }
        v.SetState(State.AFTER_ACTION);
        Skeleton.methodReturn(this);
    }
}
