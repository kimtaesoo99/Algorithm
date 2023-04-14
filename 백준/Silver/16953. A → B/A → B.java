import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        System.out.println(bfs(A, B));
    }

    private static int bfs(long A, long B) {
        int count = 1;
        Queue<Long> q = new LinkedList<>();
        q.offer(A);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                long now = q.poll();
                if (now == B) {
                    return count;
                }
                if (now * 2 <= B) {
                    q.offer(now * 2);
                }
                if (now * 10 + 1 <= B) {
                    q.offer(now * 10 + 1);
                }
            }
            count++;
        }
        return -1;
    }
}