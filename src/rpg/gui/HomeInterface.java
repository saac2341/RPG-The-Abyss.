package rpg.gui;

import rpg.gui.panels.HomePanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;
import rpg.gui.buttons.Basebutton;

import javax.swing.*;

public class HomeInterface extends JFrame {
    private JPanel mainPanel;
    private JPanel homePanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
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
        button1=new Basebutton("button1");
        button2=new Basebutton("Inventario");
        button3=new Basebutton("Tienda");

    }

    public static void main(String[] args) {
        new HomeInterface();
    }

}
