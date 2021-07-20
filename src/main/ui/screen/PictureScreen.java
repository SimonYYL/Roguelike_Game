package ui.screen;

import model.Battle;
import model.Team;
import persistence.JsonReader;
import persistence.JsonWriter;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

// The screen show the result of the battle with a picture
public class PictureScreen extends JFrame implements ActionListener {
    private static final Font titleFont = new Font("Papyrus", Font.PLAIN, 120);
    private static final Font normalFont = new Font("Papyrus", Font.PLAIN, 40);
    private static final String JSON_STORE = "./data/team.json";

    private Battle battle;
    private Scanner input;
    private Team team;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JPanel battlePicturePanel;
    private JTextArea battleResult;
    private final MainFrame mainFrame;

    // MODIFIES: this
    // EFFECTS: constructs new screen with new panel with text area, button and field in it
    public PictureScreen(MainFrame mainFrame, Team team) {
        this.team = team;
        this.mainFrame = mainFrame;
        battle = new Battle();
        battle.addPlayer(team);


        battlePicturePanel = new JPanel();
        battlePicturePanel.setBounds(300, 100, 1000, 800);
        battlePicturePanel.setBackground(Color.black);

        battleResult = new JTextArea(battle.attack());
        battleResult.setBackground(Color.black);
        battleResult.setForeground(Color.white);
        battleResult.setFont(normalFont);
        battleResult.setLineWrap(false);
        battleResult.setEditable(false);
        battlePicturePanel.add(battleResult);

        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("./data/2.jpg"));
        battlePicturePanel.add(label);

        mainFrame.add(battlePicturePanel);

        Button back = new  Button("back");
        back.addActionListener(this);
        back.setActionCommand("back");
        battlePicturePanel.add(back);

    }

    // EFFECTS: invisible the panel then new a new menuScreen if player click back button
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("back")) {
            new MenuScreen(mainFrame, team,jsonWriter,jsonReader);
        }
        battlePicturePanel.setVisible(false);
    }
}
