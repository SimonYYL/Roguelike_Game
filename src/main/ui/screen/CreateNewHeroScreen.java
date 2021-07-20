package ui.screen;

import model.Hero;
import model.Team;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The screen for crate new hero
public class CreateNewHeroScreen extends JFrame implements ActionListener {

    private final MainFrame mainFrame;
    private Team team;
    private Hero hero;
    private JTextField name;
    private static final Font normalFont = new Font("Papyrus", Font.PLAIN, 30);
    private JPanel createHeroPanel;
    private JButton save;

    // MODIFIES: this
    // EFFECTS: constructs new crate hero screen with new panel
    public CreateNewHeroScreen(MainFrame mainFrame,Team team) {
        this.team = team;
        this.mainFrame = mainFrame;
        this.hero = new Hero("", 0, 0, 1, "", false);

        createHeroPanel = new JPanel();
        createHeroPanel.setBounds(666,300,500,500);
        createHeroPanel.setBackground(Color.black);
        mainFrame.add(createHeroPanel);
        createHeroPanel.setVisible(true);
        mainFrame.setLayout(null);

        JLabel l1 = new JLabel("Give your hero a name:");
        l1.setForeground(Color.white);
        l1.setFont(normalFont);
        l1.setBackground(Color.cyan);
        createHeroPanel.add(l1);

        this.name = new JTextField(20);
        name.setBackground(Color.black);
        name.setForeground(Color.white);

        this.save = new JButton("Save");
        save.setActionCommand("save");
        save.addActionListener(this);

        createHeroPanel.add(name);
        createHeroPanel.add(save);

    }

    // EFFECTS: invisible the panel then new a new setHeroHealthScreen
    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("save")) {
            hero.setName(name.getText());
            createHeroPanel.setVisible(false);
            new SetHeroHealthScreen(mainFrame,hero,team);
        }
    }
}
