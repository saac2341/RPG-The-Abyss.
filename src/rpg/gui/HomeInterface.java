package rpg.gui;

import rpg.gui.buttons.Basebutton;
import rpg.gui.panels.BottomPanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;

import javax.swing.*;

public class HomeInterface extends JFrame {
    private JPanel mainPanel;
    private JPanel homePanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JDesktopPane desktopPane;

    public HomeInterface() {
        initComponets();
    }

    private void initComponets() {
        desktopPane = new JDesktopPane();
        desktopPane.setPreferredSize(homePanel != null ? homePanel.getPreferredSize() : null);
        homePanel.setBounds(0, 0, homePanel.getPreferredSize().width, homePanel.getPreferredSize().height);
        desktopPane.add(homePanel, JLayeredPane.DEFAULT_LAYER);
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
    }

    public static void main(String[] args) {
        new HomeInterface();
    }

}
