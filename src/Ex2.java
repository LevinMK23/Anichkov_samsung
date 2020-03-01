import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.TreeSet;

public class Ex2 {

    static int [] cash = new int[50];

    static int fib(int n) {
        System.out.print(n + " ");
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (cash[n] > 0) {
            return cash[n];
        }
        cash[n] = fib(n-1) + fib(n-2);
        return cash[n];
    }

    static void F(int n){
        if (n > 0){
            F(n - 1);
            System.out.print(n);
            F(n - 2);
        }
    }
    public static void main(String[] args) {
        System.out.println(fib(10));
        System.currentTimeMillis();
    }
}
