package collectables.equipment;

import assets.virologist.Virologist;
import assets.virologist.behavior.killbehavior.Kill;
import collectables.Collectable;

public class Axe extends Equipment implements java.io.Serializable{

    public Axe(){
        durability=1;
    }

    @Override
    public void DecreaseEquipmentDurability() {
        durability--;
    }

    @Override
    public void Apply(Virologist v) {
        v.SetKillBehavior(new Kill(this));
    }

    @Override
    public String GetName() {
        return "axe";
    }
}
