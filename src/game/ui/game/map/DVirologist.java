package game.ui.game.map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DVirologist extends InGameButton implements ActionListener {
    private int index;
    public DVirologist(String s, int index) {
        super();
        drawableID = s;
        this.index = index;
        int d = 20;
        switch (index){
            case 1:
                x = d;
                y = d;
                break;
            case 2:
                x = d;
                y = -d;
                break;
            case 3:
                x = -d;
                y = d;
                break;
            case 4:
                x = -d;
                y = -d;
                break;
        }
    }

    @Override
    public JButton Draw() {
        Icon icon;
        JButton button;
        switch (index){
            case 1:
                icon = new ImageIcon("Images/red.png");
                button = new JButton(icon);
                button.addActionListener(this);
                return button;
            case 2:
                icon = new ImageIcon("Images/blue.png");
                button = new JButton(icon);
                button.addActionListener(this);
                return button;
            case 3:
                icon = new ImageIcon("Images/green.png");
                button = new JButton(icon);
                button.addActionListener(this);
                return button;
            case 4:
                icon = new ImageIcon("Images/yellow.png");
                button = new JButton(icon);
                button.addActionListener(this);
                return button;
            default:
                return null;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "Virologist: name: " + drawableID);
    }

}
