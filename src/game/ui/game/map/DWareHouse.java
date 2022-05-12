package game.ui.game.map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DWareHouse extends DField implements ActionListener {
    public DWareHouse(String s) {
        super();
        drawableID = s;
    }

    @Override
    public JButton Draw() {
        Icon icon = new ImageIcon("Images/warehouse.png");
        JButton button = new JButton(icon);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Field: warehouse ID:" + drawableID);
    }
}
