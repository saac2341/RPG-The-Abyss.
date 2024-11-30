package rpg.gui.labels;

import rpg.gui.ui.NameLabelUI;

import javax.swing.*;

/**
 * La clase NameLabel extiende JLabel para representar una etiqueta
 * que muestra el nombre de un jugador o entidad en la interfaz de usuario.
 */
public class NameLabel extends JLabel {
    /**
     * Constructor de NameLabel que inicializa la etiqueta con un nombre
     * y establece una interfaz de usuario personalizada.
     */
    public NameLabel(String name) {
        super(name);
        setUI(new NameLabelUI());
    }
    /**
     * Actualiza el texto de la etiqueta con un nuevo nombre y
     * reinicializa la interfaz de usuario.
     */
    public void updateLabel(String name){
        setText(name);
        setUI(new NameLabelUI());
        revalidate();
        repaint();
    }
}
