package ui.screen;

import model.Team;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The screen for player to save the team
public class SaveScreen extends JFrame implements ActionListener {

    private static final Font titleFont = new Font("Papyrus", Font.PLAIN, 120);
    private static final Font normalFont = new Font("Papyrus", Font.PLAIN, 20);
    private static final String JSON_STORE = "./data/team.json";
    private Team team;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JPanel savePanel;
    private JTextArea saveText;
    private final MainFrame mainFrame;

    // MODIFIES: this
    // EFFECTS: constructs new screen with new panel with text area, button and field in it
    public SaveScreen(MainFrame mainFrame, Team team, JsonWriter  jsonWriter,JsonReader jsonReader) {
        this.jsonWriter = jsonWriter;
        this.jsonReader = jsonReader;
        this.team = team;
        this.mainFrame = mainFrame;

        savePanel = new JPanel();
        savePanel.setBounds(600, 400, 700, 400);
        savePanel.setBackground(Color.black);



        saveText = new JTextArea("Your data have been saved!");
        saveText.setBackground(Color.black);
        saveText.setForeground(Color.white);
        saveText.setFont(normalFont);
        saveText.setLineWrap(false);
        saveText.setEditable(false);
        savePanel.add(saveText);

        Button back = new  Button("Back");
        back.addActionListener(this);
        savePanel.add(back);

        mainFrame.add(savePanel);

    }

    // EFFECTS: invisible the panel then new a new menuScreen
    @Override
    public void actionPerformed(ActionEvent e) {
        savePanel.setVisible(false);
        new MenuScreen(mainFrame,team,jsonWriter,jsonReader);
    }

}
