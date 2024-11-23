import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            int a = Integer.parseInt(line.split(" ")[0]);

            for (int j = 1; j <= a; j++) {
                q.offer(Integer.parseInt(line.split(" ")[j]));
            }

            if (a != 0) {
                continue;
            }

            if (q.isEmpty()) {
                sb.append("-1").append("\n");
            } else {
                sb.append(q.poll()).append("\n");
            }
        }
        System.out.println(sb);
    }
}