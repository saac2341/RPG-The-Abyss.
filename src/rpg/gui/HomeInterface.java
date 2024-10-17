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
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    public static void main (String[] args){
        new HomeInterface();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
