//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Infect.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//




/** */
public class Infect implements InfectBehavior {
    /**
     * @param v1
     * @param v2
     * @param a
     */
    @Override
    public void Infect(Virologist v1, Virologist v2, Agent a) {
        Skeleton.methodCall(this, "v1", "v2", "a");
        v2.GetInfected(v1, a);
        v1.SetState(State.AFTER_ACTION);
        Skeleton.methodReturn(this);
    }
}
