import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N, M;
    static int[][] map;
    static ArrayList<Point> person = new ArrayList<>();
    static ArrayList<Point> chicken = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static boolean[] open;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    person.add(new Point(i, j));
                }
                if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        open = new boolean[chicken.size()];

        DFS(0, 0);
        System.out.println(result);
    }

    public static void DFS(int start, int cnt) {
        if (cnt == M) {
            int sum = 0;
            for (Point point : person) {
                int minDistance = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int distance = Math.abs(point.x - chicken.get(j).x)
                                + Math.abs(point.y - chicken.get(j).y);

                        minDistance = Math.min(minDistance, distance);
                    }
                }
                sum += minDistance;
            }
            result = Math.min(result, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            DFS(i + 1, cnt + 1);
            open[i] = false;
        }
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
