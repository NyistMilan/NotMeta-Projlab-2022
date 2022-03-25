//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : MaybeInfected.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//


import java.math.*;

/** */
public class MaybeInfected implements GetInfectedBehavior {
    @Override
    public int GetPriority() {
        Skeleton.methodCall(this);
        Skeleton.methodReturn(this);
        return 0;
    }

    @Override
    public void GetInfected(Virologist v1, Virologist v2, Agent a) {
        Skeleton.methodCall(this, "v1", "v2", "a");
        double d = Math.random();
        if(d < 0.823){
            a.Apply(v2);
            v2.GetBackpack().AddApplied(a);
        }
        Skeleton.methodReturn(this);
    }
}
