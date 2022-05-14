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
        Icon icon;
        if (activeStatus){
            icon = new ImageIcon("Images/warehouseActive.png");
        } else {
            icon = new ImageIcon("Images/warehouse.png");
        }
        JButton button = new JButton(icon);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //JOptionPane.showMessageDialog(null, "Field: warehouse ID:" + drawableID);
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
