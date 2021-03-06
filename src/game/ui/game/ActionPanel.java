package game.ui.game;

import assets.virologist.State;
import collectables.agent.Agent;
import collectables.equipment.Equipment;
import collectables.genome.Genome;
import collectables.material.Aminoacid;
import collectables.material.Nucleotide;
import game.Controller;
import game.ui.SceneLauncher;
import game.ui.StyledMenuButtonUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Panel which contains the buttons of actions.
 */
public class ActionPanel extends JPanel implements ActionListener {
    private ArrayList<String> players;
    private Controller controller;
    private SceneLauncher sceneLauncher;
    private GameScene gameScene;
    private BackpackPanel backpackPanel;
    private MapPanel mapPanel;
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

    /**
     *constructor of the ActionPanel
     */
    public ActionPanel(GameScene gameScene, SceneLauncher sl, ArrayList<String> players, Controller controller, BackpackPanel backpackPanel, MapPanel mapPanel) {
        this.gameScene = gameScene;
        this.sceneLauncher = sl;
        this.players = players;
        this.controller = controller;
        this.backpackPanel = backpackPanel;
        this.mapPanel = mapPanel;
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
        move.setBounds(xGap, 2 * yGap + height, width, height);
        this.add(move);

        learn = new JButton("Learn");
        learn.setFont(actionFont);
        learn.addActionListener(this);
        learn.setUI(new StyledMenuButtonUI());
        learn.setBackground(actionColor);
        learn.setBounds(2 * xGap + width, 2 * yGap + height, width, height);
        this.add(learn);

        pickUp = new JButton("Pick up");
        pickUp.setFont(actionFont);
        pickUp.addActionListener(this);
        pickUp.setUI(new StyledMenuButtonUI());
        pickUp.setBackground(actionColor);
        pickUp.setBounds(3 * xGap + 2 * width, 2 * yGap + height, width, height);
        this.add(pickUp);

        drop = new JButton("Drop");
        drop.setFont(actionFont);
        drop.addActionListener(this);
        drop.setUI(new StyledMenuButtonUI());
        drop.setBackground(actionColor);
        drop.setBounds(4 * xGap + 3 * width, 2 * yGap + height, width, height);
        this.add(drop);

        create = new JButton("Create");
        create.setFont(actionFont);
        create.addActionListener(this);
        create.setUI(new StyledMenuButtonUI());
        create.setBackground(actionColor);
        create.setBounds(xGap, 3 * yGap + 2 * height, width, height);
        this.add(create);

        infect = new JButton("Infect");
        infect.setFont(actionFont);
        infect.addActionListener(this);
        infect.setUI(new StyledMenuButtonUI());
        infect.setBackground(actionColor);
        infect.setBounds(2 * xGap + width, 3 * yGap + 2 * height, width, height);
        this.add(infect);

        steal = new JButton("Steal");
        steal.setFont(actionFont);
        steal.addActionListener(this);
        steal.setUI(new StyledMenuButtonUI());
        steal.setBackground(actionColor);
        steal.setBounds(3 * xGap + 2 * width, 3 * yGap + 2 * height, width, height);
        this.add(steal);

        kill = new JButton("Kill");
        kill.setFont(actionFont);
        kill.addActionListener(this);
        kill.setUI(new StyledMenuButtonUI());
        kill.setBackground(actionColor);
        kill.setBounds(4 * xGap + 3 * width, 3 * yGap + 2 * height, width, height);
        this.add(kill);

        endTurn = new JButton("End turn");
        endTurn.setFont(actionFont);
        endTurn.addActionListener(this);
        endTurn.setUI(new StyledMenuButtonUI());
        endTurn.setBackground(actionColor);
        endTurn.setBounds(200 - width, 4 * yGap + 3 * height, 2 * width, height);
        this.add(endTurn);


    }

