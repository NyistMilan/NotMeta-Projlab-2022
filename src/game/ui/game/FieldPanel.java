package game.ui.game;

import game.ui.SceneLauncher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FieldPanel extends JPanel {
    private ArrayList<String> players;
    private SceneLauncher sceneLauncher;
    private GameScene gameScene;
    private final int fieldWidth = 400;
    private final int fieldHeight = 200;
    public FieldPanel(GameScene gameScene, SceneLauncher sl, ArrayList<String> players){
        this.gameScene = gameScene;
        this.sceneLauncher = sl;
        this.players = players;
        setPreferredSize(new Dimension(fieldWidth, fieldHeight));
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.blue);
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }
}
