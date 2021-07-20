package ui.screen;

import model.Team;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The screen for showing different type of error
public class IssueScreen extends JFrame implements ActionListener {

    private final MainFrame mainFrame;
    private JPanel textPanel;
    private static final Font normalFont = new Font("Papyrus", Font.PLAIN, 30);
    private JTextArea text;
    private Team team;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // MODIFIES: this
    // EFFECTS: constructs new issue screen with panel
    public IssueScreen(MainFrame mainFrame,Team team,String issue) {
        this.team = team;
        this.mainFrame = mainFrame;
        textPanel = new JPanel();
        textPanel.setBounds(600, 400, 700, 400);
        textPanel.setBackground(Color.black);

        text = new JTextArea(issue);
        text.setBackground(Color.black);
        text.setForeground(Color.white);
        text.setFont(normalFont);
        text.setLineWrap(false);
        text.setEditable(false);
        textPanel.add(text);

        Button back = new  Button("Back");
        back.addActionListener(this);
        textPanel.add(back);

        mainFrame.add(textPanel);

    }

    // EFFECTS: invisible the panel then new a new menuScreen
    @Override
    public void actionPerformed(ActionEvent e) {
        textPanel.setVisible(false);
        new MenuScreen(mainFrame,team,jsonWriter,jsonReader);
    }
}
