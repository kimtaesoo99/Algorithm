import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    static HashMap<Long, Long> f;
    static long start, end, ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        f = new HashMap<>();

        long sum = 0;
        for (long i = 0; i < 10; i++) {
            sum += i;
            f.put(i, sum);
        }

        for (int tc = 1; tc <= T; tc++) {
            start = sc.nextLong();
            end = sc.nextLong();

            if (start > 0)
                ans = F(end) - F(start - 1);
            else
                ans = F(end) - F(start);

            System.out.println("#" + tc + " " + ans);
        }
    }

    static long F(long i) {
        if (f.containsKey(i)) return f.get(i);
        if (i < 10) return f.get(i);

        long v = V(i);
        long F = F(i - 1 - i % v);
        long G = (i / v) * (i % v + 1) + F(i % v);
        long num = F + G;

        f.put(i, num);

        return num;
    }

    static long V(long i) {
        long v = 1;
        while (i >= 10) {
            v = v * 10;
            i = i / 10;
        }
        return v;
    }
}