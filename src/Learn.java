//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Learn.java
//  @ Date : 2022. 03. 23.
//  @ Author : 
//
//

public class Learn implements LearnBehavior {
    /**
     * The Virologist learns the Genome from the Laboratory if he didn't know it already.
     * If he has learned all the available Genomes he wins the game.
     * After that he sets his state to AFTER_ACTION
     *
     * @param v the Virologist who wants to learn the Genome
     */
    @Override
    public void Learn(Virologist v) {
        Skeleton.methodCall(this, "v");
        Laboratory l = (Laboratory) v.GetRoute().GetLocation();
        Genome g = l.GetGenome();
        boolean added = v.Add(g);
        if(!added){
            Skeleton.methodReturn(this);
            return;
        }
        boolean win = Skeleton.yesOrNoInput("Did the player win?");
        if(win){
            Controller.End();
        }
        v.SetState(State.AFTER_ACTION);
        Skeleton.methodReturn(this);
    }
}
