import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer>[] list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            list[sc.nextInt()].add(sc.nextInt());
        }

        int[] inDegree = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            for (int link : list[i]) {
                inDegree[link]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int value = q.poll();
            System.out.print(value + " ");

            for (int link : list[value]) {
                inDegree[link]--;
                if (inDegree[link] == 0) {
                    q.offer(link);
                }
            }
        }
    }
}
