import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] info = br.readLine().split(" ");

        int n = Integer.parseInt(info[0]);
        int total = Integer.parseInt(info[1]);

        int[] dp = new int[total + 1];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int time = Integer.parseInt(line[0]);
            int score = Integer.parseInt(line[1]);

            for (int j = total; j >= time; j--) {
                dp[j] = Math.max(dp[j - time] + score, dp[j]);
            }
        }

        System.out.println(dp[total]);
    }
}