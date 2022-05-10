package game.ui.game;

import assets.field.Field;
import assets.virologist.Virologist;
import game.Controller;
import game.ui.SceneLauncher;
import game.ui.game.map.*;

import javax.swing.*;
import java.util.ArrayList;

public class GameScene extends JFrame{
    private Controller controller;
    private ArrayList<DField> dmap;
    private ArrayList<DVirologist> dVirologists;
    public GameScene(SceneLauncher sl, ArrayList<String> players){
        this.setTitle("Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(SceneLauncher.Gamewidth, SceneLauncher.Gameheight);
        this.setLocationRelativeTo(null);
        this.dmap = new ArrayList<>();
        this.dVirologists = new ArrayList<>();
        controller = new Controller();
        controller.ImportMap("map.txt");
        for(Field f :controller.GetMap()){
            String type = f.GetType();
            switch (type){
                case "normal":
                    dmap.add(new DNormal("d" + f.GetFieldID()));
                    break;
                case "laboratory":
                    dmap.add(new DLaboratory("d" + f.GetFieldID()));
                    break;
                case "bearlaboratory":
                    dmap.add(new DLaboratory("d" + f.GetFieldID()));
                    break;
                case "warehouse":
                    dmap.add(new DWareHouse("d" + f.GetFieldID()));
                    break;
                case "shelter":
                    dmap.add(new DShelter("d" + f.GetFieldID()));
                    break;
            }
        }
        for(int i = 0; i < dmap.size(); i++){
            dmap.get(i).SetCoords(controller.GetFieldCoords().get(i));
        }
        for(Virologist v: controller.GetVirologists()){
            dVirologists.add(new DVirologist("d" + v.GetName()));
        }
        this.add(new GamePanel(this, sl, players));
        this.pack();
        this.setVisible(true);
    }
    public ArrayList<DField> GetDMap(){
        return dmap;
    }
}
