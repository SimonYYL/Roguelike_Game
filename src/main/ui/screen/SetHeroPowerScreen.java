package ui.screen;

import model.Hero;
import model.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The screen for player to set hero attack power
public class SetHeroPowerScreen extends JFrame implements ActionListener {
    private final MainFrame mainFrame;
    private Hero hero;
    private Team team;
    private JTextField power;
    private static final Font normalFont = new Font("Papyrus", Font.PLAIN, 30);
    private JPanel setPowerPanel;
    private JButton save;

    // MODIFIES: this
    // EFFECTS: constructs new screen with new panel with label, button and field in it
    public SetHeroPowerScreen(MainFrame mainFrame, Hero hero, Team team) {
        this.team = team;
        this.hero = hero;
        this.mainFrame = mainFrame;

        setPowerPanel = new JPanel();
        setPowerPanel.setBounds(666, 300, 600, 500);
        setPowerPanel.setBackground(Color.black);
        mainFrame.add(setPowerPanel);
        setPowerPanel.setVisible(true);
        mainFrame.setLayout(null);

        JLabel l1 = new JLabel("Set your hero attack power: in range [0-100]");
        l1.setForeground(Color.white);
        l1.setFont(normalFont);
        l1.setBackground(Color.cyan);
        setPowerPanel.add(l1);

        this.power = new JTextField(20);
        power.setBackground(Color.black);
        power.setForeground(Color.white);

        this.save = new JButton("Save");
        save.setActionCommand("save");
        save.addActionListener(this);

        setPowerPanel.add(power);
        setPowerPanel.add(save);
    }

    // EFFECTS: invisible the panel then new a new setHeroOccupationScreen
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("save")) {
            String text = power.getText();
            int power = Integer.parseInt(text);
            if (power >= 0 && power <= 100) {
                hero.setAttackPower(power);
                setPowerPanel.setVisible(false);
                new SetHeroOccupationScreen(mainFrame, hero, team);
            }
        }
    }
}
