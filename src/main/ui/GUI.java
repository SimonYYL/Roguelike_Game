package ui;

import model.Monster;
import model.Team;

import persistence.JsonReader;
import persistence.JsonWriter;
import ui.screen.MainFrame;
import ui.screen.MenuScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

// Initialize the GUI interface
public class GUI extends JFrame implements ActionListener {

    private static final Font titleFont = new Font("Papyrus", Font.PLAIN, 120);
    private static final Font normalFont = new Font("Papyrus", Font.PLAIN, 60);
    private static final String JSON_STORE = "./data/team.json";
    private Monster boss;
    private Team team;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JButton startButton;
    private JPanel startButtonPanel;
    private JPanel titleNamePanel;
    private final MainFrame mainFrame;
    private JLabel titleNameLabel = new JLabel("Dungeon");


    // EFFECTS: constructs new mainFrame with new Team and new Monster
    public GUI(MainFrame mainFrame) throws FileNotFoundException {
        this.mainFrame = mainFrame;
        this.team = new Team("Simon's team");
        this.boss = new Monster("T-2000", 250, 50, false);
        initializeGraphics();
    }

    //  MODIFIES: this
    //  EFFECTS: initialize the title Panel with button
    public void initializeGraphics() {

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(600, 100, 600, 200);
        titleNamePanel.setBackground(Color.black);

        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);


        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(800, 600, 250, 220);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("Start");
        startButton.setForeground(Color.white);
        startButton.setBackground(Color.black);
        startButton.setFont(normalFont);
        startButton.addActionListener(this);


        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        mainFrame.add(titleNamePanel);
        mainFrame.add(startButtonPanel);
    }

    // EFFECTS: invisible the start panel and title panel then new a new mainframe
    public void actionPerformed(ActionEvent e) {
        startButtonPanel.setVisible(false);
        titleNamePanel.setVisible(false);
        new MenuScreen(mainFrame,team,jsonWriter,jsonReader);
    }
}
