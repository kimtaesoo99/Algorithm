import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int result = Integer.MAX_VALUE;
    private static boolean[] visited;
    private static List<int[]> home;
    private static List<int[]> chicken;
    private static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        M = sc.nextInt();

        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int info = sc.nextInt();
                if (info == 1) {
                    home.add(new int[]{i, j});
                }
                if (info == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[chicken.size()];

        combination(0, -1, new int[M]);

        System.out.println(result);
    }

    private static void combination(int index, int pre, int[] choice) {
        if (index == M) {
            result = Math.min(result, findDistance(choice));
            return;
        }

        for (int i = 0; i < chicken.size(); i++) {
            if (!visited[i] && i > pre) {
                visited[i] = true;
                choice[index] = i;
                combination(index + 1, i, choice);
                visited[i] = false;
            }
        }
    }

    private static int findDistance(int[] choice) {
        int sum = 0;
        for (int[] ints : home) {
            int min = Integer.MAX_VALUE;

            for (int c : choice) {
                int[] target = chicken.get(c);
                min = Math.min(min, Math.abs(ints[0] - target[0]) + Math.abs(ints[1] - target[1]));
            }
            sum += min;
        }
        return sum;
    }
}