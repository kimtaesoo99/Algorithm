import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n;
    static int count;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = (str.charAt(j)-'0');
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    list.add(DFS(i, j));
                }
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for (Integer i : list) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    static int DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextY >= 0 && nextX < n && nextY < n) {
                if (!visited[nextX][nextY] && map[nextX][nextY] == 1) {
                    DFS(nextX, nextY);
                    count++;
                }
            }
        }
        return count;
    }
}