import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Deque<Info> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            q.offer(new Info(sc.next(), sc.nextInt()));
        }

        while (q.size() != 1) {
            Info info = q.pollFirst();
            int count = info.num - 1;

            for (int i = 0; i < count; i++) {
                q.offer(q.pollFirst());
            }
            q.pollFirst();
        }

        System.out.println(q.peek().alpha);
    }
}

class Info {
    String alpha;
    int num;

    public Info(String alpha, int num) {
        this.alpha = alpha;
        this.num = num;
    }
}