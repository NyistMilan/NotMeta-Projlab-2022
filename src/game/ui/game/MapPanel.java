package game.ui.game;

import game.ui.SceneLauncher;
import game.ui.game.GameScene;
import game.ui.game.map.DField;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MapPanel extends JPanel {
    private ArrayList<String> players;
    private SceneLauncher sceneLauncher;
    private GameScene gameScene;
    private final int mapWidth = 600;
    private final int mapHeight = 400;
    public MapPanel(GameScene gameScene, SceneLauncher sl, ArrayList<String> players){
        this.gameScene = gameScene;
        this.sceneLauncher = sl;
        this.players = players;
        this.setPreferredSize(new Dimension(mapWidth, mapHeight));
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.red);
        this.setLayout(null);
        for(DField df: gameScene.GetDMap()){
            JButton fieldButton = new JButton();
            fieldButton.setBounds(df.GetCoords().x - 25, df.GetCoords().y -25, 50,50);
            this.add(fieldButton);
        }
    }
}
