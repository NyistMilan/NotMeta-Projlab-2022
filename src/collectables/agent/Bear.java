package collectables.agent;

import assets.virologist.Virologist;
import assets.virologist.behavior.movebehavior.BearMove;
import main.Skeleton;

public class Bear extends Agent{
    @Override
    public int getDuration() {
        return -1;
    }

    @Override
    public void setDuration(int duration) {

    }

    @Override
    public int getWarranty() {
        return -1;
    }

    @Override
    public void setWarranty(int warranty) {

    }

    //TODO
    @Override
    public void Apply(Virologist v) {
        Skeleton.methodCall(this, "v");
        if(v.GetMoveBehavior().GetPriority() < 2)
            v.SetMoveBehavior(new BearMove());
        Skeleton.methodReturn(this);
    }

    @Override
    public String GetName() {
        return "bear";
    }
}
