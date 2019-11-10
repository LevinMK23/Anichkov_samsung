package module2.chess;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Game extends JFrame {

    ChessItem [][] field;
    ImageIcon b, w, bishop, knight;
    JPanel panel;

    public Game() throws HeadlessException {
        panel = new JPanel(new GridLayout(8,8));
        b = new ImageIcon("C:\\Users\\Михаил Левин\\IdeaProjects\\Anichkov_samsung\\src\\module2\\chess\\black.png");
        w = new ImageIcon("C:\\Users\\Михаил Левин\\IdeaProjects\\Anichkov_samsung\\src\\module2\\chess\\white.png");
        field = new ChessItem[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((i + j) % 2 == 0) {
                    field[i][j] = new SimpleField(b);
                }
                else{
                    field[i][j] = new SimpleField(w);
                }
                panel.add(field[i][j]);
            }
        }
        panel.setVisible(true);
        setSize(640, 640);
        add(panel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

    }

    public static void main(String[] args) {
        new Game();
    }

}
