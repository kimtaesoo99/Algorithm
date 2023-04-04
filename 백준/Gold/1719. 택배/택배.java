import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static int max = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);

        int[][] distance = new int[n + 1][n + 1];
        int[][] path = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(distance[i], max);
        }

        for (int i = 0; i < m; i++) {
            String[] num = br.readLine().split(" ");
            int from = Integer.parseInt(num[0]);
            int to = Integer.parseInt(num[1]);
            int value = Integer.parseInt(num[2]);

            distance[from][to] = value;
            distance[to][from] = value;

            path[from][to] = from;
            path[to][from] = to;
        }

        for (int k = 1; k <= n; k++) { //경로
            for (int i = 1; i <= n; i++) { //출발
                for (int j = 1; j <= n; j++) { //도착
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        path[i][j] = path[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    sb.append("- ");
                    continue;
                }
                sb.append(path[j][i]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}