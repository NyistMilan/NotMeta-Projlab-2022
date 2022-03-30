package assets.virologist.behavior.killbehavior;

import assets.virologist.State;
import assets.virologist.Virologist;
import collectables.equipment.Axe;

public class Kill implements KillBehavior{

    Axe axe;
    public Kill(Axe axe){
        this.axe=axe;

    }
    @Override
    public void Kill(Virologist v1, Virologist v2) {
        axe.DecreaseEquipmentDurability();
        v2.SetState(State.KILLED);
        v1.SetState(State.AFTER_ACTION);
    }
}
