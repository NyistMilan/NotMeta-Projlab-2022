package game.ui.menu;

import game.ui.SceneLauncher;
import game.ui.menu.MenuPanel;

import javax.swing.*;

public class MenuScene extends JFrame {

    public MenuScene(SceneLauncher sl){
        this.setTitle("Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(SceneLauncher.Gamewidth, SceneLauncher.Gameheight);
        this.setLocationRelativeTo(null);
        this.add(new MenuPanel(this, sl));
        this.pack();
        this.setVisible(true);
    }
}
