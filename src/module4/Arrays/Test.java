package module4.Arrays;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        LinkList<String> arr = new LinkList<>();
        for (int i = 0; i < 10; i++) {
            arr.addBack(i+1 + "");
        }
        System.out.println(arr);
    }
}
