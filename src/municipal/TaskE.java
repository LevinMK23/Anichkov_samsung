package municipal;

import java.util.Scanner;

public class TaskE {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long x = in.nextLong(), k = in.nextLong();
        if (Long.bitCount(x) < k) {
            long ans = 0, base = 1;
            char [] d = Long.toBinaryString(x).toCharArray();
            for (int i = d.length-1; i >= 0; i--) {
                if (d[i] == '0') {
                    ans += base;
                    k--;
                }
                else {
                    k--;
                }
                base *= 2;
            }
            while(k-- > 0) {
                ans += base;
                base *= 2;
            }
            System.out.println(ans);
        } else {
            char [] d = Long.toBinaryString(x).toCharArray();
            int cnt = 0, pos = 0;
            for (int i = d.length-1; i >= 0; i--) {
                if (d[i] == '1') cnt++;
                if (cnt == k - 1){
                    pos = d.length - i;
                    break;
                }
            }
            long val = 0, base = 1;
            for (int i = pos; i >= 0; i--) {
                val += (d[i]-'0' == 0 ? 1 : 0) * base;
                base *= 2;
            }
            val++;
            val <<= pos;
            System.out.println(val);
        }
    }
}
