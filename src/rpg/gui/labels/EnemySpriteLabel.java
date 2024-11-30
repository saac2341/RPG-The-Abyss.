package rpg.gui.labels;

import rpg.entities.enemies.Enemy;
import rpg.gui.ui.EnemyLabelUI;

import javax.swing.*;
import java.awt.*;

/**
 * Clase para mostar al enemigo.
 */
public class EnemySpriteLabel extends JLabel {
    ImageIcon icon;
    Enemy enemy;
    /**
     * La clase EnemySpriteLabel extiende JLabel para representar una etiqueta
     * que muestra el sprite de un enemigo en la interfaz de usuario.
     */
    public EnemySpriteLabel(Enemy enemy){
        this.enemy=enemy;;
        initComponents();
        setUI(new EnemyLabelUI(icon));
    }
    /**
     * Inicializa los componentes del EnemySpriteLabel, incluyendo la configuración
     * del sprite del enemigo y el tamaño preferido de la etiqueta.
     */
    public void initComponents(){
        icon=enemy.getSprite();
        setPreferredSize(getMinimumSize());
        setSize(getMinimumSize());
        setIcon(icon);
    }
    /**
     * Obtiene el tamaño mínimo de la etiqueta basado en el sprite del enemigo.
     * Si la altura o el ancho del ícono excede ciertos límites, se escala el ícono.
     */
     private Dimension getMinimusSize(){
        if (icon.getIconHeight()>350 || icon.getIconHeight()>184){
            icon=new ImageIcon(icon.getImage().getScaledInstance(150,250,Image.SCALE_SMOOTH));
        }
        return new Dimension(icon.getIconWidth(),icon.getIconHeight());
     }
    /**
     * Actualiza el sprite del enemigo y refresca la etiqueta para reflejar el cambio.
     */
     public void updateSprite(){
        icon=enemy.getSprite();
        setUI(new EnemyLabelUI(icon));
        setPreferredSize(getMinimusSize());
        setSize(getMinimusSize());
        setIcon(icon);
        revalidate();
        repaint();
     }
    /**
     * Establece un nuevo enemigo y actualiza el sprite mostrado en la etiqueta.
     */
     public void setEnemy(Enemy enemy){
        this.enemy = enemy;
        updateSprite();
     }
}
