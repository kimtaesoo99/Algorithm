import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    private char[][] map;
    private int max;
    private final int[] dy = {1, 0, -1, 0};
    private final int[] dx = {0, -1, 0, 1};
    private final Set<Character> keys = new HashSet<>();

    public int shortestPathAllKeys(String[] grid) {
        map = new char[grid.length][grid[0].length()];
        int startY = 0;
        int startX = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                map[i][j] = grid[i].charAt(j);
                if (map[i][j] != '@' && map[i][j] != '.' && map[i][j] != '#') {
                    keys.add((map[i][j] + "").toLowerCase().charAt(0));
                }
                if (map[i][j] == '@') {
                    startY = i;
                    startX = j;
                }
            }
        }
        max = (int) Math.pow(2, keys.size()) - 1;

        return bfs(startY, startX, keys.size());
    }

    private int bfs(int y, int x, int keysSize) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x, 0});
        int[][][] dis = new int[map.length][map[0].length][(int) Math.pow(2, keysSize)];
        dis[y][x][0] = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[2] == max) {
                return dis[now[0]][now[1]][max] - 1;
            }

            for (int i = 0; i < 4; i++) {
                int moveY = now[0] + dy[i];
                int moveX = now[1] + dx[i];
                int keyStatus = now[2];
                String key = Integer.toBinaryString(keyStatus);
                int count = keysSize - key.length();
                key = "0".repeat(count) + key;

                if (0 <= moveY && moveY < map.length && 0 <= moveX && moveX < map[0].length) {
                    if (map[moveY][moveX] == '#') {
                        continue;
                    }

                    for (int j = 0; j < keysSize; j++) {
                        if (dis[moveY][moveX][keyStatus] == 0) {

                            if (map[moveY][moveX] == 'A' + j) {
                                if (key.charAt(j) == '0') {
                                    break;
                                }
                                dis[moveY][moveX][keyStatus] = dis[now[0]][now[1]][keyStatus] + 1;
                                q.offer(new int[]{moveY, moveX, keyStatus});
                                break;
                            }

                            if (map[moveY][moveX] == 'a' + j) {

                                int nextKeyStatus = keyStatus;
                                if (key.charAt(j) == '0') {
                                    nextKeyStatus = (keyStatus + (int) Math.pow(2, keysSize - j - 1));
                                }

                                dis[moveY][moveX][nextKeyStatus] =
                                        dis[now[0]][now[1]][keyStatus] + 1;
                                q.offer(new int[]{moveY, moveX, nextKeyStatus});
                                break;
                            }
                            if (map[moveY][moveX] == '.' || map[moveY][moveX] == '@') {
                                q.offer(new int[]{moveY, moveX, keyStatus});
                                dis[moveY][moveX][keyStatus] = dis[now[0]][now[1]][keyStatus] + 1;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}