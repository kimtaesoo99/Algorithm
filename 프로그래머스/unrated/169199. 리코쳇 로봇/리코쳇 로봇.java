import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static char[][] map;
    static int startY = 0;
    static int startX = 0;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};

    public int solution(String[] board) {
        init(board);
        bfs();
        return bfs();
    }

    private void init(String[] board) {
        map = new char[board.length][board[0].length()];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'R') {
                    startY = i;
                    startX = j;
                }
            }
        }
    }

    private int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startY, startX});
        int[][] distance = new int[map.length][map[0].length];
        distance[startY][startX] = 1;

        while (!q.isEmpty()) {
            int[] move = q.poll();
            for (int i = 0; i < 4; i++) {
                int moveY = move[0] + dy[i];
                int moveX = move[1] + dx[i];

                while (true) {
                    if (0 <= moveY && moveY < map.length && 0 <= moveX && moveX < map[0].length) {
                        if (map[moveY][moveX] != 'D') {
                            moveY += dy[i];
                            moveX += dx[i];
                            continue;
                        }
                    }
                    break;
                }
                moveY -= dy[i];
                moveX -= dx[i];
                if (distance[moveY][moveX] == 0) {
                    if (map[moveY][moveX] == 'G') {
                        return distance[move[0]][move[1]];
                    }
                    q.offer(new int[]{moveY, moveX});
                    distance[moveY][moveX] = distance[move[0]][move[1]] + 1;
                }
            }
        }
        return -1;
    }
}