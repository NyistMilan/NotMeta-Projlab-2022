package game.ui.game.map;

import javax.swing.*;
import java.awt.*;

public class DLaboratory extends DField{
    public DLaboratory(String s) {
        super();
        drawableID = s;
    }

    @Override
    public JButton Draw() {

        Icon icon = new ImageIcon("Images/laboratory.png");
        return new JButton(icon);
    }
}
