package game.ui.game.map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DLaboratory extends DField implements ActionListener {
    public DLaboratory(String s) {
        super();
        drawableID = s;
    }

    @Override
    public JButton Draw() {
        Icon icon = new ImageIcon("Images/laboratory.png");
        JButton button = new JButton(icon);
        button.addActionListener((ActionListener) this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Field: laboratory ID:" + drawableID);
    }
}
