package module2.chess;

import javax.swing.*;

public class SimpleField extends ChessItem {


    public SimpleField(ImageIcon img) {
        super(img);
        setDisabledIcon(img);
        setEnabled(false);
    }

    @Override
    public void move(ChessItem[][] field, int x, int y) {

    }
}
