import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int k = Integer.parseInt(str[1]);

		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			q.offer(i);
		}

		sb.append("<");

		while (!q.isEmpty()) {
			for (int i = 0; i < k - 1; i++) {
				Integer now = q.poll();
				q.offer(now);
			}
			sb.append(q.poll());
			if (!q.isEmpty()) {
				sb.append(", ");
			}
		}
		sb.append(">");

		System.out.println(sb);
	}
}