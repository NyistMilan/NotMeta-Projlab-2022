package game.ui.game.map;

import javax.swing.*;

public class DWareHouse extends DField{
    public DWareHouse(String s) {
        super();
        drawableID = s;
    }

    @Override
    public JButton Draw() {
        Icon icon = new ImageIcon("Images/warehouse.png");
        return new JButton(icon);
    }
}
