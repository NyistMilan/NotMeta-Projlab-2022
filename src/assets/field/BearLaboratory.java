package assets.field;

import assets.virologist.Virologist;
import collectables.agent.Bear;
import collectables.genome.Genome;
import main.Skeleton;

public class BearLaboratory extends Laboratory{


    /**
     * Constructor
     *
     * @param g genome
     */
    public BearLaboratory(Genome g) {
        super(g);
    }

    @Override
    /**
     *  If the field.virologist.Virologist steps on a field.field.BearLaboratory he got infected with bear agent
     *
     * @param v virologist
     **/
    public void Accept(Virologist v) {
        Skeleton.methodCall(this, "v");
        v.GetInfected(v,new Bear());
        virologists.add(v);
        Skeleton.methodReturn(this);
    }

    @Override
    public void AcceptRandomOff(Virologist v){
        v.GetInfectedRandomOff(v,new Bear());
        virologists.add(v);
    }

    @Override
    public String GetType(){
        return "bearlaboratory";
    }
}
