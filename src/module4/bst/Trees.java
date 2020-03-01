package module4.bst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Trees {
    public static void main(String[] args) throws FileNotFoundException {
        TreeMap<String, Integer> map = new TreeMap<>();
        Scanner in = new Scanner(new File("text.txt"));
        while (in.hasNext()) {
            String word = in.next();
            word = word.toLowerCase().replaceAll("[^a-z]", "");
            if (!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
//        for(Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
//        }
        map.entrySet()
                .stream()
                .sorted(Comparator.comparing(o -> -o.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
    }
}
