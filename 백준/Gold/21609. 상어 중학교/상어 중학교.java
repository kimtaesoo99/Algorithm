import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int result;
    private static int[][] map;
    private static boolean[][] visited;
    private static LinkedList<Block> list = new LinkedList<>();
    private static Queue<int[]> queue = new LinkedList<>();
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        bfs(i, j, true);
                    }
                }
            }
            if (list.isEmpty()) {
                break;
            }

            Collections.sort(list);
            visited = new boolean[N][N];
            bfs(list.get(0).y, list.get(0).x, false);
            removeBlock();

            gravity();
            map = rotate();
            gravity();
            list.clear();
        }
        System.out.println(result);
    }

    private static int[][] rotate() {
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[N - j - 1][i] = map[i][j];
            }
        }

        return temp;
    }

    private static void gravity() {
        for (int j = 0; j < N; j++) {
            for (int i = N - 1; i >= 0; i--) {
                for (int k = i; k < N - 1; k++) {
                    if (map[k][j] == -1) {
                        continue;
                    }

                    if (map[k][j] != -2 && map[k + 1][j] == -2) {
                        int temp = map[k][j];
                        map[k][j] = -2;
                        map[k + 1][j] = temp;
                    }
                }
            }
        }
    }

    private static void removeBlock() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    count++;
                    map[i][j] = -2;
                }
            }
        }

        result += (int) Math.pow(count, 2);
    }

    private static void bfs(int x, int y, boolean flag) {
        int blockPoint = map[x][y];
        visited[x][y] = true;
        queue.offer(new int[]{x, y});

        int totalPoint = 1;
        int rainbowPoint = 0;

        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (0 > nx || nx >= N || 0 > ny || ny >= N || visited[nx][ny]) {
                    continue;
                }
                if (map[nx][ny] == blockPoint || map[nx][ny] == 0) {
                    if (map[nx][ny] == 0) {
                        rainbowPoint += 1;
                    }
                    totalPoint += 1;
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        if (totalPoint >= 2) {
            list.add(new Block(totalPoint, rainbowPoint, x, y));
        }

        if (flag) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) {
                        visited[i][j] = false;
                    }
                }
            }
        }
    }
}


class Block implements Comparable<Block> {

    int totalPoint;
    int rainbowPoint;
    int y;
    int x;

    public Block(int totalPoint, int rainbowPoint, int y, int x) {
        this.totalPoint = totalPoint;
        this.rainbowPoint = rainbowPoint;
        this.y = y;
        this.x = x;
    }

    public int compareTo(Block o) {
        if (this.totalPoint == o.totalPoint) {
            if (this.rainbowPoint == o.rainbowPoint) {
                if (this.y == o.y) {
                    return o.x - this.x;
                }
                return o.y - this.y;
            }
            return o.rainbowPoint - this.rainbowPoint;
        }
        return o.totalPoint - this.totalPoint;
    }
}