import java.util.Arrays;
import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = "+7(911)275-69-75";
        System.out.println
                (s.matches("\\+7\\([0-9]{3}\\)[0-9]{3}-" +
                        "[0-9]{2}-[0-9]{2}"));
        String [] words = s.split("(\\(|\\))");
        words[2] = words[2].replace("-", "");
        System.out.println(Arrays.toString(words));
    }
}
