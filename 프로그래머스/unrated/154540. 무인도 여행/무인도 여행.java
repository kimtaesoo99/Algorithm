import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    char[][] map;
    boolean[][] visited;
    List<Integer> list;
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};

    public int[] solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        list = new ArrayList<>();
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (map[i][j] != 'X' && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        int[] result = list.stream()
                .mapToInt(Integer::intValue)
                .sorted()
                .toArray();
        return result.length == 0 ? new int[]{-1} : result;
    }

    private void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;
        int sum = map[y][x] - '0';
        while (!q.isEmpty()) {
            int[] move = q.poll();

            for (int i = 0; i < 4; i++) {
                int moveY = dy[i] + move[0];
                int moveX = dx[i] + move[1];

                if (validation(moveY, moveX)) {
                    if (map[moveY][moveX] != 'X' && !visited[moveY][moveX]) {
                        visited[moveY][moveX] = true;
                        sum += (map[moveY][moveX] - '0');
                        q.offer(new int[]{moveY, moveX});
                    }
                }
            }
        }
        list.add(sum);
    }

    private boolean validation(int y, int x) {
        return (0 <= y && y < map.length && 0 <= x && x < map[0].length);
    }
}