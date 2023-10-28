import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private boolean[][] visited;
    private int[] dirY = {1, 0, -1, 0};
    private int[] dirX = {0, -1, 0, 1};
    private int numberOfArea = 0;
    private int maxSizeOfOneArea = 0;

    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] != 0) {
                    numberOfArea++;
                    bfs(i, j, picture);
                }
            }
        }

        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    private void bfs(int y, int x, int[][] picture) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;
        int count = 1;
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int nowY = pos[0];
            int nowX = pos[1];

            for (int i = 0; i < 4; i++) {
                int moveY = nowY + dirY[i];
                int moveX = nowX + dirX[i];

                if (0 <= moveY && moveY < picture.length && 0 <= moveX && moveX < picture[0].length) {
                    if (!visited[moveY][moveX] && picture[moveY][moveX] == picture[nowY][nowX]) {
                        visited[moveY][moveX] = true;
                        q.offer(new int[]{moveY, moveX});
                        count++;
                    }
                }
            }
        }
        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
    }
}
