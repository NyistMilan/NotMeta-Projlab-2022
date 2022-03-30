package assets.field;

import assets.virologist.Virologist;
import assets.virologist.behavior.learnbehavior.Learn;
import assets.virologist.behavior.movebehavior.BearMove;
import collectables.agent.Bear;
import collectables.genome.Genome;
import main.Skeleton;

public class BearLaboratory extends Laboratory{
    /**
     * Constructor
     *
     * @param g
     */
    public BearLaboratory(Genome g) {
        super(g);
    }

    @Override
    /** If the field.virologist.Virologist steps on a field.field.BearLaboratory he got infected with bear agent*/
    public void Accept(Virologist v) {
        Skeleton.methodCall(this, "v");
        v.GetInfected(v,new Bear());
        Skeleton.methodReturn(this);
    }
}
