import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    private static List<Character> dir = Arrays.asList('<', '>', 'v', '^');
    private static List<Character> move = Arrays.asList('L', 'R', 'D', 'U');
    private static int[] dy = {0, 0, 1, -1};
    private static int[] dx = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            char[][] map = new char[H][W];

            int startY = 0;
            int startX = 0;

            for (int i = 0; i < H; i++) {
                String line = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = line.charAt(j);
                    if (dir.contains(map[i][j])) {
                        startY = i;
                        startX = j;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            char[] command = br.readLine().toCharArray();

            for (int i = 0; i < command.length; i++) {
                char order = command[i];
                if (move.contains(order)) { // 이동
                    int index = move.indexOf(order);
                    map[startY][startX] = dir.get(index);

                    if (inMap(startY + dy[index], startX + dx[index], H, W)
                            && map[startY + dy[index]][startX + dx[index]] == '.') {
                        map[startY][startX] = '.';
                        startY += dy[index];
                        startX += dx[index];
                        map[startY][startX] = dir.get(index);
                    }
                } else {
                    int index = dir.indexOf(map[startY][startX]);
                    int moveY = startY + dy[index];
                    int moveX = startX + dx[index];
                    while (true) {
                        if (!inMap(moveY, moveX, H, W) || map[moveY][moveX] == '#') {
                            break;
                        }

                        if (map[moveY][moveX] == '*') {
                            map[moveY][moveX] = '.';
                            break;
                        }
                        moveY += dy[index];
                        moveX += dx[index];
                    }
                }
            }
            sb.append("#").append(test).append(" ");

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean inMap(int y, int x, int H, int W) {
        return 0 <= y && y < H && 0 <= x && x < W;
    }
}