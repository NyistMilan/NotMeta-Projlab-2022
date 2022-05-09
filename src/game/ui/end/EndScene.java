package game.ui.end;

import game.ui.SceneLauncher;

import javax.swing.*;

public class EndScene extends JFrame{
    public EndScene(SceneLauncher sl){
        this.setTitle("End Scene");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(SceneLauncher.Gamewidth, SceneLauncher.Gameheight);
        this.setLocationRelativeTo(null);
        this.add(new EndPanel(this, sl, sl.GetWinner()));
        this.pack();
        this.setVisible(true);
    }
}
