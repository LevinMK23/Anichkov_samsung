import gui.Application;

import java.util.ArrayList;
import java.util.Scanner;

public class Conditions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextInt(), b = in.nextInt(),
                c = in.nextInt();
        if(a == 0 && b == 0 && c == 0){
            System.out.println(-1);
        }else if(a == 0){
            if(b == 0){
                System.out.println(0);
            }
            else {
                System.out.println(1 + "\n" + -c / (double)b);
            }
        }else if(b * b - 4 * a * c < 0){
            System.out.println(0);
        }else if(b * b - 4 * a * c == 0){
            System.out.println(1 + "\n" + -b / (double)(2 * a));
        }else {
            double x1 = (double)(-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            double x2 = (double)(-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
            System.out.println(2 + "\n" + x1 + "\n" + x2);
        }

    }
}
