package game.ui.game;

import game.ui.SceneLauncher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BackpackPanel extends JPanel {
    private ArrayList<String> players;
    private SceneLauncher sceneLauncher;
    private GameScene gameScene;
    private final int backpackWidth = 200;
    private final int backpackHeight = 400;
    public BackpackPanel(GameScene gameScene, SceneLauncher sl, ArrayList<String> players){
        this.gameScene = gameScene;
        this.sceneLauncher = sl;
        this.players = players;
        setPreferredSize(new Dimension(backpackWidth, backpackHeight));
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.green);
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }
}
