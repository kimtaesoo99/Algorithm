import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {

    private int[] columns;
    private int[] dy = {1, 0, -1, 0};
    private int[] dx = {0, -1, 0, 1};
    boolean[][] visited;


    public int solution(int[][] land) {
        columns = new int[land[0].length];
        visited = new boolean[land.length][land[0].length];

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (!visited[i][j] && land[i][j] == 1) {
                    bfs(land, i, j);
                }
            }
        }

        return Arrays.stream(columns)
                .max()
                .orElse(0);
    }

    private void bfs(int[][] land, int y, int x) {
        Set<Integer> visitedX = new HashSet<>();

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;

        int count = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            visitedX.add(poll[1]);
            count++;

            for (int i = 0; i < 4; i++) {
                int moveY = poll[0] + dy[i];
                int moveX = poll[1] + dx[i];

                if (0 <= moveY && moveY < land.length && 0 <= moveX && moveX < land[0].length) {
                    if (!visited[moveY][moveX] && land[moveY][moveX] == 1) {
                        visited[moveY][moveX] = true;
                        q.add(new int[]{moveY, moveX});
                    }
                }
            }
        }

        int finalCount = count;
        visitedX.forEach(i -> columns[i] += finalCount);
    }
}