import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

    private static int[][] map;
    private static int n;
    private static int gap;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(br.readLine());

            map = new int[n][n];
            gap = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            permutation(new boolean[n], 0, -1);
            sb.append("#").append(test_case).append(" ").append(gap).append("\n");
        }
        System.out.println(sb);
    }

    private static void permutation(boolean[] choose, int count, int pre) {
        if (count == n / 2) {
            int sum1 = calculate(choose, true);
            int sum2 = calculate(choose, false);
            gap = Math.min(gap, Math.abs(sum1 - sum2));
            return;
        }

        for (int i = count; i < map.length; i++) {
            if (!choose[i] && pre < i) {
                choose[i] = true;
                permutation(choose, count + 1, i);
                choose[i] = false;
            }
        }
    }

    private static int calculate(boolean[] choose, boolean b) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < choose.length; i++) {
            if (choose[i] == b) {
                list.add(i);
            }
        }

        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int y = list.get(i);
                int x = list.get(j);
                sum += map[y][x] + map[x][y];
            }
        }

        return sum;
    }
}