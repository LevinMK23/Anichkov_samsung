package module2.chess;

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class ChessItem extends JButton {

    private ImageIcon img;
    private int x, y;

    public ChessItem(ImageIcon img) {
        this.img = img;
        setIcon(img);
    }
//    public ChessItem() {
//        this.addActionListener(a->{
//
//        });
//    }

    public abstract void move(ChessItem [][] field, int x, int y);


}
