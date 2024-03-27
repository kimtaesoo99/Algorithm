import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Main {

    private static List<Character> alpha = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F');

    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int M = Integer.parseInt(info[1]);

        char[][] map = new char[N][M];

        int startY = 0;
        int startX = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '0') {
                    startY = i;
                    startX = j;
                }
            }
        }

        System.out.println(bfs(map, startY, startX));
    }

    private static int bfs(char[][] map, int startY, int startX) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{startY, startX, 0, 0}); // y, x, dis, key
        boolean[][][] visited = new boolean[map.length][map[0].length][64];
        visited[startY][startX][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (map[now[0]][now[1]] == '1') {
                return now[2];
            }

            for (int i = 0; i < 4; i++) {
                int moveY = now[0] + dy[i];
                int moveX = now[1] + dx[i];

                if (0 <= moveY && moveY < map.length && 0 <= moveX && moveX < map[0].length && !visited[moveY][moveX][now[3]]) {
                    char target = map[moveY][moveX];
                    if (target == '#') {
                        continue;
                    } else if (target == '.' || target == '0' || target == '1') {
                        visited[moveY][moveX][now[3]] = true;
                        q.offer(new int[]{moveY, moveX, now[2] + 1, now[3]});
                    } else if (alpha.contains(target)) { // 문으로 이동
                        int bit = alpha.indexOf(target);
                        // 열쇠가 있는 경우만 이동
                        if ((now[3] & (1 << bit)) == 1 << bit) {
                            visited[moveY][moveX][now[3]] = true;
                            q.offer(new int[]{moveY, moveX, now[2] + 1, now[3]});
                        }
                    } else { //열쇠 줍기
                        int bit = alpha.indexOf(Character.toUpperCase(target));
                        visited[moveY][moveX][(now[3] | (1 << bit))] = true;
                        q.offer(new int[]{moveY, moveX, now[2] + 1, (now[3] | (1 << bit))});
                    }
                }
            }
        }

        return -1;
    }
}