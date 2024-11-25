package rpg.gui.windows;

import javax.swing.*;
import java.awt.*;

public class NewFileWindow extends JFrame {
    private JTextField textField;
    private JButton button1;
    private JButton button2;
    private JPanel mainPlanel;
    private int slot;

    public NewFileWindow(int slot){
        this.slot=slot;
        this.setContentPane(mainPlanel);
        this.setSize(new Dimension(800, 250));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
