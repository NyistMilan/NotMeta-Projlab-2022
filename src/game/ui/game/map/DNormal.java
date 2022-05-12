package game.ui.game.map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DNormal extends DField implements ActionListener {
    public DNormal(String s) {
        super();
        drawableID = s;
    }

    @Override
    public JButton Draw() {
        this.setVisible(true);
        Icon icon = new ImageIcon("Images/normal.png");
        JButton button = new JButton(icon);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Field: normal ID:" + drawableID);
    }
}