    /**
     * It overrides the paint method
     * @param g the graphics class
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Update();
    }

    /**
     * This method updates the states of all button.
     */
    public void Update() {
        State state = controller.GetCurrentVirologist().GetState();
        switch (state) {
            case BEFORE_MOVE:
                move.setEnabled(true);
                learn.setEnabled(false);
                pickUp.setEnabled(false);
                drop.setEnabled(false);
                create.setEnabled(false);
                infect.setEnabled(false);
                steal.setEnabled(false);
                kill.setEnabled(false);
                endTurn.setEnabled(true);
                break;
            case BEFORE_ACTION:
                move.setEnabled(false);
                learn.setEnabled(true);
                pickUp.setEnabled(true);
                drop.setEnabled(true);
                create.setEnabled(true);
                infect.setEnabled(true);
                steal.setEnabled(true);
                kill.setEnabled(true);
                endTurn.setEnabled(true);
                break;
            case AFTER_ACTION:
                move.setEnabled(false);
                learn.setEnabled(false);
                pickUp.setEnabled(false);
                drop.setEnabled(false);
                create.setEnabled(false);
                infect.setEnabled(false);
                steal.setEnabled(false);
                kill.setEnabled(false);
                endTurn.setEnabled(true);
                break;
            case NOT_IN_TURN:
                move.setEnabled(false);
                learn.setEnabled(false);
                pickUp.setEnabled(false);
                drop.setEnabled(false);
                create.setEnabled(false);
                infect.setEnabled(false);
                steal.setEnabled(false);
                kill.setEnabled(false);
                endTurn.setEnabled(false);
                break;
            default:
                endTurn.setEnabled(true);
        }
    }

