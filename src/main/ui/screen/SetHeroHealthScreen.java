package ui.screen;

import model.Hero;
import model.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The screen for player to set hero health
public class SetHeroHealthScreen extends JFrame implements ActionListener {
    private final MainFrame mainFrame;
    private Team team;
    private Hero hero;
    private JTextField health;
    private static final Font normalFont = new Font("Papyrus", Font.PLAIN, 30);
    private JPanel setHealthPanel;
    private JButton save;

    // MODIFIES: this
    // EFFECTS: constructs new screen with new panel with label, button and field in it
    public SetHeroHealthScreen(MainFrame mainFrame,Hero hero,Team team) {
        this.team = team;
        this.hero = hero;
        this.mainFrame = mainFrame;

        setHealthPanel = new JPanel();
        setHealthPanel.setBounds(666,300,600,500);
        setHealthPanel.setBackground(Color.black);
        mainFrame.add(setHealthPanel);
        setHealthPanel.setVisible(true);
        mainFrame.setLayout(null);

        JLabel l1 = new JLabel("Set your hero health value: in range [1 - 200]");
        l1.setForeground(Color.white);
        l1.setFont(normalFont);
        l1.setBackground(Color.cyan);
        setHealthPanel.add(l1);

        this.health = new JTextField(20);
        health.setBackground(Color.black);
        health.setForeground(Color.white);

        this.save = new JButton("Save");
        save.setActionCommand("save");
        save.addActionListener(this);

        setHealthPanel.add(health);
        setHealthPanel.add(save);
    }

    // EFFECTS: invisible the panel then new a new setHeroPowerScreen
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("save")) {
            String text = health.getText();
            int health = Integer.parseInt(text);
            if (health >= 1 &&  health <= 200) {
                hero.setHealth(health);
                setHealthPanel.setVisible(false);
                new SetHeroPowerScreen(mainFrame,hero,team);
            }
        }
    }
}
