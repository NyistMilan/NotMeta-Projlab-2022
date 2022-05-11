package game.ui.game;

import assets.Backpack;
import game.Controller;
import game.ui.SceneLauncher;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class FieldPanel extends JPanel {
    private ArrayList<String> players;
    private SceneLauncher sceneLauncher;
    private GameScene gameScene;
    private final int fieldWidth = 400;
    private final int fieldHeight = 200;

    private JLabel eqs;
    private Controller controller;

    public FieldPanel(GameScene gameScene, SceneLauncher sl, ArrayList<String> players, Controller controller){
        this.gameScene = gameScene;
        this.sceneLauncher = sl;
        this.players = players;
        this.controller = controller;
        setPreferredSize(new Dimension(fieldWidth, fieldHeight));
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.blue);
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        eqs = new JLabel("Field");
        eqs.setBounds(190, 20, 40, 40);
        this.add(eqs);

    }

    @Override
    public void paint(Graphics g) {
        drawOnField(g);
    }

    private void drawOnField(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        Font nicknameFont = new Font("Consolas", Font.PLAIN, 15);
        g2d.setFont(nicknameFont);
        FontMetrics fontMetrics = g2d.getFontMetrics(g2d.getFont());
        g2d.setStroke(new BasicStroke(5));
        g2d.draw(new Line2D.Float(0,0,800,0));

        Backpack backpack = controller.GetVirologists().get(controller.GetIndex()).GetRoute().GetLocation().GetBackpack();
        g2d.drawString("Equipments", 25, 20);
        for (int i = 0; i < backpack.GetEquipments().size(); i++) {
            g2d.drawString(backpack.GetEquipments().get(i).GetName(),
                    30,
                    40 + i*15);
        }

        g2d.drawString("Materials", 150, 20);
        int linegap = 0;
        for (int i = 0; i < backpack.GetAminos().size(); i++) {
            g2d.drawString(backpack.GetAminos().get(i).GetName(),
                    155,
                    40 + linegap*15);
            linegap++;
        }
        for (int i = 0; i < backpack.GetNucleotide().size(); i++) {
            g2d.drawString(backpack.GetNucleotide().get(i).GetName(),
                    155,
                    40 + linegap*15);
            linegap++;
        }

        g2d.drawString("Players", 275, 20);
        for (int i = 0; i < controller.GetVirologists().get(controller.GetIndex()).GetRoute().GetLocation().GetVirologists().size(); i++) {
            g2d.drawString(controller.GetVirologists().get(controller.GetIndex()).GetRoute().GetLocation().GetVirologists().get(i).GetName(),
                    280,
                    40 + i*15);
        }



    }
}
