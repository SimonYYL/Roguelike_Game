package ui.screen;

import model.Team;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The screen for battle take place
public class DoBattleScreen extends JFrame implements ActionListener {
    private static final Font titleFont = new Font("Papyrus", Font.PLAIN, 120);
    private static final Font normalFont = new Font("Papyrus", Font.PLAIN, 20);
    private static final String JSON_STORE = "./data/team.json";
    private Team team;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JPanel doBattlePanel;
    private JTextArea doBattleText;
    private final MainFrame mainFrame;

    // MODIFIES: this
    // EFFECTS: constructs new battle screen with new panel
    public DoBattleScreen(MainFrame mainFrame, Team team) {
        this.mainFrame = mainFrame;
        this.team = team;

        doBattlePanel = new JPanel();
        doBattlePanel.setBounds(600, 400, 700, 400);
        doBattlePanel.setBackground(Color.black);

        doBattleText = new JTextArea("Your team is here: " + "\n" + team.toString() + "\n"
                + "Are you sure want to battle T1000?");
        doBattleText.setBackground(Color.black);
        doBattleText.setForeground(Color.white);
        doBattleText.setFont(normalFont);
        doBattleText.setLineWrap(false);
        doBattleText.setEditable(false);
        doBattlePanel.add(doBattleText);

        Button yes = new  Button("Yes");
        yes.setActionCommand("yes");
        yes.addActionListener(this);
        doBattlePanel.add(yes);
        Button back = new  Button("Maybe next time.");
        back.addActionListener(this);
        back.setActionCommand("back");
        doBattlePanel.add(back);

        mainFrame.add(doBattlePanel);
    }

    // EFFECTS: invisible the panel then if player click “yes” button, then start a picture screen
    //          if player click "back" button, then go back to Menu screen
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("yes")) {
            new PictureScreen(mainFrame, team);
        }
        if (action.equals("back")) {
            new MenuScreen(mainFrame, team,jsonWriter,jsonReader);
        }
        doBattlePanel.setVisible(false);
    }

}
