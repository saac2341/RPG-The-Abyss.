package rpg.gui;

import rpg.gui.buttons.Basebutton;
import rpg.gui.panels.BottomPanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeInterface extends JFrame {
    private JPanel mainPanel;
    private JPanel topPanle;
    private JPanel middlePanel;
    private JPanel bottomPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel exampleLabel;
    private JDesktopPane desktopPane;

    public HomeInterface() {
        initComponets();
    }

    private void initComponets() {
        desktopPane = new JDesktopPane();
        desktopPane.setPreferredSize(mainPanel != null ? mainPanel.getPreferredSize(): null);
        mainPanel.setBounds(0,0,mainPanel.getPreferredSize().width,mainPanel.getPreferredSize().height);
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
        TopPanel topPanel = new TopPanel();
        middlePanel = new MiddlePanel();
        bottomPanel = new BottomPanel();
        button1 = new Basebutton("Button 1");
        button2 = new Basebutton("Tiendas");
        button3 = new Basebutton("Inventario");
    }

    public static void main (String[] args){
        new HomeInterface();
    }

}
