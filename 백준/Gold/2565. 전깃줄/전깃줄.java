import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Line[] lines = new Line[n];

        for (int i = 0; i < n; i++) {
            lines[i] = new Line(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(lines);

        int[] dp = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (lines[i].B > lines[j].B) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        System.out.println(n - max);
    }
}

class Line implements Comparable<Line> {
    int A;
    int B;

    @Override
    public int compareTo(Line line) {
        return this.A - line.A;
    }

    public Line(int a, int b) {
        A = a;
        B = b;
    }
}