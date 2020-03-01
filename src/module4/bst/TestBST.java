package module4.bst;

import java.util.Random;

public class TestBST {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Random rnd = new Random();
        for (int i = 0; i < 30; i++) {
            bst.add(rnd.nextInt(1000));
        }
        bst.print();
    }
}
