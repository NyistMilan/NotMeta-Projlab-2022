package assets.virologist.behavior.dropbehavior;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : field.virologist.behavior.dropbehavior.Drop.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import assets.field.Field;
import collectables.Collectable;
import assets.virologist.Virologist;
import java.util.ArrayList;
import main.Skeleton;

public class Drop implements DropBehavior, java.io.Serializable{
    /**
     * Drops the Collectables on the field.field.Field the field.virologist.Virologist stands on
     *
     * @param v The field.virologist.Virologist who wants to drop
     * @param c The Collectables he wants to drop
     */

    @Override
    public void DropCollectable(Virologist v, ArrayList<Collectable> c) {
        Skeleton.methodCall(this, "v","c");
        Field f = v.GetRoute().GetLocation();
        for(Collectable collectable: c){
            collectable.RemoveFromBackpack(v, v.GetBackpack());
            collectable.Remove(v);
            f.Add(v, collectable);
        }

        Skeleton.methodReturn(this);
    }
}
