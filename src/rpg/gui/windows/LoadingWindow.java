package rpg.gui.windows;

import rpg.gui.UIConstants;
import rpg.gui.buttons.LoadFileButton;
import rpg.gui.buttons.NewFileButton;
import rpg.gui.Labels.NameLabel;
import rpg.gui.panels.FilesPanel;

import javax.swing.*;
import java.awt.*;

public class LoadingWindow extends JFrame{

    private JPanel mainPanel;
    private JButton newFile1;
    private JButton newFile2;
    private JButton newFile3;
    private JButton newFile4;
    private JButton newFile5;
    private JLabel titleLabel;
    private JButton loadFile1;
    private JButton loadFile2;
    private JButton loadFile3;
    private JButton loadFile4;
    private JButton loadFile5;
    private JLabel file1Name;
    private JLabel file2Name;
    private JLabel file3Name;
    private JLabel file4Name;
    private JLabel file5Name;

    public LoadingWindow(){
        this.setContentPane(mainPanel);
        this.setSize(UIConstants.STAR_WINDOW_DIMENSION);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void createUIComponents() {
        mainPanel = new FilesPanel();
        titleLabel = new JLabel("Java RPG");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        file1Name = new NameLabel("");
        newFile1 = new NewFileButton(1, this);
        loadFile1 = new LoadFileButton(1, this);
        file2Name = new NameLabel("");
        newFile2 = new NewFileButton(2, this);
        loadFile2 = new LoadFileButton(2, this);
        file3Name = new NameLabel("");
        newFile3 = new NewFileButton(3, this);
        loadFile3 = new LoadFileButton(3, this);
        file4Name = new NameLabel("");
        newFile4 = new NewFileButton(4, this);
        loadFile4 = new LoadFileButton(4, this);
        file5Name = new NameLabel("");
        newFile5 = new NewFileButton(5, this);
        loadFile5 = new LoadFileButton(5, this);
    }
}
