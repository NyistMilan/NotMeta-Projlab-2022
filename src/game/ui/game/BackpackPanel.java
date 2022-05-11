package game.ui.game;

import collectables.equipment.Axe;
import collectables.equipment.Cloak;
import collectables.equipment.Equipment;
import collectables.equipment.Gloves;
import collectables.material.Aminoacid;
import game.Controller;
import game.ui.SceneLauncher;
import game.ui.game.map.DVirologist;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Arrays;

public class BackpackPanel extends JPanel {
    private ArrayList<String> players;
    private SceneLauncher sceneLauncher;
    private GameScene gameScene;
    private final int backpackWidth = 200;
    private final int backpackHeight = 400;

    private Controller controller;

    private JLabel owner;

    public BackpackPanel(GameScene gameScene, SceneLauncher sl, ArrayList<String> players, Controller controller){
        this.gameScene = gameScene;
        this.sceneLauncher = sl;
        this.players = players;
        this.controller =controller;
        setPreferredSize(new Dimension(backpackWidth, backpackHeight));
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.green);
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        owner = new JLabel(controller.GetVirologists().get(controller.GetIndex()).GetName()+ "'s backpack");
        owner.setBounds(190, 20, 20, 20);
        this.add(owner);

        //csak tesztelés végett raktam bele
        controller.GetVirologists().get(controller.GetIndex()).GetBackpack().GetEquipments().add(new Axe());
        controller.GetVirologists().get(controller.GetIndex()).GetBackpack().GetEquipments().add(new Axe());
        controller.GetVirologists().get(controller.GetIndex()).GetBackpack().GetEquipments().add(new Cloak());
        controller.GetVirologists().get(controller.GetIndex()).GetBackpack().GetEquipments().add(new Gloves());
        controller.GetVirologists().get(controller.GetIndex()).GetBackpack().GetAminos().add(new Aminoacid());

    }

    @Override
    public void paint(Graphics g) {
        drawPlayerBackpack(g);
    }

    private void drawPlayerBackpack(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        Font nicknameFont = new Font("Consolas", Font.PLAIN, 15);
        g2d.setFont(nicknameFont);
        FontMetrics fontMetrics = g2d.getFontMetrics(g2d.getFont());
        g2d.setStroke(new BasicStroke(5));
        g2d.draw(new Line2D.Float(0,0,800,0));
        g2d.drawString(controller.GetVirologists().get(controller.GetIndex()).GetName()+"'s backpack", 25, 20);

        int linegap = 0;
            for (int i = 0; i < controller.GetVirologists().get(controller.GetIndex()).GetBackpack().GetEquipments().size(); i++) {
                g2d.drawString(controller.GetVirologists().get(controller.GetIndex()).GetBackpack().GetEquipments().get(i).GetName(),
                        25,
                        40 + linegap*15);
                linegap++;
            }

        for (int i = 0; i < controller.GetVirologists().get(controller.GetIndex()).GetBackpack().GetAminos().size(); i++) {
            g2d.drawString(controller.GetVirologists().get(controller.GetIndex()).GetBackpack().GetAminos().get(i).GetName(),
                    25,
                    40 + linegap*15);
            linegap++;
        }

        for (int i = 0; i < controller.GetVirologists().get(controller.GetIndex()).GetBackpack().GetNucleotide().size(); i++) {
            g2d.drawString(controller.GetVirologists().get(controller.GetIndex()).GetBackpack().GetNucleotide().get(i).GetName(),
                    25,
                    40 + linegap*15);
            linegap++;
        }

    }
}
