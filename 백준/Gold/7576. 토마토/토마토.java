import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] result;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        result = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) result[i][j] = -1;
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
                if (0 <= moveY && moveY < M && 0 <= moveX && moveX < N) {
                    if (map[moveY][moveX] == 0 && result[moveY][moveX] == 0) {
                        result[moveY][moveX] = result[move[0]][move[1]] + 1;
                        q.offer(new int[]{moveY, moveX});
                    }
                }
            }
        }
        int max = 0;
        boolean pass = false;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (result[i][j] == 0){
                    pass = true;
                    break;
                }
                max = Math.max(max, result[i][j]);
            }
        }
        
        if (pass)
            System.out.println(-1);
        else {
            System.out.println(max-1);
        }

    }
}
