import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hello {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong(), b = in.nextLong();
        System.out.println(a+b);
        System.out.printf("(%d+%d+%d)*%d=%d", 1, 2, 3, 5, (1 + 2 + 3)*5);
    }
}
