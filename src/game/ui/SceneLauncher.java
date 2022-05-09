package game.ui;

import game.ui.end.EndScene;
import game.ui.game.GameScene;
import game.ui.menu.MenuScene;

import java.util.ArrayList;

public class SceneLauncher {

    public static final int Gamewidth = 800;
    public static final int Gameheight = 600;
    public ArrayList<String> players = new ArrayList<>();
    public enum GLOBALGAMESTATES{
        Menu,
        Game,
        End
    }

    //ITT tudod a kezdő panelt változtatni...
    public SceneLauncher(){
        new EndScene(this);
    }

    public void SwitchScenes(GLOBALGAMESTATES globalgamestates){
        switch (globalgamestates){
            case Menu:
                new MenuScene(this);
                break;
            case Game:
                new GameScene(this,players);
                break;
            case End:
                new EndScene(this);
                break;
        }
    }

    //TODO
    public void SetWinner(String virologist){

    }

    public void SetPlayerNames(ArrayList<String> players){
        this.players = players;
    }

    //TODO
    public String GetWinner(){
        String alma = "Zoli:)";
        return alma;
    }
}