    /**
     * This handles all the actions, get inputs from the player and call to the controllers methods.
     * @param e the event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == endTurn) {
            controller.EndTurn();
            JOptionPane.showMessageDialog(null, "Start " + controller.GetVirologists().get(controller.GetIndex()).GetName() + "'s turn");
            gameScene.repaint();
        } else if (e.getSource() == move) {
            int dir = 0;
            if (mapPanel.getActiveField() == null)
                JOptionPane.showMessageDialog(null, "Select a field to move!");
            else {
                String id = mapPanel.getActiveField().GetID();
                ArrayList<Integer> directions = controller.GetCurrentField().GetDirections();
                for (Integer d : directions) {
                    if (controller.GetCurrentField().GetNeighbour(d).GetFieldID().equals(id)) {
                        dir = d;
                        break;
                    }
                }
                controller.MoveVirologist(dir);
                mapPanel.setActiveFiled(null);
                gameScene.repaint();
            }
        } else if (e.getSource() == learn) {
            controller.LearnGenome();
            gameScene.repaint();
        } else if (e.getSource() == pickUp) {
            ArrayList<Aminoacid> aminoList = controller.GetCurrentField().GetBackpack().GetAminos();
            ArrayList<Nucleotide> nucleoList = controller.GetCurrentField().GetBackpack().GetNucleotide();
            ArrayList<Equipment> equipmentList = controller.GetCurrentField().GetBackpack().GetEquipments();
            String[] names = {"Aminoacid", "Nucleotide", "Equipment"};
            int x = JOptionPane.showOptionDialog(null, "Choose what you want to pick up!",
                    "Choose",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, names, names[0]);

            switch (x) {
                case 0:
                    JOptionPane optionPane = new JOptionPane();
                    if (aminoList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "There's no aminoacid on the field");
                        break;
                    } else {
                        JSlider slider = getSlider(optionPane, aminoList.size());
                        optionPane.setMessage(new Object[]{"Select a value of aminoacid's to pick up: ", slider});
                        optionPane.setMessageType(JOptionPane.QUESTION_MESSAGE);
                        optionPane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
                        JDialog dialog = optionPane.createDialog(null, "My Slider");
                        dialog.setVisible(true);
                        int value = slider.getValue();
                        controller.TakeAminoacid(value);
                        break;
                    }

                case 1:
                    JOptionPane optionPane2 = new JOptionPane();
                    if (nucleoList.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "There's no nucleotid on the field");
                        break;
                    } else {
                        JSlider slider2 = getSlider(optionPane2, nucleoList.size());
                        optionPane2.setMessage(new Object[]{"Select a value of nucleotide's to pick up: ", slider2});
                        optionPane2.setMessageType(JOptionPane.QUESTION_MESSAGE);
                        optionPane2.setOptionType(JOptionPane.OK_CANCEL_OPTION);
                        JDialog dialog2 = optionPane2.createDialog(null, "Capacity");
                        dialog2.setVisible(true);
                        int value2 = slider2.getValue();
                        controller.TakeNucleotide(value2);
                        break;
                    }
                case 2:
                    ArrayList<String> list = new ArrayList<>();
                    for (Equipment eq : equipmentList) {
                        list.add(eq.GetName());
                    }
                    Object[] equipments = list.toArray();
                    if (equipments.length != 0) {
                        int index = JOptionPane.showOptionDialog(null, "Choose what you want to pick up!",
                                "Choose",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, equipments, equipments[0]);
                        controller.TakeEquipment(index + 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "There's no Equipment on the field");
                    }
                    break;
            }
            gameScene.repaint();
        } else if (e.getSource() == drop) {
            ArrayList<Aminoacid> aminoList = controller.GetCurrentVirologist().GetBackpack().GetAminos();
            ArrayList<Nucleotide> nucleoList = controller.GetCurrentVirologist().GetBackpack().GetNucleotide();
            ArrayList<Equipment> equipmentList = controller.GetCurrentVirologist().GetBackpack().GetEquipments();
            String[] names = {"Aminoacid", "Nucleotide", "Equipment"};
            int x = JOptionPane.showOptionDialog(null, "Choose what you want to drop!",
                    "Choose",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, names, names[0]);

            switch (x) {
                case 0:
                    JOptionPane optionPane = new JOptionPane();
                    JSlider slider = getSlider(optionPane, aminoList.size());
                    optionPane.setMessage(new Object[]{"Select a value of aminoacid's to drop: ", slider});
                    optionPane.setMessageType(JOptionPane.QUESTION_MESSAGE);
                    optionPane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
                    JDialog dialog = optionPane.createDialog(null, "My Slider");
                    dialog.setVisible(true);
                    int value = slider.getValue();
                    controller.DropAminoacid(value);
                    break;
                case 1:
                    JOptionPane optionPane2 = new JOptionPane();
                    JSlider slider2 = getSlider(optionPane2, nucleoList.size());
                    optionPane2.setMessage(new Object[]{"Select a value of nucleotide's to drop: ", slider2});
                    optionPane2.setMessageType(JOptionPane.QUESTION_MESSAGE);
                    optionPane2.setOptionType(JOptionPane.OK_CANCEL_OPTION);
                    JDialog dialog2 = optionPane2.createDialog(null, "Capacity");
                    dialog2.setVisible(true);
                    int value2 = slider2.getValue();
                    controller.DropNucleotide(value2);
                    break;
                case 2:
                    ArrayList<String> list = new ArrayList<>();
                    for (Equipment eq : equipmentList) {
                        list.add(eq.GetName());
                    }
                    Object[] equipments = list.toArray();
                    int index = JOptionPane.showOptionDialog(null, "Choose what you want to drop!",
                            "Choose",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, equipments, equipments[0]);

                    controller.DropEquipment(index + 1);
                    break;
            }
            gameScene.repaint();
        } else if (e.getSource() == create) {
            if (controller.GetCurrentVirologist().GetLearnedGenomes().isEmpty())
                JOptionPane.showMessageDialog(null, "You can not create any agents yet");
            else {
                ArrayList<String> list = new ArrayList<>();
                for (Genome g : controller.GetCurrentVirologist().GetLearnedGenomes()) {
                    String create = g.GetName() + " a:" + g.getAminoCost() + " n:" + g.getNucleoCost();
                    list.add(create);
                }
                Object[] options = list.toArray();
                int index = JOptionPane.showOptionDialog(null, "Choose what you want to create!",
                        "Choose",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                controller.CreateAgent(controller.GetCurrentVirologist().GetLearnedGenomes().get(index).GetName());
                gameScene.repaint();
            }
        } else if (e.getSource() == infect) {
            if (mapPanel.getActiveVirologist() == null)
                JOptionPane.showMessageDialog(null, "Select a virologist to infect!");
            else if (controller.GetCurrentVirologist().GetBackpack().GetAgents().isEmpty())
                JOptionPane.showMessageDialog(null, "You have no agents.");
            else {
                ArrayList<String> list = new ArrayList<>();
                for (Agent a : controller.GetCurrentVirologist().GetBackpack().GetAgents()) {
                    String create = a.GetName() + " warranty:" + a.getWarranty();
                    list.add(create);
                }
                Object[] options = list.toArray();
                int index = JOptionPane.showOptionDialog(null, "Choose the agent to infect with!",
                        "Choose",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                controller.InfectVirologist(mapPanel.getActiveVirologist().GetVirologistName(), index + 1);
                gameScene.repaint();
            }
        } else if (e.getSource() == steal) {
            if (mapPanel.getActiveVirologist() == null)
                JOptionPane.showMessageDialog(null, "Select a virologist to steal from!");
            else {
                ArrayList<Aminoacid> aminoList = controller.GetVirologist(mapPanel.getActiveVirologist().GetVirologistName()).GetBackpack().GetAminos();
                ArrayList<Nucleotide> nucleoList = controller.GetVirologist(mapPanel.getActiveVirologist().GetVirologistName()).GetBackpack().GetNucleotide();
                ArrayList<Equipment> equipmentList = controller.GetVirologist(mapPanel.getActiveVirologist().GetVirologistName()).GetBackpack().GetEquipments();
                String[] names = {"Aminoacid", "Nucleotide", "Equipment"};
                int x = JOptionPane.showOptionDialog(null, "Choose what you want to steal!",
                        "Choose",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, names, names[0]);

                switch (x) {
                    case 0:
                        JOptionPane optionPane = new JOptionPane();
                        JSlider slider = getSlider(optionPane, aminoList.size());
                        optionPane.setMessage(new Object[]{"Select a value of aminoacid's to steal: ", slider});
                        optionPane.setMessageType(JOptionPane.QUESTION_MESSAGE);
                        optionPane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
                        JDialog dialog = optionPane.createDialog(null, "My Slider");
                        dialog.setVisible(true);
                        int value = slider.getValue();
                        controller.StealAminoacid(mapPanel.getActiveVirologist().GetVirologistName(), value);
                        break;
                    case 1:
                        JOptionPane optionPane2 = new JOptionPane();
                        JSlider slider2 = getSlider(optionPane2, nucleoList.size());
                        optionPane2.setMessage(new Object[]{"Select a value of nucleotide's to steal: ", slider2});
                        optionPane2.setMessageType(JOptionPane.QUESTION_MESSAGE);
                        optionPane2.setOptionType(JOptionPane.OK_CANCEL_OPTION);
                        JDialog dialog2 = optionPane2.createDialog(null, "Capacity");
                        dialog2.setVisible(true);
                        int value2 = slider2.getValue();
                        controller.StealNucleotide(mapPanel.getActiveVirologist().GetVirologistName(), value2);
                        break;
                    case 2:
                        ArrayList<String> list = new ArrayList<>();
                        for (Equipment eq : equipmentList) {
                            list.add(eq.GetName());
                        }
                        Object[] equipments = list.toArray();
                        int index = JOptionPane.showOptionDialog(null, "Choose what you want to steal!",
                                "Choose",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, equipments, equipments[0]);

                        controller.StealEquipment(mapPanel.getActiveVirologist().GetVirologistName(), index + 1);
                        break;
                }
                gameScene.repaint();
            }

        } else if (e.getSource() == kill) {
            if (mapPanel.getActiveVirologist() == null)
                JOptionPane.showMessageDialog(null, "Select a virologist to kill!");
            else {
                controller.KillVirologist(mapPanel.getActiveVirologist().GetVirologistName());
                gameScene.repaint();
            }
        }
    }

    /**
     * This method create a new slider between the value of 0 and max.
     * @param optionPane the optinoPane
     * @param max the maximum value on the slider
     * @return the new slider
     */
    static JSlider getSlider(final JOptionPane optionPane, int max) {
        JSlider slider = new JSlider(0, max);
        slider.setMajorTickSpacing(2);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        ChangeListener changeListener = new ChangeListener() {
            public void stateChanged(ChangeEvent changeEvent) {
                JSlider theSlider = (JSlider) changeEvent.getSource();
                if (!theSlider.getValueIsAdjusting()) {
                    optionPane.setInputValue(theSlider.getValue());
                }
            }
        };
        slider.addChangeListener(changeListener);
        return slider;
    }
}
