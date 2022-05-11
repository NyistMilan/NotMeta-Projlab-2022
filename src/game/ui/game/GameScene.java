package game.ui.game;

import assets.field.Field;
import assets.virologist.Virologist;
import game.Controller;
import game.ui.SceneLauncher;
import game.ui.game.map.*;

import javax.swing.*;
import java.awt.*;
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

        while(players.size() < controller.GetVirologists().size()){
            controller.GetVirologists().remove(controller.GetVirologists().size()-1);
        }
        for (int i=0; i<players.size();i++){
            controller.GetVirologists().get(i).SetName(players.get(i));
        }
        for (int i=0; i<players.size();i++){
            Virologist v = controller.GetVirologists().get(i);
            dVirologists.add(new DVirologist(v.GetName(), i+1));
        }
        for(Field f :controller.GetMap()){
            String type = f.GetType();
            switch (type){
                case "normal":
                    dmap.add(new DNormal(f.GetFieldID()));
                    break;
                case "laboratory":
                    dmap.add(new DLaboratory(f.GetFieldID()));
                    break;
                case "bearlaboratory":
                    dmap.add(new DLaboratory(f.GetFieldID()));
                    break;
                case "warehouse":
                    dmap.add(new DWareHouse(f.GetFieldID()));
                    break;
                case "shelter":
                    dmap.add(new DShelter(f.GetFieldID()));
                    break;
            }
        }
        for(int i = 0; i < dmap.size(); i++){
            dmap.get(i).SetCoords(controller.GetFieldCoords().get(i));
        }
        for(Field f :controller.GetMap()){
            DField df1 = FindDFieldByID(f.GetFieldID());
            for(int d :f.GetDirections()){
                String ID = f.GetNeighbour(d).GetFieldID();
                DField df2 = FindDFieldByID(ID);
                df1.AddNeighbor(df2);
            }
        }

        controller.Start();
        this.add(new GamePanel(this, sl, players, controller));


        this.pack();
        this.setVisible(true);
    }
    private DField FindDFieldByID(String ID){
        for(DField d : dmap)
            if(d.GetID().equals(ID))
                return d;
        return null;
    }
    private DVirologist FindVirologistByName(String ID){
        for(DVirologist d : dVirologists)
            if(d.GetID().equals(ID))
                return d;
        return null;
    }
    public ArrayList<DField> GetDMap(){
        return dmap;
    }
    public ArrayList<DVirologist> GetVisibleVirologists(){
        ArrayList<DVirologist> visible = new ArrayList<>();
        Field f = controller.GetCurrentVirologist().GetRoute().GetLocation();
        for(Virologist v: f.GetVirologists()){
            visible.add(FindVirologistByName(v.GetName()));
        }
        return visible;
    }
    public ArrayList<DField> GetVisibleFields(){
        Virologist v = controller.GetCurrentVirologist();
        ArrayList<DField> visible = new ArrayList<>();
        for(Field f : v.GetRoute().fields){
            visible.add(FindDFieldByID(f.GetFieldID()));
        }
        DField actual = FindDFieldByID(v.GetRoute().GetLocation().GetFieldID());
        for(DField df : actual.GetNeighbors()){
            if(!visible.contains(df))
                visible.add(df);
        }
        return visible;
    }
    public DField GetCurrentField(){
        return FindDFieldByID(controller.GetCurrentField().GetFieldID());
    }

}
