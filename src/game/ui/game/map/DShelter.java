package game.ui.game.map;

import javax.swing.*;

public class DShelter extends DField{
    public DShelter(String s) {
        super();
        drawableID = s;
    }

    @Override
    public JButton Draw() {
        Icon icon = new ImageIcon("Images/shelter.png");
        return new JButton(icon);
    }
}
