//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : NotGetStolen.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

import java.util.ArrayList;

/** */
public class NotGetStolen implements GetStolenBehavior {
    /**
     * Nothing happens.
     *
     * @param v the target of the action
     * @param c the Collectable that the other Virologist wants to steal from the target
     * @return false. because the action failed
     */
    @Override
    public boolean GetStolenFrom(Virologist v, ArrayList<Collectable> c) {
        Skeleton.methodCall(this, "v","c");
        Skeleton.methodReturn(this);
        return false;
    }
}
