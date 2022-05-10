package game.ui.game;

import game.ui.SceneLauncher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ActionPanel extends JPanel {
    private ArrayList<String> players;
    private SceneLauncher sceneLauncher;
    private GameScene gameScene;
    private final int actionWidth = 600;
    private final int actionHeight = 400;
    public ActionPanel(GameScene gameScene, SceneLauncher sl, ArrayList<String> players){
        this.gameScene = gameScene;
        this.sceneLauncher = sl;
        this.players = players;
        setPreferredSize(new Dimension(actionWidth, actionHeight));
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.cyan);
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }
}
