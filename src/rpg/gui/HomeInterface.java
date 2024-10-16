package rpg.gui;

import javax.swing.*;

public class HomeInterface extends JFrame {

    private JPanel homePanel;

    public HomeInterface(){

        setTitle("RPG EL ABISMO");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(homePanel);
        setVisible(true);

    }

    public static void main (String[] args){
        new HomeInterface();
    }

}
