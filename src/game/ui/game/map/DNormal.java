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
        Icon icon;
        if (activeStatus){
            icon = new ImageIcon("Images/normalActive.png");
        } else {
            icon = new ImageIcon("Images/normal.png");
        }
        JButton button = new JButton(icon);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Field: normal ID:" + drawableID);

        if (activeStatus){
            this.mapPanel.setActiveFiled(null);
            activeStatus = false;
        }else{
            this.mapPanel.setActiveFiled(this);
            activeStatus = true;
        }
        this.mapPanel.repaint();
    }
}
