package game.ui.game;

import game.ui.SceneLauncher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    private ArrayList<String> players;

    private SceneLauncher sceneLauncher;
    private GameScene gameScene;

    public GamePanel(GameScene gameScene, SceneLauncher sl, ArrayList<String> players){
        this.players = players;
        sceneLauncher = sl;
        this.gameScene = gameScene;

        this.setPreferredSize(new Dimension(SceneLauncher.Gamewidth, SceneLauncher.Gameheight));
        this.setBackground(Color.white);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }
}
