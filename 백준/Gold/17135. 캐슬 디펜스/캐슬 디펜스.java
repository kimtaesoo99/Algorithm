import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int D;
    private static int answer = 0;
    private static int[][] map;
    private static int[][] originMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        originMap = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                originMap[i][j] = map[i][j];
            }
        }

        int[] archer = new int[3];
        setArcher(1, 0, archer);
        System.out.println(answer);
    }

    public static void setArcher(int start, int settingCount, int[] archer) {
        if (settingCount == 3) {
            init();
            attack(archer);
            return;
        }
        for (int i = start; i <= M; i++) {
            archer[settingCount] = i;
            setArcher(start + 1, settingCount + 1, archer);
        }
    }

    public static void init() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = originMap[i][j];
            }
        }
    }

    public static int distance(int x1, int x2, int y1, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void attack(int[] archer) {
        int count = 0;
        for (int n = 1; n <= N; n++) {
            boolean[][] visited = new boolean[N + 1][M + 1];
            for (int i = 0; i < 3; i++) {
                int archerX = archer[i];
                int minD = Integer.MAX_VALUE;
                int minX = Integer.MAX_VALUE;
                int minY = Integer.MAX_VALUE;

                for (int j = 1; j <= N; j++) {
                    for (int k = 1; k <= M; k++) {
                        if (map[j][k] == 1) {
                            int distance = distance(k, archerX, j, N + 1);
                            if (distance < minD) {
                                minD = distance;
                                minX = k;
                                minY = j;
                            } else if (distance == minD) {
                                if (k < minX) {
                                    minX = k;
                                    minY = j;
                                }
                            }
                        }
                    }
                }
                if (minD <= D) {
                    visited[minY][minX] = true;
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (visited[i][j]) {
                        map[i][j] = 0;
                        count++;
                    }
                }
            }

            for (int i = N; i >= 1; i--) {
                for (int j = 1; j <= M; j++) {
                    map[i][j] = map[i - 1][j];
                }
            }
        }
        answer = Math.max(count, answer);
    }
}