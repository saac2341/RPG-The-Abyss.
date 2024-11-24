package rpg.gui.windows;

import rpg.entities.Player;
import rpg.entities.enemies.Enemy;
import rpg.factory.EnemyFactory;
import rpg.enums.BarType;
import rpg.enums.Stats;
import rpg.gui.UIConstants;
import rpg.gui.buttons.*;
import rpg.gui.internalFrames.InventoryFrame;
import rpg.gui.internalFrames.StatusFrame;
import rpg.gui.labels.*;
import rpg.gui.panels.HomePanel;
import rpg.gui.panels.MiddlePanel;
import rpg.gui.panels.TopPanel;


import javax.swing.*;
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
    private final JInternalFrame statusFrame;
    private final JInternalFrame inventoryFrame;
    private JTextArea textDisplay;
    private JScrollPane textScroll;
    private JDesktopPane desktopPane;
    //Sorints.
    private JLabel playerSprite;
    private JLabel enemyNameLabel;
    private JLabel enemyLifeLabel;
    private JLabel enemySprite;
    //Jugador, equipo y cosas.
    Player player;
    Enemy enemy;
    int slot;

    public HomeInterface(Player player, int slot) {

        this.player=player;
        this.slot=slot;
        initComponets();
        ((BarLabel) lifeLabel).updateBar(player.getStats().get(Stats.HP), player.getStats().get(Stats.MAX_HP));
        ((BarLabel) magicLabel).updateBar(player.getStats().get(Stats.MP), player.getStats().get(Stats.MAX_MP));
        ((BarLabel) expLabel).updateBar(player.getStats().get(Stats.EXPERIENCE), player.getStats().get(Stats.NEEDED_EXPERIENCE));
        statusFrame = new StatusFrame(this);
        inventoryFrame = new InventoryFrame(this);
        desktopPane.add(statusFrame, JLayeredPane.PALETTE_LAYER);
        desktopPane.add(inventoryFrame, JLayeredPane.PALETTE_LAYER);
        statusFrame.setLocation((desktopPane.getHeight()-statusFrame.getWidth())/2,(desktopPane.getHeight()-statusFrame.getWidth())/2);
        inventoryFrame.setLocation((desktopPane.getHeight()-inventoryFrame.getWidth())/2,(desktopPane.getHeight()-inventoryFrame.getWidth())/2);
        appendText("¡Bienvenido a RPG The Abyss!\n");
        appendText("¡Preparate para la aventura!\n");
        appendText("Aparece un nuevo enemigo: "+enemy.getName()+"\n");
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
        textScroll.getViewport().setOpaque(false);
        textScroll.setBorder(null);
        textScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        textDisplay.setFont(UIConstants.FONT.deriveFont(28f));
        textDisplay.setForeground(Color.BLACK);
        textDisplay.setColumns(1);
        textDisplay.setEditable(false);
        textDisplay.setLineWrap(true);
        textDisplay.setWrapStyleWord(true);
        goldLabel.setText(player.getStats().get(Stats.GOLD) + "G");

    }

    public void tryToFlee(){

        if (player.tryToFlee()){
            appendText("Has huido con éxito.\n");
            createEnemy();
        } else {
            appendText("No has podido huir.\n");
            appendText(enemy.attack(player));
        }
        updateBars();
    }

    public void checkGameStatus(){
        if (!player.isAlive()) {
            // En caso de que el jugador haya muerto
            // Añadimos un mensaje al textDisplay de que el jugador ha muerto
            appendText("Has muerto.\n");
            appendText("GAME OVER\n");
        } else if (!enemy.isAlive()) {
            // En caso de que el enemigo haya muerto
            // Recuperamos la experiencia y el oro del jugador y del enemigo
            int playerExp = player.getStats().get(Stats.EXPERIENCE);
            int enemyExp = enemy.getStats().get(Stats.EXPERIENCE);
            int promotionExp = player.getStats().get(Stats.NEEDED_EXPERIENCE);
            int playerGold = player.getStats().get(Stats.GOLD);
            int enemyGold = enemy.getStats().get(Stats.GOLD);
            // Calculamos el total de experiencia y oro
            int totalExp = playerExp + enemyExp;
            int totalGold = playerGold + enemyGold;
            // Añadimos un mensaje al textDisplay de que se ha derrotado al enemigo
            // y se ha ganado experiencia y oro.
            appendText("""
                    Has derrotado a %s
                    Has ganado %d puntos de experiencia.
                    Has ganado %d monedas de oro.
                    """.formatted(enemy.getName(), enemyExp, enemyGold));
            // Asignamos la nueva experiencia y oro al jugador
            player.getStats().put(Stats.EXPERIENCE, totalExp);
            player.getStats().put(Stats.GOLD, totalGold);
            goldLabel.setText(totalGold + "G");
            goldLabel.repaint();
            // Evaluamos si el jugador ha subido de nivel
            if (totalExp >= promotionExp)
                updatePlayer();
            // Creamos un nuevo enemigo en cualquier caso
            createEnemy();
        }
        updateBars();
    }

    private void createEnemy() {

        enemy = EnemyFactory.getEnemy();
        if (enemy != null) {

            enemyNameLabel.setText(enemy.getName());
            appendText("Aparece un nuevo enemigo: " + enemy.getName() + "\n");
            ((EnemySpriteLabel) enemySprite).setEnemy(enemy);
            ((NameLabel) enemyNameLabel).updateLabel(enemy.getName());
            ((BarLabel) enemyLifeLabel).updateBar(enemy.getStats().get(Stats.HP),
                    enemy.getStats().get(Stats.MAX_HP));
        }
    }

    private void updateBars() {

        ((BarLabel) lifeLabel).setBarValue(player.getStats().get(Stats.HP));
        ((BarLabel) expLabel).setBarValue(player.getStats().get(Stats.EXPERIENCE));
        ((BarLabel) enemyLifeLabel).setBarValue(enemy.getStats().get(Stats.HP));
    }

    private void updatePlayer() {

        // Actualizamos al jugador
        player.levelUp();
        // Obtenemos el nivel, vida, magia y experiencia del jugador
        int level = player.getStats().get(Stats.LEVEL);
        int hp = player.getStats().get(Stats.HP);
        int mp = player.getStats().get(Stats.MP);
        int neededExp = player.getStats().get(Stats.NEEDED_EXPERIENCE);
        // Añadimos un mensaje al textDisplay de que el jugador ha subido de nivel
        appendText("Has subido de nivel.\n");
        // Actualizamos las barras de estado del jugador
        ((BarLabel) lifeLabel).updateBar(hp, hp);
        ((BarLabel) magicLabel).updateBar(mp, mp);
        ((BarLabel) expLabel).updateBar(0, neededExp);
        // Actualizamos el nombre del jugador
        ((NameLabel) nameLabel).updateLabel(
                "%s LVL. %d".formatted(player.getName(), level));
    }

    private void createUIComponents() {

        topPanel = new TopPanel();
        middlePanel = new MiddlePanel();
        homePanel=new HomePanel();
        button1 =new SaveBottion();
        button2=new ExitButton();
        button3=new InventaryButton();
        button4=new EstaticsBotton();
        lifeLabel = new BarLabel(0, 0, BarType.LIFE);
        magicLabel = new BarLabel(0, 0, BarType.MAGIC);
        expLabel = new BarLabel(0, 0, BarType.EXPERIENCE);
        goldLabel=new GoldLabel(player.getStats().get(Stats.GOLD));
        nameLabel= new NameLabel(String.format("%s LVL. %d", player.getName(), player.getStats().get(Stats.LEVEL)));
        playerSprite=new PlayerSpriteLabel();
        enemyNameLabel=new NameLabel(enemy.getName());
        enemyLifeLabel= new BarLabel(enemy.getStats().get(Stats.HP),enemy.getStats().get(Stats.MAX_HP),BarType.LIFE);
        enemySprite=new EnemySpriteLabel(enemy);
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

    public Enemy getEnemy() {return enemy;
    }

    public Player getPlayer() {
        return player;
    }

    public JInternalFrame getInventoryFrame(){
        return inventoryFrame;
    }

    public JInternalFrame getStatusFrame{
        return statusFrame;
    }
}
