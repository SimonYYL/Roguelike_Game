package ui.screen;

import model.Team;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The screen for view Team
public class ViewTeamScreen extends JFrame implements ActionListener {
    private static final Font titleFont = new Font("Papyrus", Font.PLAIN, 120);
    private static final Font normalFont = new Font("Papyrus", Font.PLAIN, 20);
    private static final String JSON_STORE = "./data/team.json";
    private Team team;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JPanel viewTeamPanel;
    private JTextArea viewText;
    private final MainFrame mainFrame;

    // MODIFIES: this
    // EFFECTS: constructs new view screen with new panel
    public ViewTeamScreen(MainFrame mainFrame, Team team) {
        this.team = team;
        this.mainFrame = mainFrame;

        viewTeamPanel = new JPanel();
        viewTeamPanel.setBounds(600, 400, 700, 400);
        viewTeamPanel.setBackground(Color.black);

        viewText = new JTextArea(team.toString());
        viewText.setBackground(Color.black);
        viewText.setForeground(Color.white);
        viewText.setFont(normalFont);
        viewText.setLineWrap(false);
        viewText.setEditable(false);
        viewTeamPanel.add(viewText);

        Button back = new  Button("Back");
        back.addActionListener(this);
        viewTeamPanel.add(back);

        mainFrame.add(viewTeamPanel);
    }

    // EFFECTS: invisible the panel then new a new menuScreen
    @Override
    public void actionPerformed(ActionEvent e) {
        viewTeamPanel.setVisible(false);
        new MenuScreen(mainFrame,team,jsonWriter,jsonReader);
    }
}
