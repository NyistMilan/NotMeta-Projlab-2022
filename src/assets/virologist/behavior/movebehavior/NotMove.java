package assets.virologist.behavior.movebehavior;//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : field.virologist.behavior.movebehavior.NotMove.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import assets.virologist.State;
import assets.virologist.Virologist;
public class NotMove implements MoveBehavior, java.io.Serializable {
    @Override
    public int GetPriority() {
        return 2;
    }

    /**
     * Nothing happens. The Virologist can not move.
     *
     * @param v the field.virologist.Virologist who tries to move
     * @param d the direction he wants to move
     */
    @Override
    public void MoveToField(Virologist v, int d) {
        v.SetState(State.BEFORE_ACTION);
    }

    @Override
    public void MoveRandomOff(Virologist v, int d) {
        MoveToField(v,d);
    }
}
