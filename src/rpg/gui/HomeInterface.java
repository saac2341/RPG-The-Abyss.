package rpg.gui;

import rpg.gui.Labels.GoldLabel;
import rpg.gui.Labels.NameLabel;
import rpg.gui.buttons.EstaticsBotton;
import rpg.gui.buttons.ExitBotton;
import rpg.gui.buttons.InventaryButton;
import rpg.gui.buttons.SaveBottion;
import rpg.gui.panels.HomePanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;
import rpg.gui.Labels.BarLabel;
import rpg.enums.BarType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HomeInterface extends JFrame {
    private JPanel mainPanel;
    private JPanel homePanel;
    private JPanel topPanel;
    private JPanel middlePanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel lifeLabel;
    private JLabel magicLabel;
    private JLabel expLabel;
    private JLabel goldLabel;
    private JLabel nameLabel;
    private JButton buttonSkills;
    private JButton buttonAttack;
    private JButton buttonExit;
    private JTextArea textDisplay;
    private JScrollPane textScroll;
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
        ((BarLabel) lifeLabel).initComponents();
        ((BarLabel) magicLabel).initComponents();
        ((BarLabel) expLabel).initComponents();
        /**
         * Acciones previas en el panel
         */
        textScroll.getViewport().setOpaque(false);
        textScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textDisplay.setFont(UIConstants.FONT.deriveFont(22f));
        textDisplay.setBorder(new EmptyBorder(10,10,10,10));
        textDisplay.setForeground(Color.BLACK);
        textDisplay.setLineWrap(true);
        textDisplay.setWrapStyleWord(true);
        appendText("Hola Mundo");

    }

    private void createUIComponents() {

        topPanel = new TopPanel();
        middlePanel = new MiddlePanel();
        homePanel=new HomePanel();
        button1 =new SaveBottion();
        button2=new ExitBotton();
        button3=new InventaryButton();
        button4=new EstaticsBotton();
        lifeLabel = new BarLabel(100, 100, BarType.LIFE);
        magicLabel = new BarLabel(100, 100, BarType.MAGIC);
        expLabel = new BarLabel(100, 100, BarType.EXPERIENCE);
        goldLabel=new GoldLabel();
        nameLabel= new NameLabel("{Mago} LVL. 1");
    }

    public static void main(String[] args) {
        new HomeInterface();
    }

    public void appendText(String text) {
        /**
         * Añadimos el texto al textDisplay
         */
        textDisplay.append(text);
        /**
         * Hacemos que el textDisplay se poscicione en la última línea
         */
        textDisplay.setCaretPosition(textDisplay.getDocument().getLength());
    }

}
