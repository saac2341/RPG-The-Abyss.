package rpg.gui;

import rpg.gui.buttons.EstaticsBotton;
import rpg.gui.buttons.ExitBotton;
import rpg.gui.buttons.InventaryButton;
import rpg.gui.buttons.SaveBottion;
import rpg.gui.panels.HomePanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;

import javax.swing.*;

public class HomeInterface extends JFrame {
    private JPanel mainPanel;
    private JPanel homePanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JDesktopPane desktopPane;

    public HomeInterface() {
        initComponets();
    }

    private void initComponets() {
        desktopPane = new JDesktopPane();
        desktopPane.setPreferredSize(mainPanel != null ? mainPanel.getPreferredSize() : null);
        mainPanel.setBounds(0, 0, mainPanel.getPreferredSize().width, mainPanel.getPreferredSize().height);
        desktopPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);
        setContentPane(desktopPane);
        setTitle("RPG EL ABISMO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    private void createUIComponents() {
        topPanel = new TopPanel();
        middlePanel = new MiddlePanel();
        homePanel=new HomePanel();
        button1=new SaveBottion();
        button2=new ExitBotton();
        button3=new InventaryButton();
        button4=new EstaticsBotton();
    }

    public static void main(String[] args) {
        new HomeInterface();
    }

}
