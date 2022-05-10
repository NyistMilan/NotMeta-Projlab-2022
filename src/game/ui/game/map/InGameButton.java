package game.ui.game.map;

import javax.swing.*;
import java.awt.*;

public abstract class InGameButton extends JButton {
    protected String drawableID;
    protected int x,y;
    public abstract void Draw();
    public void SetCoords(Point p){
        x = p.x;
        y = p.y;
    }
    public Point GetCoords(){
        return new Point(x,y);
    }
}
