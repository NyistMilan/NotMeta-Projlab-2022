package game.ui.game.map;

import java.util.ArrayList;

public abstract class DField extends InGameButton{
    private ArrayList<DField> neighbors;
    public DField(){
        neighbors = new ArrayList<>();
    }
    public void AddNeighbor(DField neighbor){
        neighbors.add(neighbor);
    }
    public ArrayList<DField> GetNeighbors(){
        return neighbors;
    }

}
