package game.ui.game.map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DShelter extends DField implements ActionListener {
    public DShelter(String s) {
        super();
        drawableID = s;
    }

    @Override
    public JButton Draw() {
        Icon icon;
        if (activeStatus){
            icon = new ImageIcon("Images/shelterActive.png");
        } else {
            icon = new ImageIcon("Images/shelter.png");
        }
        JButton button = new JButton(icon);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Field: shelter ID:" + drawableID);
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
