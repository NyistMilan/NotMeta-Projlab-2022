package game.ui.game;

import game.ui.SceneLauncher;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    private ArrayList<String> players;

    private SceneLauncher sceneLauncher;
    private GameScene gameScene;
    private MapPanel mapPanel;
    private BackpackPanel backpackPanel;
    private FieldPanel fieldPanel;
    private ActionPanel actionPanel;


    public GamePanel(GameScene gameScene, SceneLauncher sl, ArrayList<String> players){
        this.players = players;
        sceneLauncher = sl;
        this.gameScene = gameScene;

        this.setPreferredSize(new Dimension(sceneLauncher.Gamewidth, sceneLauncher.Gameheight));
        this.setBackground(Color.white);
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        mapPanel = new MapPanel(gameScene, sceneLauncher, players);
        backpackPanel = new BackpackPanel(gameScene, sceneLauncher, players);
        fieldPanel = new FieldPanel(gameScene, sceneLauncher, players);
        actionPanel = new ActionPanel(gameScene, sceneLauncher, players);
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(mapPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(backpackPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(fieldPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(actionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(mapPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(backpackPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(actionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))

        );

    }
}
