package ui.screen;

import model.Team;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The screen for load the tea
public class LoadTeamScreen extends JFrame implements ActionListener {

    private static final Font titleFont = new Font("Papyrus", Font.PLAIN, 120);
    private static final Font normalFont = new Font("Papyrus", Font.PLAIN, 20);
    private static final String JSON_STORE = "./data/team.json";
    private Team team;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JPanel loadPanel;
    private JTextArea loadText;
    private final MainFrame mainFrame;

    // MODIFIES: this
    // EFFECTS: constructs new load team screen with new pane
    public LoadTeamScreen(MainFrame mainFrame, Team team, JsonWriter  jsonWriter,JsonReader jsonReader) {
        this.jsonWriter = jsonWriter;
        this.jsonReader = jsonReader;
        this.team = team;
        this.mainFrame = mainFrame;

        loadPanel = new JPanel();
        loadPanel.setBounds(600, 400, 700, 400);
        loadPanel.setBackground(Color.black);



        loadText = new JTextArea("Your data have been load!");
        loadText.setBackground(Color.black);
        loadText.setForeground(Color.white);
        loadText.setFont(normalFont);
        loadText.setLineWrap(false);
        loadText.setEditable(false);
        loadPanel.add(loadText);

        Button back = new  Button("Back");
        back.addActionListener(this);
        loadPanel.add(back);

        mainFrame.add(loadPanel);

    }

    // EFFECTS: invisible the panel then new a new menuScreen
    @Override
    public void actionPerformed(ActionEvent e) {
        loadPanel.setVisible(false);
        new MenuScreen(mainFrame,team,jsonWriter,jsonReader);
    }
}
