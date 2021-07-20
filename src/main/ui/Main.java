package ui;

import ui.screen.MainFrame;

import javax.swing.*;
import java.io.FileNotFoundException;

// The Launcher of the game application
public class Main {

    private static MainFrame mainFrame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainFrame = new MainFrame();
                try {
                    new GUI(mainFrame);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}