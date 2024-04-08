import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final char[][] map = new char[5][5];
    private static final boolean[][] visited = new boolean[5][5];
    private static final int[] dy = {1, 0, -1, 0};
    private static final int[] dx = {0, -1, 0, 1};

    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        dfs(0, 0);
        System.out.println(result);
    }

    private static void dfs(int nowDepth, int start) {
        if (nowDepth == 7) {
            if (checkLinked()) {
                result++;
            }
        } else {
            for (int i = start; i < 25; i++) {
                visited[i / 5][i % 5] = true;
                dfs(nowDepth + 1, i + 1);
                visited[i / 5][i % 5] = false;
            }
        }
    }

    private static boolean checkLinked() {
        boolean[][] check = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            check[i] = visited[i].clone();
        }

        int startY = 0;
        int startX = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (check[i][j]) {
                    startY = i;
                    startX = j;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startY, startX});

        int count = 0;
        int countS = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int moveY = now[0] + dy[i];
                int moveX = now[1] + dx[i];

                if (0 <= moveY && moveY < 5 && 0 <= moveX && moveX < 5 && check[moveY][moveX]) {
                    q.offer(new int[]{moveY, moveX});
                    if (map[moveY][moveX] == 'S') {
                        countS++;
                    }
                    count++;
                    check[moveY][moveX] = false;
                }
            }
        }

        return count == 7 && countS >= 4;
    }
}