import java.util.LinkedList;
import java.util.Queue;

class Solution {
    char[][] map;

    public int solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        int[][] dis;
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        int startToMid = 0;
        int midToEnd = 0;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (map[i][j] == 'S') {
                    dis = new int[maps.length][maps[0].length()];
                    startToMid = bfs(i, j, 'L', dis);
                }
                if (map[i][j] == 'L') {
                    dis = new int[maps.length][maps[0].length()];
                    midToEnd = bfs(i, j, 'E', dis);
                }
            }
        }

        if (startToMid == -1 || midToEnd == -1) {
            return -1;
        }
        return startToMid + midToEnd;
    }

    private int bfs(int y, int x, char end, int[][] dis) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});

        dis[y][x] = 1;
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, -1, 0, 1};
        while (!q.isEmpty()) {
            int[] move = q.poll();
            if (map[move[0]][move[1]] == end) {
                return dis[move[0]][move[1]] - 1;
            }

            for (int i = 0; i < 4; i++) {
                int moveY = dy[i] + move[0];
                int moveX = dx[i] + move[1];

                if (validation(moveY, moveX)) {
                    if (map[moveY][moveX] == 'X' || dis[moveY][moveX] != 0) {
                        continue;
                    }
                    dis[moveY][moveX] = dis[move[0]][move[1]] + 1;
                    q.offer(new int[]{moveY, moveX});
                }
            }
        }
        return -1;
    }

    private boolean validation(int moveY, int moveX) {
        return (0 <= moveY && moveY < map.length && 0 <= moveX && moveX < map[0].length);
    }
}