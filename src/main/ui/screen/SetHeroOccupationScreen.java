package ui.screen;

import model.Hero;
import model.Team;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The screen for player to set hero attack power
public class SetHeroOccupationScreen extends JFrame implements ActionListener {
    private final MainFrame mainFrame;
    private Team team;
    private Hero hero;
    private JTextField occupation;
    private static final Font normalFont = new Font("Papyrus", Font.PLAIN, 30);
    private JPanel setOccupationPanel;
    private JButton save;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // MODIFIES: this
    // EFFECTS: constructs new screen with new panel with label, button and field in it
    public SetHeroOccupationScreen(MainFrame mainFrame,Hero hero,Team team) {
        this.team = team;
        this.hero = hero;
        this.mainFrame = mainFrame;

        setOccupationPanel = new JPanel();
        setOccupationPanel.setBounds(666, 300, 500, 500);
        setOccupationPanel.setBackground(Color.black);
        mainFrame.add(setOccupationPanel);
        setOccupationPanel.setVisible(true);
        mainFrame.setLayout(null);

        JLabel l1 = new JLabel("What's your hero's occupation?");
        l1.setForeground(Color.white);
        l1.setFont(normalFont);
        l1.setBackground(Color.cyan);
        setOccupationPanel.add(l1);

        this.occupation = new JTextField(20);
        occupation.setBackground(Color.black);
        occupation.setForeground(Color.white);

        this.save = new JButton("Save");
        save.setActionCommand("save");
        save.addActionListener(this);

        setOccupationPanel.add(occupation);
        setOccupationPanel.add(save);
    }

    // EFFECTS: invisible the panel then new a new MenuScreen
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("save")) {
            hero.setOccupation(occupation.getText());
            team.addHero(hero);
            setOccupationPanel.setVisible(false);
            new MenuScreen(mainFrame,team,jsonWriter,jsonReader);
        }
    }
}

