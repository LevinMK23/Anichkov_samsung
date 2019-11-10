package gui;

import javax.swing.*;
import java.awt.*;

public class Application {
    public static void main(String[] args) {
        JFrame win = new JFrame("My app");
        win.setSize(500, 500);
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GridLayout l2 = new GridLayout(3,3);
        JPanel panel = new JPanel(l2);
        JButton [][] buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton();
                JButton b = buttons[i][j];
                buttons[i][j].addActionListener((action)->{
                    b.setText("X");
                    b.setEnabled(false);

                });
                panel.add(buttons[i][j]);
            }
        }
        win.add(panel);
        win.setVisible(true);
    }
}
