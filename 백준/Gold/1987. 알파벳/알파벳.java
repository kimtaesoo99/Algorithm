import java.util.Scanner;

class Main {

    private static char[][] map;
    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, -1, 0, 1};
    private static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String line = sc.next();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        boolean[] visited = new boolean[26];
        visited[map[0][0] - 'A'] = true;

        dfs(0, 0, 1, visited);
        System.out.println(max);
    }

    private static void dfs(int y, int x, int depth, boolean[] visited) {
        max = Math.max(max, depth);

        for (int dir = 0; dir < 4; dir++) {
            int moveY = y + dy[dir];
            int moveX = x + dx[dir];

            if (0 <= moveY && moveY < map.length && 0 <= moveX && moveX < map[0].length) {
                if (!visited[map[moveY][moveX] - 'A']) {
                    visited[map[moveY][moveX] - 'A'] = true;
                    dfs(moveY, moveX, depth + 1, visited);
                    visited[map[moveY][moveX] - 'A'] = false;
                }
            }
        }
    }
}