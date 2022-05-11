package game.ui.game.map;

import javax.swing.*;

public class DVirologist extends InGameButton{
    private int index;
    public DVirologist(String s, int index) {
        super();
        drawableID = s;
        this.index = index;
        int d = 20;
        switch (index){
            case 1:
                x = d;
                y = d;
                break;
            case 2:
                x = d;
                y = -d;
                break;
            case 3:
                x = -d;
                y = d;
                break;
            case 4:
                x = -d;
                y = -d;
                break;
        }
    }

    @Override
    public JButton Draw() {
        Icon icon;
        switch (index){
            case 1:
                icon = new ImageIcon("Images/red.png");
                return new JButton(icon);
            case 2:
                icon = new ImageIcon("Images/blue.png");
                return new JButton(icon);
            case 3:
                icon = new ImageIcon("Images/green.png");
                return new JButton(icon);
            case 4:
                icon = new ImageIcon("Images/yellow.png");
                return new JButton(icon);
            default:
                return null;
        }


    }
}
