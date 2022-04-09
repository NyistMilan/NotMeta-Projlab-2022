package assets.virologist.behavior.movebehavior;

import assets.field.Field;
import assets.virologist.State;
import assets.virologist.Virologist;
import assets.virologist.behavior.killbehavior.Kill;
import assets.virologist.behavior.learnbehavior.NotLearn;
import collectables.agent.Bear;
import main.Skeleton;

import java.util.ArrayList;

public class BearMove implements MoveBehavior{
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public int GetPriority() {
        return 3;
    }

    /**
     * The field.virologist.Virologist moves to a random direction.
     *
     * @param v the field.virologist.Virologist who tries to move
     * @param d the direction he wants to move
     */

    @Override
    public void MoveToField(Virologist v, int d) {
        Skeleton.methodCall(this, "v", "d");
        Field f = v.GetRoute().GetLocation();
        ArrayList<Integer> directions = f.GetDirections();
        int newD = getRandomNumber(0, directions.size());
        Field f2 = f.GetNeighbour(newD);
        f.Remove(v);
        f2.Accept(v);
        f2.DestroyMaterials();
        ArrayList<Virologist> virologistsOnField = f2.GetVirologists();
        for (Virologist vOnField: virologistsOnField) {
            vOnField.GetInfected(v,new Bear());
        }
        v.GetRoute().Add(f2);
        v.SetState(State.BEFORE_ACTION);
        Skeleton.methodReturn(this);
    }
}
