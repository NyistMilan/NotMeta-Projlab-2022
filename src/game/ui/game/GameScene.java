package game.ui.game;

import game.ui.SceneLauncher;

import javax.swing.*;
import java.util.ArrayList;

public class GameScene extends JFrame{

    public GameScene(SceneLauncher sl, ArrayList<String> players){
        this.setTitle("Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(SceneLauncher.Gamewidth, SceneLauncher.Gameheight);
        this.setLocationRelativeTo(null);
        this.add(new GamePanel(this, sl, players));
        this.pack();
        this.setVisible(true);
    }
}
