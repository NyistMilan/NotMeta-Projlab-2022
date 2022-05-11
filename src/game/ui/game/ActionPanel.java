package game.ui.game;

import game.ui.SceneLauncher;
import game.ui.StyledMenuButtonUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ActionPanel extends JPanel implements ActionListener {
    private ArrayList<String> players;
    private SceneLauncher sceneLauncher;
    private GameScene gameScene;
    private final int actionWidth = 600;
    private final int actionHeight = 400;
    private JLabel label;
    private JButton move;
    private JButton learn;
    private JButton pickUp;
    private JButton drop;
    private JButton create;
    private JButton infect;
    private JButton steal;
    private JButton kill;
    private JButton endTurn;

    public ActionPanel(GameScene gameScene, SceneLauncher sl, ArrayList<String> players){
        this.gameScene = gameScene;
        this.sceneLauncher = sl;
        this.players = players;
        setPreferredSize(new Dimension(actionWidth, actionHeight));
        setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.cyan);
        this.setLayout(null);
        Font actionFont = new Font("Calibri", Font.PLAIN, 15);
        Color actionColor = new Color(0x2dce98);
        int width = 80;
        int xGap = 16;
        int height = 40;
        int yGap = 8;

        label = new JLabel("Actions");
        label.setFont(actionFont);
        label.setBounds(190, yGap, width, height);
        this.add(label);

        move = new JButton("Move");
        move.setFont(actionFont);
        move.addActionListener(this);
        move.setUI(new StyledMenuButtonUI());
        move.setBackground(actionColor);
        move.setBounds(xGap, 2*yGap+height, width, height);
        this.add(move);

        learn = new JButton("Learn");
        learn.setFont(actionFont);
        learn.addActionListener(this);
        learn.setUI(new StyledMenuButtonUI());
        learn.setBackground(actionColor);
        learn.setBounds(2*xGap+width, 2*yGap+height, width, height);
        this.add(learn);

        pickUp = new JButton("Pick up");
        pickUp.setFont(actionFont);
        pickUp.addActionListener(this);
        pickUp.setUI(new StyledMenuButtonUI());
        pickUp.setBackground(actionColor);
        pickUp.setBounds(3*xGap+2*width, 2*yGap+height, width, height);
        this.add(pickUp);

        drop = new JButton("Drop");
        drop.setFont(actionFont);
        drop.addActionListener(this);
        drop.setUI(new StyledMenuButtonUI());
        drop.setBackground(actionColor);
        drop.setBounds(4*xGap+3*width, 2*yGap+height, width, height);
        this.add(drop);

        create = new JButton("Create");
        create.setFont(actionFont);
        create.addActionListener(this);
        create.setUI(new StyledMenuButtonUI());
        create.setBackground(actionColor);
        create.setBounds(xGap, 3*yGap+2*height, width, height);
        this.add(create);

        infect = new JButton("Infect");
        infect.setFont(actionFont);
        infect.addActionListener(this);
        infect.setUI(new StyledMenuButtonUI());
        infect.setBackground(actionColor);
        infect.setBounds(2*xGap+width, 3*yGap+2*height, width, height);
        this.add(infect);

        steal = new JButton("Steal");
        steal.setFont(actionFont);
        steal.addActionListener(this);
        steal.setUI(new StyledMenuButtonUI());
        steal.setBackground(actionColor);
        steal.setBounds(3*xGap+2*width, 3*yGap+2*height, width, height);
        this.add(steal);

        kill = new JButton("Kill");
        kill.setFont(actionFont);
        kill.addActionListener(this);
        kill.setUI(new StyledMenuButtonUI());
        kill.setBackground(actionColor);
        kill.setBounds(4*xGap+3*width, 3*yGap+2*height, width, height);
        this.add(kill);

        endTurn = new JButton("End turn");
        endTurn.setFont(actionFont);
        endTurn.addActionListener(this);
        endTurn.setUI(new StyledMenuButtonUI());
        endTurn.setBackground(actionColor);
        endTurn.setBounds(200-width, 4*yGap+3*height, 2*width, height);
        this.add(endTurn);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
