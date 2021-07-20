package ui.screen;

import javax.swing.*;
import java.awt.*;


// The mainFrame which all the panel and content showing on
public class MainFrame extends JFrame {

    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;

    // MODIFIES: this
    // EFFECTS: constructs a empty frame with title and close operation
    public MainFrame() {
        super("Dungeon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.black);
        setLayout(null);
        setVisible(true);
    }
}
