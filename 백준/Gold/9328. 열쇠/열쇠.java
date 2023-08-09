import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int result = 0;
    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int test = 0; test < t; test++) {
            result = 0;
            int h = sc.nextInt();
            int w = sc.nextInt();
            String[][] map = new String[h + 2][w + 2];

            for (int i = 1; i < h + 1; i++) {
                String info = sc.next();
                for (int j = 1; j < w + 1; j++) {
                    map[i][j] = info.split("")[j - 1];
                }
            }

            for (int i = 0; i < w + 2; i++) {
                map[0][i] = ".";
                map[h + 1][i] = ".";
            }

            for (int i = 0; i < h + 2; i++) {
                map[i][0] = ".";
                map[i][w + 1] = ".";
            }

            String keys = sc.next();

            List<String> key = new ArrayList<>();
            if (!keys.equals("0")) {
                for (int i = 0; i < keys.length(); i++) {
                    key.add(String.valueOf(keys.charAt(i)));
                }
            }
            bfs(map, key);
            System.out.println(result);
        }
    }

    private static void bfs(String[][] map, List<String> key) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[map.length][map[0].length];

        while (!q.isEmpty()) {
            int[] location = q.poll();

            for (int i = 0; i < 4; i++) {
                int moveY = location[0] + move[i][0];
                int moveX = location[1] + move[i][1];

                if (0 <= moveY && moveY < map.length && 0 <= moveX && moveX < map[0].length) {
                    if (!map[moveY][moveX].equals("*") && !visited[moveY][moveX]) {
                        if (map[moveY][moveX].equals("$")) {
                            result++;
                        } else if (Character.isLowerCase(map[moveY][moveX].charAt(0))) { //열쇠
                            key.add(map[moveY][moveX]);
                            visited = new boolean[map.length][map[0].length];
                        } else if (Character.isUpperCase(map[moveY][moveX].charAt(0))) {  // 문
                            String door = map[moveY][moveX].toLowerCase();
                            if (!key.contains(door)) {
                                continue;
                            }
                        }
                        map[moveY][moveX] = ".";
                        q.offer(new int[]{moveY, moveX});
                        visited[moveY][moveX] = true;
                    }
                }
            }
        }
    }
}
