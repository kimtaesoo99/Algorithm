import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        int result = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    result++;
                }
            }
        }

        int count = 0;

        while (true) {
            boolean[][] visited = new boolean[n][m];
            Deque<int[]> deque = new ArrayDeque<>();
            List<int[]> delete = new ArrayList<>();
            visited[0][0] = true;
            deque.offer(new int[]{0, 0});

            while (!deque.isEmpty()) {
                int[] now = deque.poll();

                for (int i = 0; i < 4; i++) {
                    int moveY = now[0] + dx[i];
                    int moveX = now[1] + dy[i];

                    if (!(0 <= moveY && moveY < n && 0 <= moveX && moveX < m) || visited[moveY][moveX]) {
                        continue;
                    }

                    if (board[moveY][moveX] == 1) {
                        delete.add(new int[]{moveY, moveX});
                    } else {
                        deque.offer(new int[]{moveY, moveX});
                    }
                    visited[moveY][moveX] = true;
                }
            }

            if (delete.isEmpty()) {
                break;
            }

            result = delete.size();

            for (int[] d : delete) {
                board[d[0]][d[1]] = 0;
            }

            count++;
        }

        System.out.println(count);
        System.out.println(result);
    }
}