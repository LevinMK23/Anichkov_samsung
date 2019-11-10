import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "sadg ad gh a dh  sad h ad h a s dg  sd as fas f a sg  asg ";
        String [] words = s1.split("( +)");
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
    }
}
