package ui.screen;


import model.Team;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// The screen show the menu with different button to access each screen
public class MenuScreen extends JFrame implements ActionListener {
    private static final Font titleFont = new Font("Papyrus", Font.PLAIN, 120);
    private static final Font normalFont = new Font("Papyrus", Font.PLAIN, 60);
    private static final String JSON_STORE = "./data/team.json";
    private Team team;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JButton button;
    private JPanel mainMenuPanel;
    private final MainFrame mainFrame;

    // MODIFIES: this
    // EFFECTS: constructs new screen with new panel with text area, button and field in it
    public MenuScreen(MainFrame mainFrame, Team team, JsonWriter jsonWriter, JsonReader jsonReader) {

        this.team = team;
        this.mainFrame = mainFrame;
        this.jsonWriter = jsonWriter;
        this.jsonReader = jsonReader;

        this.jsonWriter = new JsonWriter(JSON_STORE);
        this.jsonReader = new JsonReader(JSON_STORE);

        mainMenuPanel = new JPanel();
        mainMenuPanel.setBounds(600, 400, 700, 400);
        mainMenuPanel.setBackground(Color.white);
        mainFrame.add(mainMenuPanel);
        mainMenuPanel.setLayout(new GridLayout(5, 1));

        mainMenuPanel.add(setButton("Create New Hero", "choice1", Color.black, Color.white));
        mainMenuPanel.add(setButton("View Team", "choice2", Color.black, Color.white));
        mainMenuPanel.add(setButton("Battle", "choice3", Color.black, Color.white));
        mainMenuPanel.add(setButton("Save team to file", "choice4", Color.black, Color.white));
        mainMenuPanel.add(setButton("Load team from file", "choice5",
                Color.black, Color.white));

    }


    // EFFECTS: if player click Create New Hero button get in to crate new hero screen
    //          if player click view team, then get new view team screen
    //          if player click battle, then get new battle screen
    //          if player click save or load, then get in to save or load screen
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("choice1")) {
            doCreate();
        }
        if (action.equals("choice2")) {
            if (action.equals("choice2")) {
                doViewTeam();
            }
        }
        if (action.equals("choice3")) {
            new DoBattleScreen(mainFrame, team);
        }
        if (action.equals("choice4")) {
            saveTeam();
        }
        if (action.equals("choice5")) {
            loadTeam();
            new LoadTeamScreen(mainFrame, team, jsonWriter, jsonReader);
        }
        mainMenuPanel.setVisible(false);
    }

    // EFFECTS : saves the team to the file
    private void saveTeam() {
        if (team.size() == 0) {
            new IssueScreen(mainFrame, team, "There is no team member!");
        } else {
            new SaveScreen(mainFrame, team, jsonWriter, jsonReader);
            try {
                jsonWriter.open();
                jsonWriter.write(team);
                jsonWriter.close();
            } catch (FileNotFoundException e) {
                System.out.println("Unable to write to file: " + JSON_STORE);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: create new hero then add into team auto and a new screen, team size greater than 4 otherwise
    private void doCreate() {
        if (team.size() < 4) {
            new CreateNewHeroScreen(mainFrame, team);
        } else {
            new IssueScreen(mainFrame, team, "Sorry your team is full");
        }
    }

    // MODIFIES: this
    // EFFECTS: view the team with view team screen, if there is no team member, then get in to issue screen
    private void doViewTeam() {
        if (team.size() == 0) {
            new IssueScreen(mainFrame, team, "No hero in team!");
        } else {
            new ViewTeamScreen(mainFrame, team);
        }
    }


    // MODIFIES: this
    // EFFECTS: set the button with correspond commend , color and background
    private JButton setButton(String buttonName, String buttonCommend, Color backgroundColor, Color foregroundColor) {
        this.button = new JButton(buttonName);
        button.setBackground(backgroundColor);
        button.setForeground(foregroundColor);
        button.setFont(normalFont);
        button.setActionCommand(buttonCommend);
        button.addActionListener(this);
        return button;
    }

    // MODIFIES: this
    // EFFECTS: loads team from file
    private void loadTeam() {
        try {
            team = jsonReader.read();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
