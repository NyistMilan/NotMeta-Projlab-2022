package game.ui.game;

import assets.virologist.Virologist;
import game.ui.SceneLauncher;
import game.ui.game.GameScene;
import game.ui.game.map.DField;
import game.ui.game.map.DVirologist;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class MapPanel extends JLayeredPane {
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
        this.setBackground(Color.white);
        this.setLayout(null);

    }
    public void paint(Graphics g){

        for(Component component : this.getComponents()){
            this.remove(component);
        }
        for(DField df: gameScene.GetVisibleFields()){
            JButton fieldButton = df.Draw();
            fieldButton.setBounds(df.GetCoords().x - 25, df.GetCoords().y -25, 50,50);
            this.add(fieldButton, 0);
        }
        for(DVirologist dv: gameScene.GetVisibleVirologists()){
            JButton virologistButton = dv.Draw();
            virologistButton.setBounds(gameScene.GetCurrentField().GetCoords().x + dv.GetCoords().x-10,
                    gameScene.GetCurrentField().GetCoords().y + dv.GetCoords().y-10, 20,20);
            virologistButton.setBorder(new EmptyBorder(new Insets(0,0,0,0)));
            this.add(virologistButton, 1);
        }
        super.paint(g);
        double r = 35;
        for(DField df: gameScene.GetVisibleFields()){
            for(DField neighbor: df.GetNeighbors()){
                if(gameScene.GetVisibleFields().contains(neighbor)){
                    int dx = neighbor.GetCoords().x - df.GetCoords().x;
                    int dy = neighbor.GetCoords().y - df.GetCoords().y;
                    int dl = (int)Math.sqrt(dx*dx+dy*dy);
                    double rx = dx * r / dl;
                    double ry = dy * r / dl;
                    int x1 = df.GetCoords().x + (int)rx;
                    int y1 = df.GetCoords().y + (int)ry;
                    int x2 = neighbor.GetCoords().x - (int)rx;
                    int y2 = neighbor.GetCoords().y - (int)ry;
                    g.drawLine(x1, y1, x2, y2);
                }
            }
        }

    }
}
