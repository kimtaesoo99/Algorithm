import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static final long MOD = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int test = 1; test <= t; test++) {
            String[] info = br.readLine().split(" ");
            int n = Integer.parseInt(info[0]);
            int r = Integer.parseInt(info[1]);

            long a = 1;
            long b = 1;
            long c = 0;

            for (int i = 1; i <= n; i++) {
                a *= i;
                a %= MOD;
            }

            for (int i = 1; i <= r; i++) {
                b *= i;
                b %= MOD;
            }

            for (int i = 1; i <= n - r; i++) {
                b *= i;
                b %= MOD;
            }

            c = division(b, MOD - 2);
            a *= c;
            a %= MOD;
            sb.append("#").append(test).append(" ").append(a).append("\n");
        }
        System.out.println(sb);
    }

    private static long division(long now, long depth) {
        if (depth == 0) {
            return 1;
        }

        if (depth % 2 == 1) {
            return (division(now, depth - 1) % MOD) * now % MOD;
        } else {
            return division(now * now % MOD, depth / 2) % MOD;
        }
    }
}