package collectables.agent;

import assets.virologist.Virologist;
import assets.virologist.behavior.movebehavior.BearMove;
import assets.virologist.behavior.movebehavior.RandomMove;
import main.Skeleton;

public class Bear extends Agent {
    @Override
    public void Apply(Virologist v) {
        Skeleton.methodCall(this, "v");
        if(v.GetMoveBehavior().GetPriority() < 2)
            v.SetMoveBehavior(new BearMove());
        Skeleton.methodReturn(this);
    }
}
