import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    private static int[][] map;
    private static int[] dy = {1, 0, -1, 0};
    private static int[] dx = {0, -1, 0, 1};
    private static int n;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());
        for (int t = 1; t <= test; t++) {
            String[] info = br.readLine().split(" ");
            n = Integer.parseInt(info[0]);
            int w = Integer.parseInt(info[1]);
            int h = Integer.parseInt(info[2]);

            result = w * h;
            map = new int[h][w];

            for (int i = 0; i < h; i++) {
                String[] line = br.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }

            permutation(0, new int[n]);
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void permutation(int index, int[] arr) {
        if (n == index) {
            breakMap(arr);
            return;
        }

        for (int i = 0; i < map[0].length; i++) {
            arr[index] = i;
            permutation(index + 1, arr);
        }
    }

    private static void breakMap(int[] arr) {
        int[][] newMap = new int[map.length][map[0].length];

        // 맵 복사
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                newMap[i][j] = map[i][j];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int nowTarget = arr[i];

            // 타겟 찾기
            int[] target = getTarget(newMap, nowTarget);
            if (target[0] == -1 && target[1] == -1) {
                continue;
            }

            // 전파하면서 뿌수기
            breakMapWithTarget(target, newMap);

            // 맵당기기
            pullMap(newMap);
        }

        int count = 0;
        // 갯수 세기
        for (int i = 0; i < newMap.length; i++) {
            for (int j = 0; j < newMap[0].length; j++) {
                if (newMap[i][j] != 0) {
                    count++;
                }
            }
        }
     
        result = Math.min(result, count);
    }

    private static int[] getTarget(int[][] newMap, int x) {
        for (int i = 0; i < newMap.length; i++) {
            if (newMap[i][x] != 0) {
                return new int[]{i, x, newMap[i][x]};
            }
        }
        return new int[]{-1, -1};
    }

    private static void breakMapWithTarget(int[] target, int[][] newMap) {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(target);

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            newMap[y][x] = 0;
//            System.out.println(y + " " + x + " " + poll[2]);

            for (int j = 0; j < 4; j++) {
                int moveY = y;
                int moveX = x;
                for (int i = 0; i < poll[2] - 1; i++) {
                    moveY += dy[j];
                    moveX += dx[j];

                    if (!inMap(moveY, moveX)) {
                        continue;
                    }

                    if (newMap[moveY][moveX] != 0) {
                        q.offer(new int[]{moveY, moveX, newMap[moveY][moveX]});
                        newMap[moveY][moveX] = 0;
                    }
                }
            }
        }
    }

    private static boolean inMap(int y, int x) {
        return 0 <= y && y < map.length && 0 <= x && x < map[0].length;
    }

    private static void pullMap(int[][] newMap) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < newMap[0].length; i++) {

            for (int j = 0; j < newMap.length; j++) {
                if (newMap[j][i] != 0) {
                    deque.offer(newMap[j][i]);
                    newMap[j][i] = 0;
                }
            }

            for (int j = newMap.length - 1; j >= 0; j--) {
                if (deque.isEmpty()) {
                    break;
                }
                newMap[j][i] = deque.pollLast();
            }
        }
    }
}