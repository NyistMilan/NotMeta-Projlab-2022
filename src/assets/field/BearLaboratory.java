package assets.field;

import assets.Backpack;
import assets.virologist.Virologist;
import assets.virologist.behavior.learnbehavior.Learn;
import assets.virologist.behavior.movebehavior.BearMove;
import collectables.agent.Bear;
import collectables.genome.Genome;
import main.Skeleton;

import java.util.ArrayList;

public class BearLaboratory extends Field{

    public BearLaboratory(){
        Skeleton.methodCall(this);
        virologists = new ArrayList<>();
        neighbours = new ArrayList<>();
        backpack = new Backpack();
        Skeleton.methodReturn(this);
    }

    @Override
    /** If the field.virologist.Virologist steps on a field.field.BearLaboratory he got infected with bear agent*/
    public void Accept(Virologist v) {
        Skeleton.methodCall(this, "v");
        v.GetInfected(v,new Bear());
        Skeleton.methodReturn(this);
    }

    @Override
    public Genome GetGenome() {
        return null;
    }
}
