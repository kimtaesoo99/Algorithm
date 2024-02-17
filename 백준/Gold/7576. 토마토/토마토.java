import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, 1, -1};
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[M][N];
        int[][] result = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    result[i][j] = -1;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    result[i][j] = 1;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] move = q.poll();

            for (int i = 0; i < 4; i++) {
                int moveY = move[0] + dy[i];
                int moveX = move[1] + dx[i];
                if (inMap(moveY, moveX) && (map[moveY][moveX] == 0 && result[moveY][moveX] == 0)) {
                    result[moveY][moveX] = result[move[0]][move[1]] + 1;
                    q.offer(new int[]{moveY, moveX});
                }
            }
        }

        int max = 0;
        boolean pass = false;

        loop : for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (result[i][j] == 0) {
                    pass = true;
                    break loop;
                }
                max = Math.max(max, result[i][j]);
            }
        }

        if (pass) {
            System.out.println(-1);
        } else {
            System.out.println(max - 1);
        }
    }

    private static boolean inMap(int moveY, int moveX) {
        return 0 <= moveY && moveY < M && 0 <= moveX && moveX < N;
    }
}