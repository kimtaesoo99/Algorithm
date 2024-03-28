import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());

        for (int t = 1; t <= test; t++) {
            String[] info = br.readLine().split(" ");
            int n = Integer.parseInt(info[0]);

            int[][] map = new int[n][n];

            int count = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(info[count++]);
                    if (map[i][j] == 0) {
                        map[i][j] = 100000;
                    }
                }
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
                    }
                }
            }
            int max = 100000;
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        sum += map[i][j];
                    }
                }
                max = Math.min(max, sum);
            }
            sb.append("#").append(t).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}