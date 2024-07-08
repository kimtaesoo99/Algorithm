import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * F층으로 이루어진 건물
 * 스타트링크가 있는곳은 G층임, 강호가 있는 곳은 S층이고 엘베를 타고 G에가려함
 * <p>
 * F, S, G, U , D,
 */

public class Main {

    private static int F;
    private static int S;
    private static int G;
    private static int U;
    private static int D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        int result = bfs();
        System.out.println(result == -1 ? "use the stairs" : result);
    }

    private static int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{S, 0});
        boolean[] visited = new boolean[F + 1];

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowFloor = now[0];

            if (nowFloor == G) {
                return now[1];
            }

            if (nowFloor + U <= F && !visited[nowFloor + U]) {
                visited[nowFloor + U] = true;
                q.offer(new int[]{nowFloor + U, now[1] + 1});
            }

            if (nowFloor - D > 0 && !visited[nowFloor - D]) {
                visited[nowFloor - D] = true;
                q.offer(new int[]{nowFloor - D, now[1] + 1});
            }
        }
        return -1;
    }
}