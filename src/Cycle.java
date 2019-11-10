import java.io.IOException;
import java.util.Scanner;

public class Cycle {
    public static void main(String[] args) throws IOException {
        int cnt = 0, l = 1, r = 100000;
        Scanner in = new Scanner(System.in);
        while(true){
            int predict = (l + r) / 2;
            System.out.println("Вы загадали " + predict + "?");
            cnt++;
            int command = in.next().charAt(0);
            if(command == '='){
                System.out.println("Я угадал за " + cnt + " действий!");
                break;
            }
            if (command == '>'){
                l = predict;
            }
            if(command == '<'){
                r = predict;
            }

        }
    }
}
