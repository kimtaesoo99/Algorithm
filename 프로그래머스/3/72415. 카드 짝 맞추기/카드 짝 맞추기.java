import java.util.*;

class Solution {

    private int count = 0;
    private int result = Integer.MAX_VALUE;
    private boolean[] visited = new boolean[7];
    private Point[][] cardIndex = new Point[7][2];
    private int[][] map;
    private int[] dy = {1, -1, 0, 0};
    private int[] dx = {0, 0, 1, -1};

    public int solution(int[][] board, int r, int c) {
        map = board;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                if (!visited[map[i][j]]) {
                    visited[map[i][j]] = true;
                    count++;
                    cardIndex[map[i][j]][0] = new Point(i, j, 0);
                } else {
                    cardIndex[map[i][j]][1] = new Point(i, j, 0);
                }
            }
        }

        dfs(0, 0, r, c);
        return result;
    }

    public void dfs(int index, int sum, int nowX, int nowY) {
        if (index == count) {
            result = Math.min(result, sum);
            return;
        }

        for (int i = 1; i <= 6; i++) {
            if (!visited[i]) {
                continue;
            }
            int firstCount = bfs(nowX, nowY, cardIndex[i][0].x, cardIndex[i][0].y)
                    + bfs(cardIndex[i][0].x, cardIndex[i][0].y, cardIndex[i][1].x, cardIndex[i][1].y) + 2;

            int secondCount = bfs(nowX, nowY, cardIndex[i][1].x, cardIndex[i][1].y)
                    + bfs(cardIndex[i][1].x, cardIndex[i][1].y, cardIndex[i][0].x, cardIndex[i][0].y) + 2;

            visited[i] = false;
            map[cardIndex[i][0].x][cardIndex[i][0].y] = 0;
            map[cardIndex[i][1].x][cardIndex[i][1].y] = 0;

            if (firstCount < secondCount) {
                dfs(index + 1, sum + firstCount, cardIndex[i][1].x, cardIndex[i][1].y);
            } else {
                dfs(index + 1, sum + secondCount, cardIndex[i][0].x, cardIndex[i][0].y);
            }

            map[cardIndex[i][0].x][cardIndex[i][0].y] = i;
            map[cardIndex[i][1].x][cardIndex[i][1].y] = i;
            visited[i] = true;
        }
    }

    public int bfs(int sx, int sy, int tx, int ty) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] check = new boolean[4][4];
        q.add(new Point(sx, sy, 0));
        check[sx][sy] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();
            if (now.x == tx && now.y == ty) {
                return now.t;
            }

            for (int d = 0; d < 4; d++) {
                int moveX = now.x + dx[d];
                int moveY = now.y + dy[d];
                if (moveX < 0 || moveY < 0 || moveX >= 4 || moveY >= 4 || check[moveX][moveY]) {
                    continue;
                }
                check[moveX][moveY] = true;
                q.add(new Point(moveX, moveY, now.t + 1));
            }

            for (int d = 0; d < 4; d++) {
                int moveX = now.x;
                int moveY = now.y;
                while (true) {
                    moveX += dx[d];
                    moveY += dy[d];
                    if (moveX == 4 || moveY == 4 || moveX == -1 || moveY == -1) {
                        moveX -= dx[d];
                        moveY -= dy[d];
                        break;
                    }
                    if (map[moveX][moveY] != 0) {
                        break;
                    }
                }
                if (check[moveX][moveY]) {
                    continue;
                }
                check[moveX][moveY] = true;
                q.add(new Point(moveX, moveY, now.t + 1));
            }
        }
        return -1;
    }
}

class Point {
    int x, y, t;

    public Point(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}
