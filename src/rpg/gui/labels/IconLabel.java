package rpg.gui.labels;

import rpg.gui.ui.GameLabelUI;

import javax.swing.*;
import java.awt.*;

/**
 * La clase IconLabel extiende JLabel para representar una etiqueta
 * que muestra un ícono proporcionado.
 */
public class IconLabel extends JLabel {
    protected ImageIcon icon;
    /**
     * Constructor de IconLabel que inicializa la etiqueta con un ícono
     * y establece su tamaño preferido y la interfaz de usuario personalizada.
     */
    public IconLabel(ImageIcon icon){
        this.icon=icon;
        setIcon(icon);
        initComponents();
        setUI(new GameLabelUI(getPreferredSize(),icon));
    }
    /**
     * Inicializa los componentes del IconLabel, incluyendo la configuración
     * del tamaño preferido basado en las dimensiones del ícono.
     */
    public void initComponents(){
        setPreferredSize(new Dimension(icon.getIconWidth(),
                icon.getIconHeight()));
    }
}
