package assets.virologist.behavior.killbehavior;

import assets.virologist.State;
import assets.virologist.Virologist;

public class NotKill implements KillBehavior, java.io.Serializable{
    @Override
    public void Kill(Virologist v1, Virologist v2) {
        v1.SetState(State.BEFORE_ACTION);
    }
}
