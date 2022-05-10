package game.ui.game.map;

import javax.swing.*;

public class DNormal extends DField{
    public DNormal(String s) {
        super();
        drawableID = s;
    }

    @Override
    public JButton Draw() {
        Icon icon = new ImageIcon("Images/normal.png");
        return new JButton(icon);
    }
}
